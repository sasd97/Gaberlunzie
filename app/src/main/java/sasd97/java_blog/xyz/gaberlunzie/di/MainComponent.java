package sasd97.java_blog.xyz.gaberlunzie.di;

import dagger.Subcomponent;
import sasd97.java_blog.xyz.gaberlunzie.di.modules.MainModule;
import sasd97.java_blog.xyz.gaberlunzie.di.scopes.MainScope;
import sasd97.java_blog.xyz.gaberlunzie.presentation.converter.ConverterFragment;
import sasd97.java_blog.xyz.gaberlunzie.presentation.main.MainActivity;
import sasd97.java_blog.xyz.gaberlunzie.presentation.setup.SetupFragment;
import sasd97.java_blog.xyz.gaberlunzie.presentation.setup.SetupPresenter;

/**
 * Created by alexander on 11/07/2017.
 */

@Subcomponent(modules = {MainModule.class})
@MainScope
public interface MainComponent {
    void inject(MainActivity activity);
    void inject(SetupFragment fragment);
    void inject(ConverterFragment fragment);

    SetupPresenter provideSetupPresenter();
}
