package com.eftimoff.androidplayer.actions;

import android.view.View;

/**
 * Animation action for a view.
 * <p/>
 * Created by georgi.eftimov on 4/15/2015.
 */
public interface Action {

    void init(final View view);

    void animate(final View view);
}
