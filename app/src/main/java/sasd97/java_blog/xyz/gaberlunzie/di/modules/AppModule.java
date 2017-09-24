package sasd97.java_blog.xyz.gaberlunzie.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sasd97.java_blog.xyz.gaberlunzie.data.AppRepository;
import sasd97.java_blog.xyz.gaberlunzie.data.AppRepositoryImpl;
import sasd97.java_blog.xyz.gaberlunzie.data.net.CurrencyApi;
import sasd97.java_blog.xyz.gaberlunzie.data.resources.ResourceManager;
import sasd97.java_blog.xyz.gaberlunzie.utils.RxSchedulers;
import sasd97.java_blog.xyz.gaberlunzie.utils.RxSchedulersImpl;

/**
 * Created by alexander on 11/07/2017.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.fixer.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public CurrencyApi provideApi(Retrofit retrofit) {
        return retrofit.create(CurrencyApi.class);
    }

    @Provides
    @Singleton
    public ResourceManager provideResourceManager(Context context) {
        return new ResourceManager(context);
    }

    @Provides
    @Singleton
    public AppRepository provideRepository(CurrencyApi api, ResourceManager resourceManager) {
        return new AppRepositoryImpl(api, resourceManager);
    }

    @Provides
    @Singleton
    public RxSchedulers provideRxSchedulers() {
        return new RxSchedulersImpl();
    }
}
