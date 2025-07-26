# Android Toast Library 📚

[![](https://jitpack.io/v/qdeskdev/Android-Library.svg)](https://jitpack.io/#qdeskdev/Android-Library)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A lightweight Android toast library to simplify your toast in development process.

## Installation 💻

Add this to your project in 2 simple steps:

### 1. Add JitPack Repository

**For traditional projects** (root `build.gradle`):
```gradle
allprojects {
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

```
**For modern projects** (settings.gradle):
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

```
### 2. Add Dependency
```gradle
dependencies {
    implementation 'com.github.qdeskdev:Android-Library:1.0.2'
}

```
Notes
Ensure your Gradle version supports JitPack (Gradle 7+ recommended).

Replace 1.0 with the latest version if a newer one is available.
You can find the latest version on the JitPack release page.

> Let me know if you'd like to include usage examples, proguard rules, or Groovy DSL as well.
