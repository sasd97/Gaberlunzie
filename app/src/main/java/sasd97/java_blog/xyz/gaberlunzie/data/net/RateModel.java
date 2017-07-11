package sasd97.java_blog.xyz.gaberlunzie.data.net;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by alexander on 06/07/2017.
 */

public class RateModel {

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("rates")
    @Expose
    private Map<String, String> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String>  rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RateModel{");
        sb.append("base='").append(base).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", rates=").append(rates);
        sb.append('}');
        return sb.toString();
    }
}
