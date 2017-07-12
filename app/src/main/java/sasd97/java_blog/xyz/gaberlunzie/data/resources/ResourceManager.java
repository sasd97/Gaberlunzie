package sasd97.java_blog.xyz.gaberlunzie.data.resources;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import io.reactivex.Observable;
import sasd97.java_blog.xyz.gaberlunzie.R;
import sasd97.java_blog.xyz.gaberlunzie.data.models.CurrencyModel;

/**
 * Created by alexander on 12/07/2017.
 */

public class ResourceManager {

    private Context context;

    public ResourceManager(@NonNull Context context) {
        this.context = context;
    }

    public Observable<CurrencyModel> obtainCurrenciesList() {
        InputStream stream = context.getResources().openRawResource(R.raw.currencies);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        List<CurrencyModel> list = new Gson().fromJson(reader, new TypeToken<List<CurrencyModel>>(){}.getType());
        return Observable.fromIterable(list);
    }
}
