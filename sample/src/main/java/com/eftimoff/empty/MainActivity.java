package com.eftimoff.empty;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.eftimoff.androidplayer.BaseAction;
import com.eftimoff.androidplayer.PropertyAction;
import com.eftimoff.androidplayer.Player;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View view = findViewById(R.id.view);
        final View headerView = findViewById(R.id.header);

        final BaseAction propertyAction = PropertyAction.newPropertyAction(view).fromTranslationX(-200).duration(750).fromAlpha(0.4f).build();
        final PropertyAction headerPropertyAction = PropertyAction.newPropertyAction(headerView).fromTranslationY(-200).duration(750).fromAlpha(0.4f).build();

        Player.with(view).
                animate(propertyAction).
                animate(headerPropertyAction).
//                animate(new DummyAction(view)).
//                then().
//                animate(new DummyAction(view)).
        play();
    }
}
