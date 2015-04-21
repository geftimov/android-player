package com.eftimoff.androidplayer.actions;

import android.view.View;

import com.eftimoff.androidplayer.actions.arc.CurveAction;
import com.eftimoff.androidplayer.actions.property.PropertyAction;

/**
 * Collection of common actions.
 * <p/>
 * Created by georgi.eftimov on 4/16/2015.
 */
public class Actions {

    private Actions() {
    }

    public static PropertyAction x(final View view, final float x) {
        return PropertyAction.newPropertyAction(view).translationX(x).build();
    }

    public static PropertyAction y(final View view, final float y) {
        return PropertyAction.newPropertyAction(view).translationY(y).build();
    }

    public static PropertyAction scale(final View view, final float x, final float y) {
        return PropertyAction.newPropertyAction(view).scaleX(x).scaleY(y).build();
    }

    public static PropertyAction alpha(final View view, final float alpha) {
        return PropertyAction.newPropertyAction(view).alpha(alpha).build();
    }

    public static CurveAction curve(final View view, final float x, final float y, final int degree) {
        final float base = abstand(view.getX(), view.getY(), x, y);
        final float heightOfTriangle = 50;
        final float xCoordinate = getXCoordinate(x / 2, heightOfTriangle, 90 - degree / 2);
        final float yCoordinate = getYCoordinate(y / 2, heightOfTriangle, 90 - degree / 2);
        return CurveAction.newControlPointsCurveAction(view).translationX(x).translationY(y).controlPoint1X(getXCoordinate(x, heightOfTriangle, degree)).controlPoint1Y(getYCoordinate(y, heightOfTriangle, degree)).controlPoint2X(getXCoordinate(view.getX(), heightOfTriangle, degree)).controlPoint2Y(getYCoordinate(view.getY(), heightOfTriangle, degree)).build();
    }

    private static float getHeightOfTriangle(final float base, final float baseDegree) {
        return (float) ((base / 2) * Math.tan(Math.toRadians(baseDegree)));
    }

    private static float getBaseOfRightTriangle(final float side) {
        return (float) Math.sqrt(2) * side;
    }

    private static float getXCoordinate(final float x, final float distance, final float angle) {
        return (float) (x + distance * (Math.cos(Math.toRadians(angle))));
    }

    private static float getYCoordinate(final float y, final float distance, final float angle) {
        return (float) (y + distance * (Math.sin(Math.toRadians(angle))));
    }

    private static float abstand(final float point1X, final float point1Y, final float point2X, final float point2Y) {
        return (float) Math.sqrt((point1X - point2X) * (point1X - point2X) + (point1Y - point2Y) * (point1Y - point2Y));
    }
}
