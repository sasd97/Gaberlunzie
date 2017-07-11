package sasd97.java_blog.xyz.gaberlunzie.presentation.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

import sasd97.java_blog.xyz.gaberlunzie.R;

public class ConverterActivity extends MvpAppCompatActivity implements ConverterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
