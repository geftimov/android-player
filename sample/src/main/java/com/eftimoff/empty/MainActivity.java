package com.eftimoff.empty;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.eftimoff.androidplayer.actions.Actions;
import com.eftimoff.androidplayer.actions.PropertyAction;
import com.eftimoff.androidplayer.Player;
import com.eftimoff.androidplayer.listeners.PlayerEndListener;
import com.eftimoff.androidplayer.listeners.PlayerStartListener;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View view = findViewById(R.id.view);
        final View headerView = findViewById(R.id.header);
        final View viewSecond = findViewById(R.id.viewSecond);
        final View bottom = findViewById(R.id.bottom);

        final PropertyAction propertyAction = PropertyAction.newPropertyAction(view).fromTranslationX(-200).duration(750).interpolator(new AccelerateDecelerateInterpolator()).fromAlpha(0.4f).build();
        final PropertyAction headerPropertyAction = PropertyAction.newPropertyAction(headerView).interpolator(new DecelerateInterpolator()).fromTranslationY(-200).duration(3750).delay(1233).fromAlpha(0.4f).build();
        final PropertyAction viewSecondAction = PropertyAction.newPropertyAction(viewSecond).fromTranslationY(200).duration(750).fromAlpha(0f).build();
        final PropertyAction bottomPropertyAction = PropertyAction.newPropertyAction(bottom).fromScaleX(0.1f).fromScaleY(0.1f).fromTranslationX(-200).duration(2750).build();


        Player.with(view).
                setPlayerStartListener(playerStartListener).
                setPlayerEndListener(playerEndListener).
                animate(propertyAction).
                animate(headerPropertyAction).
                then().
                animate(Actions.scale(viewSecond, 0, 0)).
                then().
                animate(bottomPropertyAction).
                play();
    }

    private PlayerStartListener playerStartListener = new PlayerStartListener() {
        @Override
        public void onStart() {
            Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
        }
    };
    private PlayerEndListener playerEndListener = new PlayerEndListener() {
        @Override
        public void onEnd() {
            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_SHORT).show();
        }
    };
}
