package com.example.animationapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Slide());
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        Bundle animationBundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent, animationBundle);
    }
}
