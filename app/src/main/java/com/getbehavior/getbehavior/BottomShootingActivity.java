package com.getbehavior.getbehavior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class BottomShootingActivity extends AppCompatActivity {

    private View coverage;
    private ViewPropertyAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_shooting);
        coverage = findViewById(R.id.coverage);

        animator = coverage
                .animate()
                .rotation(36000000)
                .setDuration(3600000);
        animator
                .start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animator.cancel();
    }
}
