package sasd97.java_blog.xyz.gaberlunzie.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sasd97.java_blog.xyz.gaberlunzie.navigation.AppActivityRouter;
import sasd97.java_blog.xyz.gaberlunzie.navigation.Router;
import sasd97.java_blog.xyz.gaberlunzie.navigation.activities.ActivityCommand;

/**
 * Created by alexander on 11/07/2017.
 */

@Module
public class NavigationModule {

    @Provides
    @Singleton
    Router<ActivityCommand> provideActivityRouter() {
        return new AppActivityRouter();
    }
}
