package com.eftimoff.androidplayer.actions;

import android.animation.TimeInterpolator;
import android.view.View;

/**
 * Action that animates the properties of the view.
 * <p/>
 * Created by georgi.eftimov on 4/15/2015.
 */
public class PropertyAction extends BaseAction {

    private float fromTranslationX = 0;
    private float toTranslationX = 0;
    private float fromTranslationY = 0;
    private float toTranslationY = 0;
    private float fromScaleY = 1f;
    private float toScaleY = 1f;
    private float fromScaleX = 1f;
    private float toScaleX = 1f;
    private float fromAlpha = 1f;
    private float toAlpha = 1f;
    private TimeInterpolator interpolator;


    @Override
    public void init(View view) {
        setToTranslationX(view.getTranslationX());
        view.setTranslationX(getFromTranslationX());
        setToTranslationY(view.getTranslationY());
        view.setTranslationY(getFromTranslationY());
        setToScaleX(view.getScaleX());
        view.setScaleX(getFromScaleX());
        setToScaleY(view.getScaleY());
        view.setScaleY(getFromScaleY());
        setToAlpha(view.getAlpha());
        view.setAlpha(getFromAlpha());
    }

    @Override
    public void animate(View view) {
        view.animate().
                translationX(toTranslationX).
                translationY(toTranslationY).
                scaleY(toScaleY).
                scaleX(toScaleY).
                alpha(toAlpha).
                setDuration(getDuration()).
                setStartDelay(getDelay()).
                setInterpolator(getInterpolator()).
                start();
    }

    private PropertyAction(Builder builder) {
        super(builder.view);
        setDuration(builder.duration);
        setDelay(builder.delay);
        setAnimateAlone(builder.animateAlone);
        this.fromTranslationX = builder.fromTranslationX;
        this.toTranslationX = builder.toTranslationX;
        this.fromTranslationY = builder.fromTranslationY;
        this.toTranslationY = builder.toTranslationY;
        this.fromScaleY = builder.fromScaleY;
        this.toScaleY = builder.toScaleY;
        this.fromScaleX = builder.fromScaleX;
        this.toScaleX = builder.toScaleX;
        this.fromAlpha = builder.fromAlpha;
        this.toAlpha = builder.toAlpha;
        this.interpolator = builder.interpolator;
    }

    public static Builder newPropertyAction(final View view) {
        return new Builder(view);
    }

    public float getFromTranslationX() {
        return fromTranslationX;
    }

    private void setFromTranslationX(float fromTranslationX) {
        this.fromTranslationX = fromTranslationX;
    }

    private void setToTranslationX(float toTranslationX) {
        this.toTranslationX = toTranslationX;
    }

    public float getFromTranslationY() {
        return fromTranslationY;
    }

    private void setFromTranslationY(float fromTranslationY) {
        this.fromTranslationY = fromTranslationY;
    }


    private void setToTranslationY(float toTranslationY) {
        this.toTranslationY = toTranslationY;
    }

    public float getFromScaleY() {
        return fromScaleY;
    }

    private void setFromScaleY(float fromScaleY) {
        this.fromScaleY = fromScaleY;
    }

    private void setToScaleY(float toScaleY) {
        this.toScaleY = toScaleY;
    }

    public float getFromScaleX() {
        return fromScaleX;
    }

    private void setFromScaleX(float fromScaleX) {
        this.fromScaleX = fromScaleX;
    }


    private void setToScaleX(float toScaleX) {
        this.toScaleX = toScaleX;
    }

    public float getFromAlpha() {
        return fromAlpha;
    }

    private void setFromAlpha(float fromAlpha) {
        this.fromAlpha = fromAlpha;
    }


    private void setToAlpha(float toAlpha) {
        this.toAlpha = toAlpha;
    }

    public TimeInterpolator getInterpolator() {
        return interpolator;
    }

    public void setInterpolator(TimeInterpolator interpolator) {
        this.interpolator = interpolator;
    }

    public static final class Builder {
        private View view;
        private boolean animateAlone;
        private int duration = 300;
        private int delay = 0;
        private int fromTranslationX = 0;
        private int toTranslationX = 0;
        private int fromTranslationY = 0;
        private int toTranslationY = 0;
        private float fromScaleY = 1f;
        private float toScaleY = 1f;
        private float fromScaleX = 1f;
        private float toScaleX = 1f;
        private float fromAlpha = 1f;
        private float toAlpha = 1f;
        private TimeInterpolator interpolator;

        private Builder(final View view) {
            this.view = view;
        }

        public PropertyAction build() {
            return new PropertyAction(this);
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder delay(int delay) {
            this.delay = delay;
            return this;
        }

        public Builder translationX(int fromTranslationX) {
            this.fromTranslationX = fromTranslationX;
            return this;
        }

        public Builder translationY(int fromTranslationY) {
            this.fromTranslationY = fromTranslationY;
            return this;
        }


        public Builder scaleY(float fromScaleY) {
            this.fromScaleY = fromScaleY;
            return this;
        }


        public Builder scaleX(float fromScaleX) {
            this.fromScaleX = fromScaleX;
            return this;
        }

        public Builder alpha(float fromAlpha) {
            this.fromAlpha = fromAlpha;
            return this;
        }

        public Builder interpolator(TimeInterpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        public Builder animateAlone(final boolean shouldWait) {
            this.animateAlone = shouldWait;
            return this;
        }
    }
}
