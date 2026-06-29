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
    
    // AdBlock script - removes YouTube ads
    private static final String AD_BLOCK_SCRIPT = 
        "(function() {" +
        "  var style = document.createElement('style');" +
        "  style.innerHTML = '.ytp-ad-module{display:none!important}' +" +
        "    '.ytp-ad-player-overlay{display:none!important}' +" +
        "    '.ytp-ad-image-overlay-container{display:none!important}' +" +
        "    'ytd-ad-slot-renderer{display:none!important}' +" +
        "    '[data-ad-slot]{display:none!important}' +" +
        "    '[class*=\"ad-\"]{display:none!important}' +" +
        "    '[id*=\"ad-\"]{display:none!important}' +" +
        "    '#masthead-ad{display:none!important}' +" +
        "    '[class*=\"promoted\"]{display:none!important}';" +
        "  document.head.appendChild(style);" +
        "  function removeAds() {" +
        "    var ads = document.querySelectorAll('.ytp-ad-module, .ytp-ad-player-overlay, ytd-ad-slot-renderer, [data-ad-slot]');" +
        "    ads.forEach(function(ad) { ad.remove(); });" +
        "  }" +
        "  removeAds();" +
        "  setInterval(removeAds, 1000);" +
        "  console.log('YouTube AdBlock activated!');" +
        "})();";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fullscreen - xóa status bar
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        // Disable hardware acceleration cho device cũ
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFormat(android.graphics.PixelFormat.TRANSLUCENT);
        }

        webView = findViewById(R.id.webview);
        
        // Disable hardware acceleration - compatible với x86 + ARM 32/64 bit
        webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        
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
        
        // Mixed content - cho phép HTTP trên HTTPS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        
        // Cache để giảm tải
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // settings.setAppCacheEnabled(true); // removed for Android 34+ compatibility
        
        // Disable plugins/features không cần
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            settings.setPluginState(WebSettings.PluginState.OFF);
        }
        
        // User Agent - generic, hoạt động tốt trên x86 + ARM
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 7.1.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Mobile Safari/537.36");
        
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
        
        // Reduce memory footprint
        settings.setGeolocationEnabled(false);
        
        // WebViewClient để kiểm soát navigation + inject AdBlock
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                
                // Inject AdBlock script khi trang load xong
                if (url.contains("youtube.com") || url.contains("youtu.be")) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        view.evaluateJavascript(AD_BLOCK_SCRIPT, null);
                    }
                }
            }
            
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
