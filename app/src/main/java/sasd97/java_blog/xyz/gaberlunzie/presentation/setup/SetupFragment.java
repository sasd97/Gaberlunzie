package sasd97.java_blog.xyz.gaberlunzie.presentation.setup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sasd97.java_blog.xyz.gaberlunzie.GaberlunzieApp;
import sasd97.java_blog.xyz.gaberlunzie.R;
import sasd97.java_blog.xyz.gaberlunzie.data.models.CurrencyModel;
import sasd97.java_blog.xyz.gaberlunzie.presentation.CurrenciesRecyclerAdapter;

/**
 * Created by alexander on 11/07/2017.
 */

public class SetupFragment extends MvpAppCompatFragment implements SetupView {

    private Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    private CurrenciesRecyclerAdapter currenciesRecyclerAdapter = new CurrenciesRecyclerAdapter();

    @BindView(R.id.setup_fragment_currencies_list) public RecyclerView currenciesRecyclerView;

    @InjectPresenter SetupPresenter presenter;

    @ProvidePresenter
    public SetupPresenter providePresenter() {
        return GaberlunzieApp
                .get(getContext())
                .getAppComponent()
                .plusMainComponent()
                .provideSetupPresenter();
    }

    public static SetupFragment getInstance() {
        return new SetupFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setup, container, false);
        unbinder = ButterKnife.bind(this, v);

        currenciesRecyclerView.setHasFixedSize(true);
        currenciesRecyclerView.setLayoutManager(linearLayoutManager);
        currenciesRecyclerView.setAdapter(currenciesRecyclerAdapter);

        return v;
    }

    @Override
    public void addCurrency(CurrencyModel currency) {
        currenciesRecyclerAdapter.add(currency);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
