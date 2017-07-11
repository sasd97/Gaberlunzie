package sasd97.java_blog.xyz.gaberlunzie.di.modules;

import dagger.Module;
import dagger.Provides;
import sasd97.java_blog.xyz.gaberlunzie.di.scopes.SplashScreenScope;
import sasd97.java_blog.xyz.gaberlunzie.navigation.Router;
import sasd97.java_blog.xyz.gaberlunzie.navigation.activities.ActivityCommand;
import sasd97.java_blog.xyz.gaberlunzie.presentation.splashscreen.SplashScreenPresenter;

/**
 * Created by alexander on 11/07/2017.
 */

@Module
public class SplashScreenModule {

    @Provides
    @SplashScreenScope
    public SplashScreenPresenter providePresenter(Router<ActivityCommand> router) {
        return new SplashScreenPresenter(router);
    }
}
