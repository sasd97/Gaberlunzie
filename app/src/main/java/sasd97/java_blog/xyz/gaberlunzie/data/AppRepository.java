package sasd97.java_blog.xyz.gaberlunzie.data;

import io.reactivex.Observable;
import sasd97.java_blog.xyz.gaberlunzie.data.models.CurrencyModel;
import sasd97.java_blog.xyz.gaberlunzie.data.models.RateModel;

/**
 * Created by alexander on 06/07/2017.
 */

public interface AppRepository {

    Observable<CurrencyModel> obtainCurrenciesList();
    Observable<RateModel> getRate(String base, String... currencies);
}
