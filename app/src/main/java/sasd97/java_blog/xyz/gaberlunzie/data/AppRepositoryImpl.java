package sasd97.java_blog.xyz.gaberlunzie.data;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import sasd97.java_blog.xyz.gaberlunzie.data.net.CurrencyApi;
import sasd97.java_blog.xyz.gaberlunzie.data.net.RateModel;

/**
 * Created by alexander on 06/07/2017.
 */

public class AppRepositoryImpl implements AppRepository {

    private CurrencyApi api;

    public AppRepositoryImpl(@NonNull CurrencyApi api) {
        this.api = api;
    }

    @Override
    public Observable<RateModel> getRate(String base, String... currencies) {
        return api.getRates(base, currencies);
    }
}
