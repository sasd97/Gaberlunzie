package sasd97.java_blog.xyz.gaberlunzie.presentation.setup;

import android.util.Log;

import com.arellomobile.mvp.MvpPresenter;

import sasd97.java_blog.xyz.gaberlunzie.utils.SwipeDetector;

/**
 * Created by alexander on 11/07/2017.
 */

public class SetupPresenter extends MvpPresenter<SetupView>
        implements SwipeDetector.OnSwipeListener {

    private static final String TAG = SetupPresenter.class.getCanonicalName();

    @Override
    public void onSwipeRight() {
        Log.d(TAG, "Swipe Right");
    }

    @Override
    public void onSwipeLeft() {
        Log.d(TAG, "Swipe Left");
    }

    @Override
    public void onSwipeTop() {
        Log.d(TAG, "Swipe Top");
    }

    @Override
    public void onSwipeBottom() {
        Log.d(TAG, "Swipe Bottom");
    }
}
