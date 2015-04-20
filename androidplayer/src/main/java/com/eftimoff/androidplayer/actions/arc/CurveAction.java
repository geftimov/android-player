package com.eftimoff.androidplayer.actions.arc;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;

import com.eftimoff.androidplayer.actions.BaseAction;

/**
 * Action that translate with curve
 * Created by georgi.eftimov on 4/20/2015.
 */
public class CurveAction extends BaseAction {

    public static final String PATH_POINT_LOCATION = "PathPointLocation";

    private float translationX;
    private float translationY;
    private float controlPoint1X;
    private float controlPoint1Y;
    private float controlPoint2X;
    private float controlPoint2Y;

    private AnimatorPath path;

    public CurveAction(View view) {
        super(view);
    }

    private CurveAction(Builder builder) {
        super(builder.view);
        setDuration(builder.duration);
        setDelay(builder.delay);
        setAnimateAlone(builder.animateAlone);
        setInterpolator(builder.interpolator);
        this.translationX = builder.translationX;
        this.translationY = builder.translationY;
        this.controlPoint1X = builder.controlPoint1X;
        this.controlPoint1Y = builder.controlPoint1Y;
        this.controlPoint2X = builder.controlPoint2X;
        this.controlPoint2Y = builder.controlPoint2Y;
    }

    public static Builder newCurveAction(final View view) {
        return new Builder(view);
    }

    @Override
    public void init(View view) {
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        path = new AnimatorPath();
        path.moveTo(translationX, translationY);
        path.curveTo(controlPoint1X, controlPoint1Y, controlPoint2X, controlPoint2Y, 0, 0);

    }

    @Override
    public void animate(View view) {
        final ObjectAnimator anim = ObjectAnimator.ofObject(this, PATH_POINT_LOCATION,
                new PathEvaluator(), path.getPoints().toArray());

        anim.setInterpolator(getInterpolator());
        anim.setDuration(getDuration());
        anim.start();
    }

    /**
     * We need this setter to translate between the information the animator
     * produces (a new "PathPoint" describing the current animated location)
     * and the information that the button requires (an xy location). The
     * setter will be called by the ObjectAnimator given the 'fabLoc'
     * property string.
     */
    public void setPathPointLocation(final PathPoint newLoc) {
        getView().setTranslationX(newLoc.mX);
        getView().setTranslationY(newLoc.mY);
    }


    public static final class Builder {
        private final View view;
        private boolean animateAlone;
        private int duration = 300;
        private int delay = 0;
        private TimeInterpolator interpolator = new AccelerateDecelerateInterpolator();
        private float translationX;
        private float translationY;
        private float controlPoint1X;
        private float controlPoint1Y;
        private float controlPoint2X;
        private float controlPoint2Y;

        private Builder(final View view) {
            this.view = view;
        }

        public CurveAction build() {
            return new CurveAction(this);
        }

        public Builder interpolator(TimeInterpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        public Builder animateAlone(final boolean shouldWait) {
            this.animateAlone = shouldWait;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder delay(int delay) {
            this.delay = delay;
            return this;
        }

        public Builder translationX(float translationX) {
            this.translationX = translationX;
            return this;
        }

        public Builder translationY(float translationY) {
            this.translationY = translationY;
            return this;
        }

        public Builder controlPoint1X(float controlPoint1X) {
            this.controlPoint1X = controlPoint1X;
            return this;
        }

        public Builder controlPoint1Y(float controlPoint1Y) {
            this.controlPoint1Y = controlPoint1Y;
            return this;
        }

        public Builder controlPoint2X(float controlPoint2X) {
            this.controlPoint2X = controlPoint2X;
            return this;
        }

        public Builder controlPoint2Y(float controlPoint2Y) {
            this.controlPoint2Y = controlPoint2Y;
            return this;
        }
    }
}
