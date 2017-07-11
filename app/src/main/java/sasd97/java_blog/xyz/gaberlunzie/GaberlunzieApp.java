package sasd97.java_blog.xyz.gaberlunzie;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import sasd97.java_blog.xyz.gaberlunzie.di.AppComponent;
import sasd97.java_blog.xyz.gaberlunzie.di.DaggerAppComponent;
import sasd97.java_blog.xyz.gaberlunzie.di.modules.AppModule;
import sasd97.java_blog.xyz.gaberlunzie.di.modules.NavigationModule;

/**
 * Created by alexander on 11/07/2017.
 */

public class GaberlunzieApp extends Application {

    private AppComponent appComponent;

    public static GaberlunzieApp get(@NonNull Context context) {
        return (GaberlunzieApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = buildDi();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent buildDi() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .navigationModule(new NavigationModule())
                .build();
    }
}
