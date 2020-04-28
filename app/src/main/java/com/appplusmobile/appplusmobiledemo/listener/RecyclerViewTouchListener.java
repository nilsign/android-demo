package com.appplusmobile.appplusmobiledemo.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public final class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {

  private final OnCardClickListener listener;
  private final GestureDetector gestureDetector;

  public interface OnCardClickListener {
    void onClick(View view, int cardPosition);
  }

  public RecyclerViewTouchListener(Context context, OnCardClickListener listener) {
    this.listener = listener;
    gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
      @Override
      public boolean onSingleTapUp(MotionEvent event) {
        return true;
      }
    });
  }

  @Override
  public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent event) {
    View childView = view.findChildViewUnder(event.getX(), event.getY());
    if (childView != null && listener != null && gestureDetector.onTouchEvent(event)) {
      listener.onClick(childView, view.getChildAdapterPosition(childView));
      return true;
    }
    return false;
  }

  @Override
  public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

  @Override
  public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) { }
}
