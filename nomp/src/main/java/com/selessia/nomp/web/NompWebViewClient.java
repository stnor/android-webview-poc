package com.selessia.nomp.web;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NompWebViewClient extends WebViewClient {

    private final NompWebViewWrapper wrapper;

    public NompWebViewClient(NompWebViewWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    @TargetApi(Build.VERSION_CODES.N)
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        wrapper.onPageLoaded();
        super.onPageFinished(view, url);
    }
}
