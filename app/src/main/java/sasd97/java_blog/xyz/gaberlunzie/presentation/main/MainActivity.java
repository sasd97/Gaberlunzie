package sasd97.java_blog.xyz.gaberlunzie.presentation.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.sasd97.lib_router.Router;
import com.github.sasd97.lib_router.satellites.FragmentSatellite;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sasd97.java_blog.xyz.gaberlunzie.GaberlunzieApp;
import sasd97.java_blog.xyz.gaberlunzie.R;

import static sasd97.java_blog.xyz.gaberlunzie.di.modules.NavigationModule.FRAGMENT_ROUTER;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @Inject
    @Named(FRAGMENT_ROUTER)
    Router fragmentRouter;

    @Inject
    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        return presenter;
    }

    @BindView(R.id.toolbar) Toolbar toolbar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        unbinder = ButterKnife.bind(this);

        GaberlunzieApp.get(this)
                .getAppComponent()
                .plusMainComponent()
                .inject(this);

        fragmentRouter.attachSatellite(new FragmentSatellite(R.id.activity_converter_fragment_container,
                getApplicationContext(),
                getSupportFragmentManager()));

        if (savedInstanceState == null) onInit();

        setSupportActionBar(toolbar);
    }

    private void onInit() {
        presenter.openSetup();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
