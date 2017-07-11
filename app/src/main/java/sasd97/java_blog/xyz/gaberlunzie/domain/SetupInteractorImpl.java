package sasd97.java_blog.xyz.gaberlunzie.domain;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import sasd97.java_blog.xyz.gaberlunzie.data.AppRepository;
import sasd97.java_blog.xyz.gaberlunzie.data.net.RateModel;

/**
 * Created by alexander on 11/07/2017.
 */

public class SetupInteractorImpl implements SetupInteractor {

    private AppRepository appRepository;

    public SetupInteractorImpl(@NonNull AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public Observable<RateModel> obtainRate(String... symbols) {
        return appRepository.getRate("EUR", symbols);
    }
}
