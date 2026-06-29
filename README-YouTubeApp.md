# YouTube WebView App

Ứng dụng WebView đơn giản để xem YouTube trên Android 7.1.1+

## Tính năng

✅ WebView full-screen (không thanh địa chỉ)
✅ Load YouTube trực tiếp
✅ Tối ưu cho Snapdragon 425
✅ Mượt, không lag
✅ Android 7.1.1+ compatible

## Hướng dẫn compile APK bằng GitHub Actions

### Bước 1: Fork repo này
- Vào https://github.com
- Fork repo này về tài khoản của cậu

### Bước 2: Enable GitHub Actions
- Vào Settings của repo
- Kéo xuống "Code and automation" → "Actions"
- Bấm "I understand my workflows, go ahead and enable them"

### Bước 3: Trigger build
**Cách 1: Tự động khi push code**
- Edit file bất kỳ (ví dụ: README.md)
- Commit + Push lên
- GitHub Actions sẽ tự động compile

**Cách 2: Manual build**
- Vào tab "Actions" của repo
- Chọn workflow "Build APK"
- Bấm "Run workflow"
- Chọn branch (main/master)
- Bấm "Run workflow"

### Bước 4: Download APK
- Đợi workflow chạy xong (thường 5-10 phút)
- Khi xong, vào tab "Summary"
- Kéo xuống "Artifacts"
- Download "YouTube-App"
- Bên trong là file `.apk` của cậu

### Bước 5: Cài APK lên điện thoại
```
adb install -r app-release.apk
```

Hoặc copy file APK vào điện thoại, bấm để cài đặt.

## Cấu trúc project

```
YouTubeApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/youtube/viewer/
│   │   │   └── MainActivity.java          (code chính)
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml      (layout)
│   │   │   └── values/
│   │   │       ├── strings.xml            (tên app)
│   │   │       └── styles.xml             (theme)
│   │   └── AndroidManifest.xml            (config app)
│   └── build.gradle                       (config build)
├── .github/workflows/
│   └── build.yml                          (GitHub Actions)
└── README.md
```

## Tùy chỉnh

### Đổi URL YouTube
Mở `MainActivity.java` → Tìm dòng `webView.loadUrl("https://www.youtube.com");`
→ Đổi URL nếu cần

### Đổi tên app
Mở `app/src/main/res/values/strings.xml` → Đổi `<string name="app_name">YouTube</string>`

### Thêm icon custom
Thay thế file icon ở `app/src/main/res/mipmap-*/ic_launcher.png`

## Troubleshoot

**Workflow fail?**
- Kiểm tra "Actions" tab → xem log lỗi
- Đảm bảo code không có lỗi syntax

**APK không cài được?**
- Bật "Unknown sources" trong Settings
- Dùng APK phiên bản release (không debug)

**WebView lag?**
- Tắt JavaScript nếu không cần
- Giảm cache size
- Edit `MainActivity.java` → tìm `setupWebView()`

## License

MIT

---

**Made with ❤️ for YouTube lovers**
