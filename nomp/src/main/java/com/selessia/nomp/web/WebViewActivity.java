package com.selessia.nomp.web;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class WebViewActivity extends AppCompatActivity {

    private NompWebViewWrapper nompWebViewWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            nompWebViewWrapper = new NompWebViewWrapper(this, "https://app.nomp.se/nomp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        hideActionBar();
    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        nompWebViewWrapper.getWebView().destroy();
    }
}
