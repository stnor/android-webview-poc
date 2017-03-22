package com.selessia.nomp.web;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

public class NompWebChromeClient extends WebChromeClient {

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.d("Nomp", consoleMessage.message());
        return true;
    }

}
