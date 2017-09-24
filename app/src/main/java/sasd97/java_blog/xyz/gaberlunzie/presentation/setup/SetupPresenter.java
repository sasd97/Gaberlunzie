package sasd97.java_blog.xyz.gaberlunzie.presentation.setup;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import sasd97.java_blog.xyz.gaberlunzie.domain.SetupInteractor;
import sasd97.java_blog.xyz.gaberlunzie.utils.RxSchedulers;

/**
 * Created by alexander on 11/07/2017.
 */

@InjectViewState
public class SetupPresenter extends MvpPresenter<SetupView> {

    private SetupInteractor interactor;
    private RxSchedulers rxSchedulers;

    public SetupPresenter(@NonNull SetupInteractor interactor,
                          @NonNull RxSchedulers rxSchedulers) {
        this.interactor = interactor;
        this.rxSchedulers = rxSchedulers;
    }

    @Override
    public void attachView(SetupView view) {
        super.attachView(view);

        interactor.obtainCurrenciesList()
                .compose(rxSchedulers.getIoToMainTransformer())
                .subscribe(c -> {
                    getViewState().addCurrency(c);
                });
    }
}
