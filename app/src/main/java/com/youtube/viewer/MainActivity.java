package com.youtube.viewer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.KeyEvent;
import android.graphics.Color;
import android.view.WindowManager;

public class MainActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fullscreen - xóa status bar
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        webView = findViewById(R.id.webview);
        
        // Config WebView để tối ưu hiệu năng
        setupWebView();
        
        // Load YouTube
        webView.loadUrl("https://www.youtube.com");
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView() {
        WebSettings settings = webView.getSettings();
        
        // Enable JavaScript (cần cho YouTube)
        settings.setJavaScriptEnabled(true);
        
        // Tối ưu cho máy yếu (Snap 425)
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        
        // Cache để giảm tải
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setAppCacheEnabled(true);
        
        // Disable plugins/features không cần
        settings.setPluginState(WebSettings.PluginState.OFF);
        
        // User Agent bình thường
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 7.1.1; SM-J200G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Mobile Safari/537.36");
        
        // Media playback
        settings.setMediaPlaybackRequiresUserGesture(false);
        
        // Zoom controls
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        
        // Text zoom
        settings.setTextZoom(100);
        
        // Layout algorithm tối ưu
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        
        // Cho phép fullscreen video
        settings.setAllowFileAccess(true);
        
        // WebViewClient để kiểm soát navigation
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Chỉ load YouTube links
                if (url.contains("youtube.com") || url.contains("youtu.be") || 
                    url.contains("google.com") || url.contains("accounts.google.com")) {
                    view.loadUrl(url);
                    return true;
                }
                // Ignore other links
                return false;
            }
        });

        // Background color
        webView.setBackgroundColor(Color.BLACK);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Back button - quay lại video trước
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
