package sasd97.java_blog.xyz.gaberlunzie.di.modules;

import com.github.sasd97.lib_router.BaseRouter;
import com.github.sasd97.lib_router.Router;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexander on 11/07/2017.
 */

@Module
public class NavigationModule {

    public static final String ACTIVITY_ROUTER = "router.activity";
    public static final String FRAGMENT_ROUTER = "router.fragment";

    @Provides
    @Singleton
    @Named(ACTIVITY_ROUTER)
    Router provideActivityRouter() {
        return new BaseRouter();
    }

    @Provides
    @Singleton
    @Named(FRAGMENT_ROUTER)
    Router provideFragmentRouter() {
        return new BaseRouter();
    }
}
