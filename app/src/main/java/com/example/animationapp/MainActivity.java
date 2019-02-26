package com.example.animationapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    Scene aScene;
    Scene anotherScene;
    private boolean flip = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setEnterTransition(new Slide());
        getWindow().setExitTransition(new Fade());
    }

    public void bonkButton(View v) {
        if (this.flip) {
            this.scene1();
        } else {
            this.scene2();
        }

        this.flip = !this.flip;
    }

    private void scene1() {
        ViewGroup sceneRoot = findViewById(R.id.scene_root);
        aScene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene, this);

        Transition fadeTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade_transition);

        Transition change = new ChangeBounds();

        TransitionManager.go(aScene, fadeTransition);

    }

    private void scene2() {
        ViewGroup sceneRoot = findViewById(R.id.scene_root);

        Scene initialScene = new Scene(sceneRoot);

        aScene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene, this);
        anotherScene = Scene.getSceneForLayout(sceneRoot, R.layout.another_scene, this);

        Transition change = new ChangeBounds();

        Transition change2 = new Slide();

//        aScene.enter();

        TransitionManager.go(anotherScene, change2);


//         or Transition dynTransition = new Fade();

//        TransitionManager.go(anotherScene, fadeTransition);


//        aScene.setEnterAction(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });



    }

    public void goFwd(View v) {


        Bundle animationBundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        Intent intent = new Intent(this, TransitionActivity.class);
        startActivity(intent, animationBundle);
    }
}
