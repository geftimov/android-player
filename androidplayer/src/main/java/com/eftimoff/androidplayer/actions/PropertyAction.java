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
                translationX(getToTranslationX()).
                translationY(getToTranslationY()).
                scaleY(getToScaleY()).
                scaleX(getToScaleX()).
                alpha(getToAlpha()).
                setDuration(getDuration()).
                setStartDelay(getDelay()).
                setInterpolator(getInterpolator()).
                start();
    }

    private PropertyAction(Builder builder) {
        super(builder.view);
        setDuration(builder.duration);
        setDelay(builder.delay);
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

    public void setFromTranslationX(float fromTranslationX) {
        this.fromTranslationX = fromTranslationX;
    }

    public float getToTranslationX() {
        return toTranslationX;
    }

    public void setToTranslationX(float toTranslationX) {
        this.toTranslationX = toTranslationX;
    }

    public float getFromTranslationY() {
        return fromTranslationY;
    }

    public void setFromTranslationY(float fromTranslationY) {
        this.fromTranslationY = fromTranslationY;
    }

    public float getToTranslationY() {
        return toTranslationY;
    }

    public void setToTranslationY(float toTranslationY) {
        this.toTranslationY = toTranslationY;
    }

    public float getFromScaleY() {
        return fromScaleY;
    }

    public void setFromScaleY(float fromScaleY) {
        this.fromScaleY = fromScaleY;
    }

    public float getToScaleY() {
        return toScaleY;
    }

    public void setToScaleY(float toScaleY) {
        this.toScaleY = toScaleY;
    }

    public float getFromScaleX() {
        return fromScaleX;
    }

    public void setFromScaleX(float fromScaleX) {
        this.fromScaleX = fromScaleX;
    }

    public float getToScaleX() {
        return toScaleX;
    }

    public void setToScaleX(float toScaleX) {
        this.toScaleX = toScaleX;
    }

    public float getFromAlpha() {
        return fromAlpha;
    }

    public void setFromAlpha(float fromAlpha) {
        this.fromAlpha = fromAlpha;
    }

    public float getToAlpha() {
        return toAlpha;
    }

    public void setToAlpha(float toAlpha) {
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

        public Builder fromTranslationX(int fromTranslationX) {
            this.fromTranslationX = fromTranslationX;
            return this;
        }

        public Builder toTranslationX(int toTranslationX) {
            this.toTranslationX = toTranslationX;
            return this;
        }

        public Builder fromTranslationY(int fromTranslationY) {
            this.fromTranslationY = fromTranslationY;
            return this;
        }

        public Builder toTranslationY(int toTranslationY) {
            this.toTranslationY = toTranslationY;
            return this;
        }

        public Builder fromScaleY(float fromScaleY) {
            this.fromScaleY = fromScaleY;
            return this;
        }

        public Builder toScaleY(float toScaleY) {
            this.toScaleY = toScaleY;
            return this;
        }

        public Builder fromScaleX(float fromScaleX) {
            this.fromScaleX = fromScaleX;
            return this;
        }

        public Builder toScaleX(float toScaleX) {
            this.toScaleX = toScaleX;
            return this;
        }

        public Builder fromAlpha(float fromAlpha) {
            this.fromAlpha = fromAlpha;
            return this;
        }

        public Builder toAlpha(float toAlpha) {
            this.toAlpha = toAlpha;
            return this;
        }

        public Builder interpolator(TimeInterpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }
    }
}
