plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.namnpse.noteapp_kmp.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.namnpse.noteapp_kmp.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    val compose_version= "1.6.3"
    val hilt_android = "2.49"
    val hilt_compose = "1.2.0"
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.compose.foundation:foundation:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.activity:activity-compose:1.8.2")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    implementation("com.google.dagger:hilt-android:$hilt_android")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_android")
    kapt("androidx.hilt:hilt-compiler:$hilt_compose")
    implementation("androidx.hilt:hilt-navigation-compose:$hilt_compose")
}