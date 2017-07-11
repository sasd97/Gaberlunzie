package sasd97.java_blog.xyz.gaberlunzie.presentation.converter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import sasd97.java_blog.xyz.gaberlunzie.R;

/**
 * Created by alexander on 11/07/2017.
 */

public class ConverterFragment extends MvpAppCompatFragment implements ConverterView {

    @InjectPresenter ConverterPresenter presenter;

    public static ConverterFragment getInstance() {
        return new ConverterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_converter, container, false);
        ButterKnife.bind(this, v);
        return v;
    }
}
