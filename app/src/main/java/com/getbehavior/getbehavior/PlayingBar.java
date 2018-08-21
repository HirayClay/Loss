package com.getbehavior.getbehavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class PlayingBar extends FrameLayout {


    class PlayClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            playing = !playing;
            playBtn.setImageResource(playing ? R.mipmap.playing : R.mipmap.pause);
            animateSpeecher();
        }
    }

    //默认使用这个控件时候，正在播放。
    boolean playing = true;
    boolean hidden = false;
    ImageView playBtn;
    View closeBtn;
    View upBtn;
    View animateSpeecher;

    public PlayingBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        layoutInflater.inflate(R.layout.playingbar_layout, this, true);
        playBtn = findViewById(R.id.play_btn);
        closeBtn = findViewById(R.id.close_btn);
        animateSpeecher = findViewById(R.id.animate_speecher);
        upBtn = findViewById(R.id.up);
        playBtn.setOnClickListener(new PlayClickListener());
    }

    private void animateSpeecher() {
        float distanceToAnimate = closeBtn.getWidth();
        if (playing)
            distanceToAnimate = 0;


        animateSpeecher
                .animate()
                .translationX(distanceToAnimate)
                .setDuration(249)
                .start();

    }

    public void setOnUpClickListener(OnClickListener listener) {
        upBtn.setOnClickListener(listener);
    }

    public void hide() {
        if (hidden)
            return;
        animate().translationY(getTop() + getHeight())
                .setDuration(249)
                .start();

    }

    public void show() {
        if (!hidden)
            return;
        animate().translationY(getTop() - getHeight())
                .setDuration(249)
                .start();

    }


}
