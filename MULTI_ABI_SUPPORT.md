# 🏗️ Multi-Architecture Support (32-bit + 64-bit)

## ✅ Supported Architectures

Ứng dụng này hỗ trợ **tất cả CPU architecture**:

| Architecture | Type | Android Device |
|---|---|---|
| **arm64-v8a** | 64-bit ARM | Mmost modern phones (2015+) |
| **armeabi-v7a** | 32-bit ARM | Older phones, Snapdragon 425, etc |
| **x86_64** | 64-bit Intel/AMD | Tablets, Emulators |
| **x86** | 32-bit Intel/AMD | Old tablets, Emulators |

---

## 📦 APK Files Available

Sau khi build xong, GitHub Actions sẽ tạo ra:

### 1. **Universal APK** (Khuyến khích) 🌟
- **Tên:** `app-release-universal.apk`
- **Dung lượng:** ~30-40 MB
- **Tương thích:** Chạy được trên **ALL devices** (32-bit + 64-bit)
- **Cách cài:** Download 1 file, cài vào bất kỳ điện thoại nào

### 2. **Architecture-Specific APKs** (Tiết kiệm dung lượng)
- `app-release-arm64-v8a.apk` (cho điện thoại 64-bit)
- `app-release-armeabi-v7a.apk` (cho điện thoại 32-bit)
- `app-release-x86.apk` (cho tablet Intel)
- `app-release-x86_64.apk` (cho tablet Intel 64-bit)

**Lợi ích:** Mỗi file chỉ ~15-20 MB (nhỏ hơn nửa universal APK)
**Nhược điểm:** Cần chọn file đúng cho device

### 3. **App Bundle** (Để publish lên Google Play)
- **Tên:** `app-release.aab`
- **Dung lượng:** ~25 MB
- **Mục đích:** Upload lên Google Play Store (không cần cho cài manual)

---

## 🎯 Cách Cài APK

### Cách 1: Universal APK (Dễ nhất) ✅
1. Download `app-release-universal.apk`
2. Copy vào điện thoại
3. Bấm cài đặt
4. **Xong!**

### Cách 2: Architecture-Specific APK (Tiết kiệm dung lượng)
1. Check architecture của điện thoại cậu:
   - **32-bit ARM:** Download `armeabi-v7a.apk`
   - **64-bit ARM:** Download `arm64-v8a.apk`
   - **Intel tablet:** Download `x86.apk` hoặc `x86_64.apk`

2. Download file đúng
3. Cài vào điện thoại

---

## 🔍 Kiểm Tra CPU Architecture Của Điện Thoại

### Cách 1: Setting → About
1. Vào **Settings**
2. Tìm **"About phone"**
3. Tìm **"Processor"** hoặc **"Chipset"**
4. Nếu là Snapdragon/MediaTek → thường là **32-bit ARM**

### Cách 2: Dùng App
- Download app **"CPU-Z"** từ Google Play
- Xem tab **"SOC"** → **"ISA"** (Instruction Set Architecture)
- Nếu viết **"ARMv8"** → 64-bit
- Nếu viết **"ARMv7"** → 32-bit

### Cách 3: Dùng ADB (trên máy tính)
```bash
adb shell getprop ro.product.cpu.abi
```

---

## 📊 File Size Comparison

| Type | Size | Tương thích |
|---|---|---|
| Universal APK | ~35-40 MB | **Tất cả device** |
| arm64-v8a | ~18 MB | Điện thoại 64-bit |
| armeabi-v7a | ~18 MB | Điện thoại 32-bit |
| x86 | ~18 MB | Tablet Intel |
| x86_64 | ~18 MB | Tablet Intel 64-bit |

---

## ⚡ Performance Trên Mỗi Architecture

| Architecture | Performance | Power |
|---|---|---|
| **arm64-v8a** | Tốt nhất | Tiết kiệm pin |
| **armeabi-v7a** | Tốt | Bình thường |
| **x86_64** | Tốt | Tiêu tốn hơn |
| **x86** | Bình thường | Tiêu tốn |

---

## 🛠️ Build Configuration

File `app/build.gradle` có cấu hình:

```gradle
splits {
    abi {
        enable true
        reset()
        include 'armeabi-v7a', 'arm64-v8a', 'x86', 'x86_64'
        universalApk true  // Tạo universal APK
    }
}
```

**Giải thích:**
- `enable true` → Bật split APK
- `include` → Các architecture cần support
- `universalApk true` → Tạo thêm universal APK (chạy được tất cả)

---

## 💡 Recommend

**Cho cậu:** Download **Universal APK** (`app-release-universal.apk`)
- ✅ Chạy được trên điện thoại Snapdragon 425 (32-bit ARM)
- ✅ Chạy được trên điện thoại mới 64-bit
- ✅ Không cần lo về architecture
- ✅ Size chỉ ~35-40 MB (acceptable)

---

**Vậy là hoàn toàn support 32-bit + 64-bit + x86 + x64!** 🎉
