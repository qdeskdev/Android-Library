# 🍞 Android Toast Library
[![JitPack](https://jitpack.io/v/qdeskdev/Android-Library.svg)](https://jitpack.io/#qdeskdev/Android-Library)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![GitHub stars](https://img.shields.io/github/stars/qdeskdev/Android-Library.svg?style=social&label=Star)](https://github.com/qdeskdev/Android-Library)

A modern, lightweight Android toast library that brings beautiful, customizable toast notifications to your app with smooth animations and multiple built-in styles. Say goodbye to boring system toasts! 🎨

## ✨ Features

- 🎯 **5 Built-in Styles**: Success, Error, Warning, Info, and Default
- 🌈 **Beautiful Icons**: Each toast type comes with its own contextual icon
- 🎭 **Smooth Animations**: Elegant slide-in and fade-out animations
- 📱 **Modern Design**: Material Design inspired with rounded corners and shadows
- 🔧 **Easy Integration**: Just 2 lines to add to your project
- 🚀 **Lightweight**: Minimal impact on your app size (~15KB)
- 🛡️ **Fail-safe**: Automatically falls back to system toast if needed
- 📐 **Responsive**: Adapts to different screen sizes and orientations

## 📱 Preview

| Success | Error | Warning | Info | Default |
|---------|-------|---------|------|---------|
<p align="center">
  <img width="190" height="62" alt="image" src="https://github.com/user-attachments/assets/9b97cbfc-7cb5-42c1-b09b-ef446336bf87" />
  <img width="196" height="70" alt="image" src="https://github.com/user-attachments/assets/fed31728-5081-4d92-8a36-2cbc286d302d" />
  <img width="196" height="70" alt="image" src="https://github.com/user-attachments/assets/335750da-67a5-4b8a-9a7d-d063e935ba9c" />
  <img width="190" height="62" alt="image" src="https://github.com/user-attachments/assets/4e97ccef-0fad-4653-ac95-527fdd8510e3" />
  <img width="196" height="76" alt="image" src="https://github.com/user-attachments/assets/1b3b31e2-68f2-4739-9a7e-60a503fe53be" />

</p>


## 🚀 Installation

Add this powerful toast library to your project in just 2 simple steps:

### Step 1: Add JitPack Repository

**For Gradle 7.0+ (settings.gradle):**
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

**For older projects (root build.gradle):**
```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add Dependency

Add this to your app-level `build.gradle`:

```gradle
dependencies {
    implementation 'com.github.qdeskdev:Android-Library:1.0.2'
}
```

> 💡 **Pro Tip**: Always check the [releases page](https://github.com/qdeskdev/Android-Library/releases) for the latest version!

## 📖 Usage Guide

### Basic Implementation

#### 🍞 Simple Toast
Perfect for general messages and notifications:
```java
// Simple, clean toast
Toaster.show(this, "Hello from Toaster library!");

// For longer messages
Toaster.showLong(this, "This is a longer message that needs more time to read");
```

#### ✅ Success Toast
Celebrate successful operations with style:
```java
// Perfect for completed actions
Toaster.success(this, "Profile updated successfully!");
Toaster.success(this, "File uploaded!");
Toaster.success(this, "Payment completed ✨");
```

#### ❌ Error Toast  
Handle errors gracefully with clear visual feedback:
```java
// Network errors
Toaster.error(this, "No internet connection");

// Validation errors  
Toaster.error(this, "Please enter a valid email address");

// Server errors
Toaster.error(this, "Server error. Please try again later");
```

#### ⚠️ Warning Toast
Alert users about important information:
```java
// Form validation
Toaster.warning(this, "Please fill all required fields");

// Storage warnings
Toaster.warning(this, "Storage space running low");

// Security alerts
Toaster.warning(this, "Unsecured network detected");
```

#### ℹ️ Info Toast
Share helpful information and updates:
```java
// App updates
Toaster.info(this, "New version available in Play Store");

// Feature tips
Toaster.info(this, "Swipe left to access quick actions");

// Status updates
Toaster.info(this, "Sync completed. All data is up to date");
```


#### ℹ️ Default Toast
Show default information and confirmation:
```java
// Basic informational message
Toaster.default(this, "Just a quick note for you");

// Feature tip
Toaster.default(this, "Tip: Swipe left to reveal quick actions");

// Status update
Toaster.default(this, "You're all synced! Everything is up to date");

```


## 🔧 Advanced Usage

### Chaining Toasts with Delays
```java
// Show multiple toasts in sequence
Toaster.success(this, "Step 1 completed");

Handler handler = new Handler(Looper.getMainLooper());
handler.postDelayed(() -> {
    Toaster.info(this, "Processing step 2...");
}, 2000);

handler.postDelayed(() -> {
    Toaster.success(this, "All steps completed!");
}, 4000);
```

### Usage in Different Contexts
```java
// In Activities
Toaster.success(MainActivity.this, "Welcome back!");

// In Fragments  
Toaster.error(getActivity(), "Failed to load data");
Toaster.error(requireActivity(), "Failed to load data"); // For newer fragments

// In Adapters
Toaster.warning((Activity) context, "Item removed from cart");
```

## 💡 Best Practices & Tips

### ✅ Do's
- **Use appropriate toast types** for better UX (success for completed actions, error for failures)
- **Keep messages concise** and meaningful (under 50 characters when possible)
- **Use activity context** for optimal display and lifecycle management
- **Test on different screen sizes** to ensure proper display
- **Combine with haptic feedback** for enhanced user experience

### ❌ Don'ts  
- **Don't spam toasts** - give users time to read each message
- **Avoid technical jargon** - use user-friendly language
- **Don't rely solely on toasts** for critical information
- **Avoid using application context** when activity context is available

## 🎨 Customization Examples

### Real-world Usage Scenarios
```java
// E-commerce app
Toaster.success(this, "Added to cart successfully!");
Toaster.warning(this, "Only 2 items left in stock");
Toaster.error(this, "Payment failed. Please try again");

// Social media app  
Toaster.info(this, "New message received");
Toaster.success(this, "Post shared successfully!");
Toaster.warning(this, "Slow internet connection detected");

// Productivity app
Toaster.success(this, "Task completed ✓");
Toaster.info(this, "Reminder: Meeting in 10 minutes");
Toaster.error(this, "Failed to sync. Check connection");
```

## 🔧 Requirements

- **Minimum SDK**: Android API 21 (Android 5.0 Lollipop)
- **Target SDK**: Android API 34+
- **Java**: Java 8+ or Kotlin
- **Gradle**: 7.0+

## 🤝 Contributing

We welcome contributions! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

## 📋 Changelog

### Version 1.0.2
- 🐛 Fixed animation glitches on older devices
- 🎨 Improved icon rendering quality
- 📱 Better support for tablets and foldable devices

### Version 1.0.1
- ✨ Added support for RTL languages
- 🔧 Performance optimizations
- 📚 Updated documentation

### Version 1.0
- 🎉 Initial release
- ✅ 5 toast types with animations
- 🎨 Material Design styling

## 📄 License

```
Copyright 2025 QDesk

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## 🙏 Acknowledgments

- Thanks to all contributors who helped make this library better
- Inspired by modern Material Design principles
- Built with ❤️ for the Android community

---

### 🌟 Show Your Support

If this library helped you build better Android apps, please consider giving it a ⭐ on GitHub! Your support motivates us to keep improving and adding new features.

**Found a bug or have a feature request?** [Open an issue](https://github.com/qdeskdev/Android-Library/issues) and we'll get right on it!

**Want to stay updated?** [Watch this repository](https://github.com/qdeskdev/Android-Library) to get notified about new releases and updates.

---

<div align="center">

**Made with ❤️ by [QDesk](https://github.com/qdeskdev)**

*Happy coding! 🚀*

</div>
