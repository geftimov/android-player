package com.eftimoff.empty;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.eftimoff.androidplayer.actions.Actions;
import com.eftimoff.androidplayer.actions.arc.CurveAction;
import com.eftimoff.androidplayer.actions.property.PropertyAction;
import com.eftimoff.androidplayer.Player;
import com.eftimoff.androidplayer.listeners.PlayerEndListener;
import com.eftimoff.androidplayer.listeners.PlayerStartListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        final View view = findViewById(R.id.view);
        final View headerView = findViewById(R.id.header);
        final View viewSecond = findViewById(R.id.viewSecond);
        final View bottom = findViewById(R.id.bottom);

        final PropertyAction propertyAction = PropertyAction.newPropertyAction(view).translationX(-200).duration(750).interpolator(new AccelerateDecelerateInterpolator()).alpha(0.4f).build();
        final PropertyAction headerPropertyAction = PropertyAction.newPropertyAction(headerView).interpolator(new DecelerateInterpolator()).translationY(-200).duration(3750).delay(1233).alpha(0.4f).build();
        final PropertyAction viewSecondAction = PropertyAction.newPropertyAction(viewSecond).translationY(200).duration(750).alpha(0f).build();
        final PropertyAction bottomPropertyAction = PropertyAction.newPropertyAction(bottom).rotation(-180).scaleX(0.1f).scaleY(0.1f).translationX(-200).duration(750).build();
        final CurveAction curveAction = CurveAction.newControlPointsCurveAction(viewSecond).translationX(100).translationY(0).controlPoint1X(100).controlPoint1Y(55.5f).controlPoint2X(0).controlPoint2Y(55.5f).duration(2500).build();

        final CurveAction curve = Actions.curve(viewSecond, -100, 100);
        curve.setDuration(2500);
        Player.with(view).
                setPlayerStartListener(playerStartListener).
                setPlayerEndListener(playerEndListener).
                animate(propertyAction).
                animate(headerPropertyAction).
                then().
                animate(curve).
                then().
                animate(bottomPropertyAction).
                play();*/

        initDrawerLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.player_menu, menu);
        return true;
    }

    private PlayerStartListener playerStartListener = new PlayerStartListener() {
        @Override
        public void onStart() {
//            Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
        }
    };
    private PlayerEndListener playerEndListener = new PlayerEndListener() {
        @Override
        public void onEnd() {
//            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_SHORT).show();
        }
    };

    private void initDrawerLayout() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar supportActionBar = getSupportActionBar();
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activityMainDrawerLayout);
        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abc_toolbar_collapse_description,
                R.string.abc_toolbar_collapse_description);
        drawerToggle.setDrawerIndicatorEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeButtonEnabled(true);
        supportActionBar.setDisplayShowTitleEnabled(false);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }
}
