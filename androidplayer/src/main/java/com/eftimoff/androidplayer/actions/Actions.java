package com.eftimoff.androidplayer.actions;

import android.view.View;

/**
 * Collection of common actions.
 * <p/>
 * Created by georgi.eftimov on 4/16/2015.
 */
public class Actions {

    private Actions() {
    }

    public static PropertyAction x(final View view, final int x) {
        return PropertyAction.newPropertyAction(view).translationX(x).build();
    }

    public static PropertyAction y(final View view, final int y) {
        return PropertyAction.newPropertyAction(view).translationY(y).build();
    }

    public static PropertyAction scale(final View view, final int x, final int y) {
        return PropertyAction.newPropertyAction(view).scaleX(x).scaleY(y).build();
    }

    public static PropertyAction alpha(final View view, final float alpha) {
        return PropertyAction.newPropertyAction(view).alpha(alpha).build();
    }
}
