package sasd97.java_blog.xyz.gaberlunzie.presentation.setup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
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
import sasd97.java_blog.xyz.gaberlunzie.utils.SwipeDetector;

/**
 * Created by alexander on 11/07/2017.
 */

public class SetupFragment extends MvpAppCompatFragment implements SetupView {

    @BindView(R.id.fragment_setup_gesture_detector) View gestureDetector;

    @InjectPresenter SetupPresenter presenter;

    @ProvidePresenter
    public SetupPresenter providePresenter() {
        return GaberlunzieApp
                .get(getContext())
                .getAppComponent()
                .plusMainComponent()
                .provideSetupPresenter();
    }

    private Unbinder unbinder;

    public static SetupFragment getInstance() {
        return new SetupFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setup, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadRate();

        gestureDetector.setOnTouchListener(new SwipeDetector(getContext(), presenter));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
