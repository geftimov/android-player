package com.eftimoff.androidplayer;

import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that runs all the animations.
 * <p/>
 * Created by georgi.eftimov on 4/15/2015.
 */
public class Player {

    private final List<List<BaseAction>> list;
    private final View view;

    private Player(final View view) {
        list = new ArrayList<List<BaseAction>>();
        list.add(new ArrayList<BaseAction>());
        this.view = view;

    }

    public static Player with(final View view) {
        return new Player(view);
    }


    public Player animate(final BaseAction action) {
        final List<BaseAction> peek = list.get(list.size() - 1);
        if (peek == null) {
            throw new IllegalArgumentException("There is no actions.");
        }
        peek.add(action);
        return this;
    }

    public Player then() {
        list.add(new ArrayList<BaseAction>());
        return this;
    }

    public void play() {
        Log.i("!!!!", "Queue size : " + list.size());
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                animateAll();
                return true;
            }
        });

    }

    private void animateAll() {
        for (final List<BaseAction> actions : list) {
            for (final BaseAction action : actions) {
                final View view = action.getView();
                action.animate(view);
            }
        }
    }

    private int getLongestDuration(final List<BaseAction> actions) {
        int maxDuration = 0;
        for (final BaseAction action : actions) {
            if (action.getDuration() > maxDuration) {
                maxDuration = action.getDuration();
            }
        }
        return maxDuration;
    }
}
