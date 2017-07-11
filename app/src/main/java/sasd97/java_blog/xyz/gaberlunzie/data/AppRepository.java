package sasd97.java_blog.xyz.gaberlunzie.data;

import io.reactivex.Observable;
import sasd97.java_blog.xyz.gaberlunzie.data.net.RateModel;

/**
 * Created by alexander on 06/07/2017.
 */

public interface AppRepository {

    Observable<RateModel> getRate(String base, String... currencies);
}
