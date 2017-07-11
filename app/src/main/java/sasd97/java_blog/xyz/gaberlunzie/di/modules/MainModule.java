package sasd97.java_blog.xyz.gaberlunzie.di.modules;

import dagger.Module;
import dagger.Provides;
import sasd97.java_blog.xyz.gaberlunzie.data.AppRepository;
import sasd97.java_blog.xyz.gaberlunzie.di.scopes.MainScope;
import sasd97.java_blog.xyz.gaberlunzie.domain.SetupInteractor;
import sasd97.java_blog.xyz.gaberlunzie.domain.SetupInteractorImpl;
import sasd97.java_blog.xyz.gaberlunzie.presentation.setup.SetupPresenter;
import sasd97.java_blog.xyz.gaberlunzie.utils.RxSchedulers;
import sasd97.java_blog.xyz.gaberlunzie.utils.RxSchedulersAbs;

/**
 * Created by alexander on 11/07/2017.
 */

@Module
public class MainModule {

    @Provides
    @MainScope
    public SetupInteractor provideSetupInteractor(AppRepository repository) {
        return new SetupInteractorImpl(repository);
    }

    @Provides
    @MainScope
    public SetupPresenter provideSetupPresenter(SetupInteractor interactor, RxSchedulersAbs rxSchedulers) {
        return new SetupPresenter(interactor, rxSchedulers);
    }
}
