package com.eftimoff.androidplayer;

import android.view.View;

/**
 * Action that animates the properties of the view.
 * <p/>
 * Created by georgi.eftimov on 4/15/2015.
 */
public class PropertyAction extends BaseAction {


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


    @Override
    public void animate(View view) {
        view.setTranslationX(getFromTranslationX());
        view.setTranslationY(getFromTranslationY());
        view.setScaleX(getFromScaleX());
        view.setScaleY(getFromScaleY());
        view.setAlpha(getFromAlpha());
        view.animate().
                translationX(getToTranslationX()).
                translationY(getToTranslationY()).
                scaleY(getToScaleY()).
                scaleX(getToScaleX()).
                alpha(getToAlpha()).
                setDuration(getDuration()).
                setStartDelay(getDelay()).
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
    }

    public static Builder newPropertyAction(final View view) {
        return new Builder(view);
    }

    public int getFromTranslationX() {
        return fromTranslationX;
    }

    public int getToTranslationX() {
        return toTranslationX;
    }

    public int getFromTranslationY() {
        return fromTranslationY;
    }

    public int getToTranslationY() {
        return toTranslationY;
    }

    public float getFromScaleY() {
        return fromScaleY;
    }

    public float getToScaleY() {
        return toScaleY;
    }

    public float getFromScaleX() {
        return fromScaleX;
    }

    public float getToScaleX() {
        return toScaleX;
    }

    public float getFromAlpha() {
        return fromAlpha;
    }

    public float getToAlpha() {
        return toAlpha;
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
    }
}
