package com.selessia.nomp.web;

import android.app.Activity;
import android.app.ProgressDialog;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.selessia.nomp.R;

public class NompWebViewWrapper {

    private final WebView webview;
    private final Activity context;
    private final ProgressDialog progressDialog;

    public NompWebViewWrapper(Activity context, String url) {
        this.context = context;
        this.progressDialog = ProgressDialog.show(context, getContext().getString(R.string.loading_header), getContext().getString(R.string.loading_message));
        webview = new WebView(context);
        webview.setWebViewClient(new NompWebViewClient(this));
        webview.setWebChromeClient(new NompWebChromeClient());
        webview.addJavascriptInterface(new NompJavascriptInterface(this), "android");
        webview.loadUrl(url);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        context.setContentView(webview);

    }

    public void onPageLoaded() {
        progressDialog.dismiss();
    }

    public WebView getWebView() {
        return webview;
    }

    public Activity getContext() {
        return context;
    }

    public void close() {
        context.finish();
    }

    public void onFailedLogin() {
        Toast.makeText(getContext(), getContext().getString(R.string.error_login_failed), Toast.LENGTH_SHORT).show();
        context.finish();
    }
}
