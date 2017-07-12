package sasd97.java_blog.xyz.gaberlunzie.data;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import sasd97.java_blog.xyz.gaberlunzie.data.models.CurrencyModel;
import sasd97.java_blog.xyz.gaberlunzie.data.net.CurrencyApi;
import sasd97.java_blog.xyz.gaberlunzie.data.models.RateModel;
import sasd97.java_blog.xyz.gaberlunzie.data.resources.ResourceManager;

/**
 * Created by alexander on 06/07/2017.
 */

public class AppRepositoryImpl implements AppRepository {

    private CurrencyApi api;
    private ResourceManager resourceManager;

    public AppRepositoryImpl(@NonNull CurrencyApi api,
                             @NonNull ResourceManager resourceManager) {
        this.api = api;
        this.resourceManager = resourceManager;
    }

    @Override
    public Observable<CurrencyModel> obtainCurrenciesList() {
        return resourceManager.obtainCurrenciesList();
    }

    @Override
    public Observable<RateModel> getRate(String base, String... currencies) {
        return api.getRates(base, currencies);
    }
}
