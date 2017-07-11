package sasd97.java_blog.xyz.gaberlunzie.data.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexander on 06/07/2017.
 */

public interface CurrencyApi {
    @GET("/latest")
    Observable<RateModel> getRates(@Query("base") String base, @Query("symbols[]") String... symbols);
}
