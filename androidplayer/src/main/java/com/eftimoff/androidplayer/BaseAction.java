package com.eftimoff.androidplayer;

import android.view.View;

/**
 * Created by georgi.eftimov on 4/15/2015.
 */
public abstract class BaseAction implements Action {

    private View view;
    private int duration = 300;
    private int delay = 0;

    public BaseAction(final View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public int getDuration() {
        return duration;
    }

    public int getDelay() {
        return delay;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}