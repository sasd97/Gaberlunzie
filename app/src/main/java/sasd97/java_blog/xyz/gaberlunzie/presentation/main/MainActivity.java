package sasd97.java_blog.xyz.gaberlunzie.presentation.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sasd97.java_blog.xyz.gaberlunzie.R;
import sasd97.java_blog.xyz.gaberlunzie.navigation.AppFragmentRouter;
import sasd97.java_blog.xyz.gaberlunzie.navigation.Router;
import sasd97.java_blog.xyz.gaberlunzie.navigation.fragments.FragmentCommand;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @BindView(R.id.toolbar) Toolbar toolbar;

    private Unbinder unbinder;
    private Router<FragmentCommand> fragmentRouter
            = new AppFragmentRouter(R.id.activity_converter_fragment_container, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        unbinder = ButterKnife.bind(this);

        presenter.setRouter(fragmentRouter);
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
