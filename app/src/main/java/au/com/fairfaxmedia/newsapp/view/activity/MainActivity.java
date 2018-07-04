package au.com.fairfaxmedia.newsapp.view.activity;

import android.os.Bundle;

import au.com.fairfaxmedia.newsapp.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}