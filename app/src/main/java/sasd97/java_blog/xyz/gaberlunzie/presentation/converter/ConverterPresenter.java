package sasd97.java_blog.xyz.gaberlunzie.presentation.converter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import sasd97.java_blog.xyz.gaberlunzie.navigation.Router;
import sasd97.java_blog.xyz.gaberlunzie.navigation.fragments.FragmentCommand;
import sasd97.java_blog.xyz.gaberlunzie.navigation.fragments.FragmentCommandDecorator;
import sasd97.java_blog.xyz.gaberlunzie.navigation.fragments.Replace;
import sasd97.java_blog.xyz.gaberlunzie.presentation.setup.SetupFragment;
import sasd97.java_blog.xyz.gaberlunzie.utils.SwipeDetector;

/**
 * Created by alexander on 11/07/2017.
 */

@InjectViewState
public class ConverterPresenter extends MvpPresenter<ConverterView> {

    private Router<FragmentCommand> router;

    public void setRouter(Router<FragmentCommand> router) {
        this.router = router;
    }

    public void openSetup() {
        FragmentCommandDecorator fragmentCommand = new Replace(SetupFragment.getInstance());
        router.pushForward(fragmentCommand);
    }
}
