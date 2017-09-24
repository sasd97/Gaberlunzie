package sasd97.java_blog.xyz.gaberlunzie.presentation.main;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.sasd97.lib_router.Router;

import javax.inject.Inject;
import javax.inject.Named;

import sasd97.java_blog.xyz.gaberlunzie.presentation.setup.SetupFragment;

import static com.github.sasd97.lib_router.commands.fragments.Replace.replace;
import static sasd97.java_blog.xyz.gaberlunzie.di.modules.NavigationModule.FRAGMENT_ROUTER;

/**
 * Created by alexander on 11/07/2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Router fragmentRouter;

    @Inject
    public MainPresenter(@NonNull @Named(FRAGMENT_ROUTER) Router fragmentRouter) {
        this.fragmentRouter = fragmentRouter;
    }

    public void openSetup() {
        fragmentRouter.pushCommand(replace(new SetupFragment(), null));
    }
}
