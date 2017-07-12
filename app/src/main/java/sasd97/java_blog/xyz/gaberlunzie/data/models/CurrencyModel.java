package sasd97.java_blog.xyz.gaberlunzie.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alexander on 12/07/2017.
 */

public class CurrencyModel {

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CurrencyModel{");
        sb.append("title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
