package sasd97.java_blog.xyz.gaberlunzie.presentation.setup;

import com.arellomobile.mvp.MvpView;

import java.util.List;

/**
 * Created by alexander on 11/07/2017.
 */

public interface SetupView extends MvpView {
    void showTargetCurrencies(List<String> currencies);
}
