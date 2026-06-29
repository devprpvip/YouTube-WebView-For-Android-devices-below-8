// YouTube AdBlock Script - Inject vào WebView
// Based on AdBlock for YouTube + uBlock Origin filters

(function() {
    'use strict';
    
    // Hide ads bằng CSS
    const style = document.createElement('style');
    style.innerHTML = `
        /* YouTube Ads */
        .ytp-ad-module,
        .ytp-ad-player-overlay,
        .ytp-ad-image-overlay-container,
        .ytp-ad-text-overlay,
        ytd-ad-slot-renderer,
        [data-ad-slot],
        [class*="ad-"],
        [id*="ad-"],
        .ad-showing .ytp-ad-player-overlay,
        .html5-video-container .ytp-ad-module {
            display: none !important;
            visibility: hidden !important;
            height: 0 !important;
            width: 0 !important;
        }
        
        /* Sponsored content */
        [class*="promoted"],
        [class*="sponsorship"] {
            display: none !important;
        }
        
        /* Ad containers */
        #masthead-ad,
        #header-ads,
        .yt-simple-endpoint[href*="googleadservices"] {
            display: none !important;
        }
    `;
    document.head.appendChild(style);
    
    // Remove ad elements từ DOM
    function removeAds() {
        const selectors = [
            '.ytp-ad-module',
            '.ytp-ad-player-overlay',
            'ytd-ad-slot-renderer',
            '[data-ad-slot]',
            '[class*="ad-showing"]',
            '#masthead-ad'
        ];
        
        selectors.forEach(selector => {
            document.querySelectorAll(selector).forEach(el => {
                el.style.display = 'none';
                el.remove();
            });
        });
    }
    
    // Run immediately
    removeAds();
    
    // Run on every page update
    setInterval(removeAds, 1000);
    
    // Observe DOM changes
    const observer = new MutationObserver(removeAds);
    observer.observe(document.body, {
        childList: true,
        subtree: true,
        attributes: false
    });
    
    console.log('YouTube AdBlock activated!');
})();
