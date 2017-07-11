package sasd97.java_blog.xyz.gaberlunzie.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by alexander on 11/07/2017.
 */

public class SwipeDetector implements View.OnTouchListener {

    public interface OnSwipeListener {
        void onSwipeRight();
        void onSwipeLeft();
        void onSwipeTop();
        void onSwipeBottom();
    }

    private GestureDetector gestureDetector;

    public SwipeDetector(@NonNull Context context,
                         @NonNull OnSwipeListener listener) {
        gestureDetector = new GestureDetector(context, new GestureListener(listener));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private static final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private OnSwipeListener listener;

        private GestureListener(@NonNull OnSwipeListener listener) {
            this.listener = listener;
        }

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();

                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) listener.onSwipeRight();
                        else listener.onSwipeLeft();
                        return true;
                    }
                    return false;
                }

                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) listener.onSwipeBottom();
                    else listener.onSwipeTop();
                    return true;
                }

                return false;
            } catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
    }
}
