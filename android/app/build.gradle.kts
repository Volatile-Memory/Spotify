import Dependencies.common

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
}

android {
    compileSdk = Versions.App.COMPILE_SDK

    defaultConfig {
        applicationId = "foundation.program.spotify.android.app"

        minSdk = Versions.App.MIN_SDK
        targetSdk = Versions.App.TARGET_SDK

        versionCode = Versions.App.VERSION_CODE
        versionName = Versions.App.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            keyAlias = "MyKeyAlias"
            keyPassword = "MyKeyPassword"
            storeFile = file("Path/To/Key")
            storePassword = "KeyStorePassword"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField("String", "EXAMPLE", "\"release\"")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            buildConfigField("String", "EXAMPLE", "\"debug\"")
        }
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA.toString()
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.CORE
    }
}

dependencies {
    common()
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(project(":android"))
    testImplementation(Dependencies.Test.Unit.JUNIT)
}