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
    private PlayerStartListener playerStartListener;
    private PlayerEndListener playerEndListener;
    private int loopTime = -1;

    final Handler handler = new Handler();

    private Player() {
        list = new ArrayList<List<BaseAction>>();
        list.add(new ArrayList<BaseAction>());
    }

    public static Player init() {
        return new Player();
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

    /**
     * Loop animation
     * @param loopTime 0 if infinity loop
     */
    public Player loop(int loopTime) {
        this.loopTime = loopTime;
        return this;
    }

    public void play() {
        final View firstView = getFirstView();
        if (firstView == null) {
            return;
        }
        firstView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                firstView.getViewTreeObserver().removeOnPreDrawListener(this);
                initAll();
                animateAll();
                return true;
            }
        });
    }

    private View getFirstView() {
        final List<BaseAction> baseActions = list.get(0);
        if (baseActions != null) {
            final BaseAction baseAction = baseActions.get(0);
            if (baseAction != null) {
                return baseAction.getView();
            }
        }
        return null;
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
                if (loopTime > 0) {
                    --loopTime;
                }
                if (loopTime != 0) {
                    animateAll();
                }
            }
        }, durationCounter);
    }

    private int getLongestDuration(final List<BaseAction> actions) {
        int maxDuration = 0;
        for (final BaseAction action : actions) {
            if (!action.isAnimateAlone() && action.getDuration() > maxDuration) {
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
