package com.selessia.nomp.web;

import android.webkit.JavascriptInterface;

public class NompJavascriptInterface {

    private NompWebViewWrapper nompWebViewWrapper;

    public NompJavascriptInterface(NompWebViewWrapper nompWebViewWrapper) {
        this.nompWebViewWrapper = nompWebViewWrapper;
    }

    @JavascriptInterface
    public void closeWebView() {
        nompWebViewWrapper.close();
    }

}
