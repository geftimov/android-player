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

    public static CurveAction curve(final View view, final float x, final float y) {
        final float base = abstand(view.getX(), view.getY(), x, y);
        final float heightOfTriangle = getHeightOfTriangle(base, 165);
        float x1 = -x;
        float y1 = y + Math.abs(x);
        float x2 = Math.abs(y);
        float y2 = Math.abs(x);

        final float x3 = getX(heightOfTriangle / base, x, x1);
        final float y3 = getY(heightOfTriangle / base, y, y1);
        final float x4 = getX(heightOfTriangle / base, view.getX(), x2);
        final float y4 = getY(heightOfTriangle / base, view.getY(), y2);
        return CurveAction.newControlPointsCurveAction(view).translationX(x).translationY(y).controlPoint1X(x3).controlPoint1Y(y3).controlPoint2X(x4).controlPoint2Y(y4).build();
    }

    private static float getX(float alpha, float x1, float x2) {
        return (1 - alpha) * x1 + alpha * x2;
    }

    private static float getY(float alpha, float y1, float y2) {
        return (1 - alpha) * y1 + alpha * y2;
    }

    private static float getHeightOfTriangle(final float base, final float baseDegree) {
        return (float) (base / (2 * Math.tan(Math.toRadians(baseDegree / 2))));
    }

    private static float getAngle(final float x, final float y) {
        float angle = (float) Math.toDegrees(Math.atan2(y, x));
        if (angle < 0) {
            angle += 360;
        }
        return angle;
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
