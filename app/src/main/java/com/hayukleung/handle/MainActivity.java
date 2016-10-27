package com.hayukleung.handle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Handle
 * com.hayukleung.handle
 * MainActivity.java
 *
 * by hayukleung
 * at 2016-10-27 15:59
 */

public class MainActivity extends AppCompatActivity
    implements HandleView.HandleReaction, View.OnTouchListener {

  private float[] mTouchPosition = null;
  private HandleView mHandleView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
    frameLayout.setOnTouchListener(this);
    mHandleView = (HandleView) findViewById(R.id.handleView);
    mHandleView.setHandleReaction(this);
  }

  @Override public boolean onTouch(View view, MotionEvent motionEvent) {
    switch (motionEvent.getAction()) {
      case MotionEvent.ACTION_DOWN:
      case MotionEvent.ACTION_MOVE: {
        mTouchPosition = new float[2];
        mTouchPosition[0] = motionEvent.getX();
        mTouchPosition[1] = motionEvent.getY();
        mHandleView.invalidate();
        return true;
      }
      case MotionEvent.ACTION_UP: {
        mTouchPosition = null;
        mHandleView.invalidate();
        return true;
      }
    }
    return false;
  }

  @Override public float[] getTouchPosition() {
    return mTouchPosition;
  }
}
