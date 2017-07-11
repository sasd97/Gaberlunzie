package sasd97.java_blog.xyz.gaberlunzie.presentation.splashscreen;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import sasd97.java_blog.xyz.gaberlunzie.GaberlunzieApp;
import sasd97.java_blog.xyz.gaberlunzie.navigation.activities.ActivityCommand;
import sasd97.java_blog.xyz.gaberlunzie.navigation.activities.ActivityCommandDecorator;
import sasd97.java_blog.xyz.gaberlunzie.navigation.activities.Finish;
import sasd97.java_blog.xyz.gaberlunzie.navigation.activities.MoveForward;
import sasd97.java_blog.xyz.gaberlunzie.presentation.MainActivity;

/**
 * Created by alexander on 11/07/2017.
 */

public class SplashScreenActivity
        extends MvpAppCompatActivity
        implements SplashScreenView {

    @InjectPresenter SplashScreenPresenter presenter;

    @ProvidePresenter
    public SplashScreenPresenter providePresenter() {
        return GaberlunzieApp.get(this)
                .getAppComponent()
                .plusSplashScreenComponent()
                .provideSplashScreenPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLoad();
    }

    private void onLoad() {
        presenter.navigateTo(obtainNavigationCommand());
    }

    private ActivityCommand obtainNavigationCommand() {
        ActivityCommandDecorator command = new MoveForward(this, MainActivity.class);
        command.setNext(new Finish(this));
        return command;
    }
}
