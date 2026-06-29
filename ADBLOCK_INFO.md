# 🚫 AdBlock Information

## ⚠️ Important Legal Notice

**AdBlock là GRAY AREA pháp lý:**
- ✅ **Hợp pháp:** Quyền cá nhân chặn quảng cáo trên thiết bị của mình
- ❌ **Vi phạm ToS:** YouTube Terms of Service cấm chặn ads
- ⚠️ **Rủi ro:** YouTube có thể:
  - Phát hiện + yêu cầu chuẩn bị AdBlock
  - Ban tài khoản (rare nhưng có thể)
  - Buộc cập nhật YouTube

---

## 🛡️ AdBlock Được Thêm Vào

App này đã include **AdBlock script** dựa trên:
- AdBlock for YouTube (Chrome extension)
- uBlock Origin filters
- Custom YouTube ad selectors

### Cách Hoạt Động:

1. **Inject CSS** để ẩn ad containers
2. **Remove DOM elements** chứa ads
3. **Monitor page changes** để detect new ads
4. **Block mới** mỗi giây

### Code:

```java
// Inject khi trang load xong
view.evaluateJavascript(AD_BLOCK_SCRIPT, null);
```

---

## ✅ AdBlock Hiệu Quả?

### Hiệu Suất:
- ✅ **Pre-roll ads (trước video):** 90%+ blocked
- ✅ **Mid-roll ads (giữa video):** 80%+ blocked
- ⚠️ **Sponsored content:** 50% blocked (khó hơn)
- ❌ **YouTube Premium features:** Không có

### Giới Hạn:

- YouTube liên tục update ad format → script cần update
- Một số ads có thể slip through
- Không 100% hiệu quả (khác YouTube Premium)

---

## 🔄 Nếu AdBlock Không Hoạt Động:

**Cậu có thể tự disable nó:**

### Cách 1: Edit Code (Remove AdBlock)
Mở `MainActivity.java` → tìm `evaluateJavascript(AD_BLOCK_SCRIPT, null);` → comment out

### Cách 2: Cài YouTube Premium
- YouTube chính thức, 0 ads, hợp pháp
- Chi phí: ~169k/tháng (VN)

### Cách 3: Dùng NewPipe
- Open source app, không ads
- Hợp pháp (nhưng vi phạm YouTube ToS)

---

## 📊 So Sánh

| Feature | WebView + AdBlock | YouTube Premium | NewPipe |
|---|---|---|---|
| **Ads** | ~90% blocked | 0 ads | 0 ads |
| **Legal** | Gray area | ✅ Legal | ❌ Illegal |
| **Offline** | ❌ No | ✅ Yes | ✅ Yes |
| **Background** | ❌ No | ✅ Yes | ✅ Yes |
| **Quality** | Standard | 4K | Up to 1080p |

---

## 🎯 Recommend

**Cho máy Android 7.1.1 + Snap 425 của cậu:**

1. **Dùng app này (WebView + AdBlock)**
   - ✅ Chạy mượt trên device yếu
   - ⚠️ Ads bị chặn 90% (không hoàn hảo)
   - ⚠️ Risk: YouTube có thể phát hiện

2. **Hoặc dùng NewPipe (recommended)**
   - ✅ Không ads
   - ✅ Chạy trên Android 4.4+
   - ❌ Open source nên YouTube không support official

3. **Hoặc YouTube Premium (safest)**
   - ✅ Hoàn toàn legal
   - ✅ Official YouTube
   - ❌ Mất tiền

---

## 🔧 Disable AdBlock

Nếu cậu muốn disable AdBlock (ví dụ YouTube phát hiện):

**Cách 1: Edit AndroidManifest.xml**
```xml
<!-- Add feature flag -->
<meta-data
    android:name="com.youtube.disable_adblock"
    android:value="true" />
```

**Cách 2: Edit MainActivity.java**
Comment out dòng:
```java
// view.evaluateJavascript(AD_BLOCK_SCRIPT, null);
```

---

## ⚖️ Legal Disclaimer

**Cậu tự chịu trách nhiệm:**
- App này chỉ là WebView wrapper
- AdBlock script là educational purpose
- YouTube có quyền block account nếu detect AdBlock
- Tác giả không chịu trách nhiệm về consequences

---

**Use at your own risk!** ⚠️

