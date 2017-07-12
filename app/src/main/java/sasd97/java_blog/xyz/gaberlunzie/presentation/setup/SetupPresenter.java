package sasd97.java_blog.xyz.gaberlunzie.presentation.setup;

import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import sasd97.java_blog.xyz.gaberlunzie.domain.SetupInteractor;
import sasd97.java_blog.xyz.gaberlunzie.utils.RxSchedulers;
import sasd97.java_blog.xyz.gaberlunzie.utils.RxSchedulersAbs;
import sasd97.java_blog.xyz.gaberlunzie.utils.SwipeDetector;

/**
 * Created by alexander on 11/07/2017.
 */

@InjectViewState
public class SetupPresenter extends MvpPresenter<SetupView> {

    private static final String TAG = SetupPresenter.class.getCanonicalName();

    private SetupInteractor interactor;
    private RxSchedulersAbs rxSchedulers;

    public SetupPresenter(@NonNull SetupInteractor interactor,
                          @NonNull RxSchedulersAbs rxSchedulers) {
        this.interactor = interactor;
        this.rxSchedulers = rxSchedulers;
    }

    public void loadRate() {
        interactor.obtainCurrenciesList()
                .compose(rxSchedulers.getIOToMainTransformer())
                .subscribe(c -> {
                    getViewState().addTargetCurrency(c);
                    getViewState().addDestinationCurrency(c);
                });
    }
}
