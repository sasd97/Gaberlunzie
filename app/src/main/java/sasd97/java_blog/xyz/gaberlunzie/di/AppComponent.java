package sasd97.java_blog.xyz.gaberlunzie.di;

import javax.inject.Singleton;

import dagger.Component;
import sasd97.java_blog.xyz.gaberlunzie.di.modules.AppModule;
import sasd97.java_blog.xyz.gaberlunzie.di.modules.NavigationModule;
import sasd97.java_blog.xyz.gaberlunzie.presentation.splashscreen.SplashScreenActivity;

/**
 * Created by alexander on 11/07/2017.
 */

@Component(modules = {AppModule.class, NavigationModule.class})
@Singleton
public interface AppComponent {
    SplashScreenComponent plusSplashScreenComponent();
}
