package sasd97.java_blog.xyz.gaberlunzie.domain;

import io.reactivex.Observable;
import sasd97.java_blog.xyz.gaberlunzie.data.net.RateModel;

/**
 * Created by alexander on 11/07/2017.
 */

public interface SetupInteractor {
    Observable<RateModel> obtainRate(String... symbols);
}
