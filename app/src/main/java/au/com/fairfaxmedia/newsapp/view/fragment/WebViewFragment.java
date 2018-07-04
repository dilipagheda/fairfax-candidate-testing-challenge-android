package au.com.fairfaxmedia.newsapp.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import au.com.fairfaxmedia.newsapp.R;
import au.com.fairfaxmedia.newsapp.view.activity.NewsArticleActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewFragment extends BaseFragment {

    @BindView(R.id.webview)
    protected WebView mWebView;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    private String mUrl;

    public WebViewFragment() {
        // empty constructor
    }

    public static WebViewFragment newInstance(String url) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(NewsArticleActivity.EXTRA_URL_KEY, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mUrl = arguments.getString(NewsArticleActivity.EXTRA_URL_KEY);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_webview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                mProgressBar.setProgress(progress);
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(getWebViewClient());
        mWebView.loadUrl(mUrl);
    }

    protected WebViewClient getWebViewClient() {
        return new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        };
    }

    public boolean canPopFragment() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void showLoadingView() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        mProgressBar.setVisibility(View.GONE);
    }
}