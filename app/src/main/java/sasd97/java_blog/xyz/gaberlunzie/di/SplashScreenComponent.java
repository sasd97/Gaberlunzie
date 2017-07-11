package sasd97.java_blog.xyz.gaberlunzie.di;

import dagger.Subcomponent;
import sasd97.java_blog.xyz.gaberlunzie.di.modules.SplashScreenModule;
import sasd97.java_blog.xyz.gaberlunzie.di.scopes.SplashScreenScope;
import sasd97.java_blog.xyz.gaberlunzie.presentation.splashscreen.SplashScreenActivity;
import sasd97.java_blog.xyz.gaberlunzie.presentation.splashscreen.SplashScreenPresenter;

/**
 * Created by alexander on 11/07/2017.
 */

@Subcomponent(modules = {SplashScreenModule.class})
@SplashScreenScope
public interface SplashScreenComponent {
    void inject(SplashScreenActivity activity);
    SplashScreenPresenter provideSplashScreenPresenter();
}
