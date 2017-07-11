package sasd97.java_blog.xyz.gaberlunzie.presentation.splashscreen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import sasd97.java_blog.xyz.gaberlunzie.navigation.Router;
import sasd97.java_blog.xyz.gaberlunzie.navigation.activities.ActivityCommand;

/**
 * Created by alexander on 11/07/2017.
 */

@InjectViewState
public class SplashScreenPresenter extends MvpPresenter<SplashScreenView> {

    private Router<ActivityCommand> router;

    public SplashScreenPresenter(Router<ActivityCommand> router) {
        this.router = router;
    }

    public void navigateTo(ActivityCommand command) {
        router.pushForward(command);
    }
}
