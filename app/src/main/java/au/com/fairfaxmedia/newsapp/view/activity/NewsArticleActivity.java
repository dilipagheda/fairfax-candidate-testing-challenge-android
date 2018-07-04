package au.com.fairfaxmedia.newsapp.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import au.com.fairfaxmedia.newsapp.R;
import au.com.fairfaxmedia.newsapp.view.fragment.WebViewFragment;

public class NewsArticleActivity extends BaseActivity {

    public static final String EXTRA_URL_KEY = "url_key";

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_webview;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                String url = bundle.getString(EXTRA_URL_KEY);
                replaceFragment(R.id.fragment_container, WebViewFragment.newInstance(url));
            }
        }

        getSupportActionBar().setTitle(getString(R.string.home));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (((WebViewFragment) fragment).canPopFragment()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public static void launchActivity(Activity activity, String url) {
        Intent intent = new Intent(activity, NewsArticleActivity.class);
        intent.putExtra(EXTRA_URL_KEY, url);
        activity.startActivity(intent);
    }
}