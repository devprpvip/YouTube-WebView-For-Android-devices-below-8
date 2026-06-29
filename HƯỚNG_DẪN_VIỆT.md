# 📱 YouTube App - Hướng Dẫn Chi Tiết

## 🎯 Tính Năng
- ✅ WebView full-screen (không thanh URL)
- ✅ Xem YouTube trực tiếp
- ✅ Tối ưu cho Snapdragon 425
- ✅ Chạy mượt trên Android 7.1.1+
- ✅ Không lag, không crash

---

## 🚀 Bước 1: Chuẩn Bị GitHub

### 1.1 Tạo GitHub Account (nếu chưa có)
- Vào https://github.com
- Bấm "Sign up"
- Điền email, tạo tài khoản

### 1.2 Fork Repo Này
- Vào GitHub repo (link sẽ được cấp)
- Bấm nút "Fork" góc phải
- Chọn tài khoản của cậu
- Xong!

---

## ⚙️ Bước 2: Enable GitHub Actions

### 2.1 Vào Settings
- Vào repo của cậu (sau khi fork)
- Bấm tab "Settings"

### 2.2 Bật Actions
- Kéo xuống menu bên trái
- Tìm "Actions" → "General"
- Tìm section "Actions permissions"
- Chọn "Allow all actions and reusable workflows"
- Bấm "Save"

---

## 🏗️ Bước 3: Trigger Compile

### Cách A: Tự Động (Khuyến Khích)
1. Vào repo của cậu
2. Bấm "Add file" → "Create new file"
3. Đặt tên file: `COMPILE_DATE.txt`
4. Viết nội dung: `Build triggered on $(date)`
5. Bấm "Commit changes"
6. GitHub Actions sẽ tự động chạy!

### Cách B: Manual
1. Vào tab "Actions"
2. Chọn workflow "Build APK"
3. Bấm "Run workflow"
4. Chọn branch (main)
5. Bấm "Run workflow"

---

## 📥 Bước 4: Download APK

### 4.1 Chờ Build Xong
- Vào tab "Actions"
- Xem workflow "Build APK" đang chạy
- Đợi tới khi xanh tích ✅ (thường 5-10 phút)

### 4.2 Download
1. Bấm vào workflow đó
2. Kéo xuống "Artifacts"
3. Tìm "YouTube-App"
4. Bấm download
5. Giải nén file zip
6. Lấy file `app-release.apk` ra

---

## 📲 Bước 5: Cài APK Lên Điện Thoại

### Cách A: Copy File Trực Tiếp
1. Copy file `app-release.apk` vào điện thoại
2. Tìm file trong "File Manager"
3. Bấm vào file APK
4. Bấm "Install"
5. Xong!

### Cách B: Dùng ADB (nếu có máy tính)
```bash
adb install -r app-release.apk
```

### Lưu Ý ⚠️
- Nếu lỗi "Unknown application", vào:
  - Settings → Security
  - Bật "Unknown sources"
  - Thử cài lại

---

## 🎮 Sử Dụng App

### Khi Mở App
- Tự động vào YouTube.com
- Xem video bình thường
- Không có thanh URL
- Nút back quay lại video trước

### Tùy Chỉnh
- Quay video: xoay điện thoại ngang
- Phóng to/thu nhỏ: pinch zoom
- Fullscreen: bấy nút fullscreen trên video

---

## 🔧 Troubleshoot

### ❌ Build Fail
**Vấn đề:** Workflow báo lỗi
**Cách Fix:**
1. Vào tab "Actions"
2. Bấy vào workflow fail
3. Xem log lỗi
4. Thường là lỗi code syntax
5. Sửa code, commit lại, trigger build mới

### ❌ APK Không Cài Được
**Vấn đề:** Lỗi khi cài APK
**Cách Fix:**
1. Vào Settings → Apps → Special access → Install unknown apps
2. Cho phép "File Manager" cài app
3. Thử cài lại

### ❌ YouTube Không Load
**Vấn đề:** App mở nhưng không có gì
**Cách Fix:**
1. Kiểm tra Internet connection
2. Đợi vài giây cho trang load
3. Tắt app, mở lại
4. Nếu vẫn không được, clear cache:
   - Settings → Apps → YouTube App → Storage → Clear Cache

### ❌ Lag/Chậm
**Vấn đề:** App chạy chậm
**Cách Fix:**
1. Tắt app khác đang chạy
2. Khởi động lại điện thoại
3. Clear cache app

---

## 📝 Sửa Đổi App

### Đổi Tên App
1. Vào repo
2. Mở file: `app/src/main/res/values/strings.xml`
3. Đổi dòng: `<string name="app_name">YouTube</string>`
4. Commit
5. Build lại

### Đổi URL (để vào trang khác)
1. Vào file: `app/src/main/java/com/youtube/viewer/MainActivity.java`
2. Tìm dòng: `webView.loadUrl("https://www.youtube.com");`
3. Đổi URL nếu cần
4. Commit
5. Build lại

### Ẩn Nút Back
1. Mở `MainActivity.java`
2. Tìm method `onKeyDown`
3. Xóa hoặc chỉnh sửa
4. Build lại

---

## 💡 Tips & Tricks

### Tăng Tốc Độ
- JavaScript đã ON (cần cho YouTube)
- Cache tự động bật
- App đã tối ưu rồi

### Tiết Kiệm Pin
- App chỉ load WebView
- Không background service
- Tắt app khi không dùng

### Tiết Kiệm Data
- Xem video HD → ít data hơn (YouTube tự optimize)
- Clear cache định kỳ

---

## ❓ FAQ

**Q: Tôi cần máy tính không?**
A: Không! GitHub Actions tự compile. Chỉ cần điện thoại để download APK.

**Q: Build mất bao lâu?**
A: Thường 5-10 phút. Thỉnh thoảng 15 phút.

**Q: Có thể update app không?**
A: Có! Edit code → commit → build lại → cài đè APK cũ.

**Q: App có an toàn không?**
A: Hoàn toàn! Open source, không có ads, không track dữ liệu.

**Q: Có thể dùng cho app khác không?**
A: Có! Đổi URL trong MainActivity.java là được.

---

## 📞 Hỗ Trợ

Nếu gặp vấn đề:
1. Kiểm tra lại các bước
2. Xem log lỗi trong Actions
3. Try troubleshoot section trên

---

**Made with ❤️ cho các bạn yêu YouTube** 🎬
