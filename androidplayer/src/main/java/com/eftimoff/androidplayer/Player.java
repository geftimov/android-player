package com.eftimoff.androidplayer;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

import com.eftimoff.androidplayer.actions.BaseAction;
import com.eftimoff.androidplayer.listeners.PlayerEndListener;
import com.eftimoff.androidplayer.listeners.PlayerStartListener;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that runs all the animations.
 * <p/>
 * Created by georgi.eftimov on 4/15/2015.
 */
public class Player {

    private List<List<BaseAction>> list;
    private View view;
    private PlayerStartListener playerStartListener;
    private PlayerEndListener playerEndListener;
    final Handler handler = new Handler();

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
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                initAll();
                animateAll();
                return true;
            }
        });
    }

    private void initAll() {
        for (final List<BaseAction> baseActions : list) {
            for (final BaseAction baseAction : baseActions) {
                final View view = baseAction.getView();
                baseAction.init(view);
            }
        }
    }

    private void animateAll() {
        if (playerStartListener != null) {
            playerStartListener.onStart();
        }
        int durationCounter = 0;
        for (int i = 0; i < list.size(); i++) {
            final List<BaseAction> baseActions = list.get(i);
            final int longestDuration = getLongestDuration(baseActions);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animateAllBaseActions(baseActions);
                }
            }, durationCounter);
            durationCounter += longestDuration;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (playerEndListener != null) {
                    playerEndListener.onEnd();
                }
            }
        }, durationCounter);
    }

    private int getLongestDuration(final List<BaseAction> actions) {
        int maxDuration = 0;
        for (final BaseAction action : actions) {
            if (action.getDuration() > maxDuration) {
                maxDuration = action.getDuration() + action.getDelay();
            }
        }
        return maxDuration;
    }

    private void animateAllBaseActions(final List<BaseAction> actions) {
        for (final BaseAction action : actions) {
            final View view = action.getView();
            action.animate(view);
        }
    }

    public Player setPlayerStartListener(final PlayerStartListener playerStartListener) {
        this.playerStartListener = playerStartListener;
        return this;
    }

    public Player setPlayerEndListener(final PlayerEndListener playerEndListener) {
        this.playerEndListener = playerEndListener;
        return this;
    }
}
