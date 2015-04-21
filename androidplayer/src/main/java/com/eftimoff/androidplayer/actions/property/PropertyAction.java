package com.eftimoff.androidplayer.actions.property;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androidplayer.actions.BaseAction;

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
    private float fromRotation;
    private float toRotation;


    @Override
    public void init(View view) {
        setToTranslationX(view.getTranslationX());
        view.setTranslationX(getTranslationX());
        setToTranslationY(view.getTranslationY());
        view.setTranslationY(getTranslationY());
        setToScaleX(view.getScaleX());
        view.setScaleX(getScaleX());
        setToScaleY(view.getScaleY());
        view.setScaleY(getScaleY());
        setToAlpha(view.getAlpha());
        view.setAlpha(getAlpha());
        setToRotation(view.getRotation());
        view.setRotation(getRotation());
    }

    @Override
    public void animate(View view) {
        view.animate().
                translationX(toTranslationX).
                translationY(toTranslationY).
                scaleY(toScaleY).
                scaleX(toScaleX).
                alpha(toAlpha).
                rotation(toRotation).
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
        setInterpolator(builder.interpolator);
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
        this.fromRotation = builder.rotation;
    }

    public static Builder newPropertyAction(final View view) {
        return new Builder(view);
    }

    public float getTranslationX() {
        return fromTranslationX;
    }

    private void setFromTranslationX(float fromTranslationX) {
        this.fromTranslationX = fromTranslationX;
    }

    private void setToTranslationX(float toTranslationX) {
        this.toTranslationX = toTranslationX;
    }

    public float getTranslationY() {
        return fromTranslationY;
    }

    private void setFromTranslationY(float fromTranslationY) {
        this.fromTranslationY = fromTranslationY;
    }


    private void setToTranslationY(float toTranslationY) {
        this.toTranslationY = toTranslationY;
    }

    public float getScaleY() {
        return fromScaleY;
    }

    private void setFromScaleY(float fromScaleY) {
        this.fromScaleY = fromScaleY;
    }

    private void setToScaleY(float toScaleY) {
        this.toScaleY = toScaleY;
    }

    public float getScaleX() {
        return fromScaleX;
    }

    private void setFromScaleX(float fromScaleX) {
        this.fromScaleX = fromScaleX;
    }


    private void setToScaleX(float toScaleX) {
        this.toScaleX = toScaleX;
    }

    public float getAlpha() {
        return fromAlpha;
    }

    private void setFromAlpha(float fromAlpha) {
        this.fromAlpha = fromAlpha;
    }


    private void setToAlpha(float toAlpha) {
        this.toAlpha = toAlpha;
    }

    private void setToRotation(float toRotation) {
        this.toRotation = toRotation;
    }

    public float getRotation() {
        return fromRotation;
    }

    private void setFromRotation(float fromRotation) {
        this.fromRotation = fromRotation;
    }

    public static final class Builder {
        private View view;
        private boolean animateAlone;
        private int duration = 300;
        private int delay = 0;
        private TimeInterpolator interpolator = new AccelerateDecelerateInterpolator();
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
        private float rotation;

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

        public Builder translationX(float fromTranslationX) {
            this.fromTranslationX = fromTranslationX;
            return this;
        }

        public Builder translationY(float fromTranslationY) {
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

        public Builder rotation(final float rotation) {
            this.rotation = rotation;
            return this;
        }
    }
}
