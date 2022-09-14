import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

plugins {
    id("com.android.application")
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.mparticle.example.higgsshopsampleapp"
        minSdk = 23
        targetSdk = 33
        versionCode = buildVersionCode()
        versionName = "0.12.0-SNAPSHOT"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "HIGGS_SHOP_SAMPLE_APP_KEY", "\"${System.getenv("HIGGS_SHOP_SAMPLE_APP_KEY")}\"")
        buildConfigField("String", "HIGGS_SHOP_SAMPLE_APP_SECRET", "\"${System.getenv("HIGGS_SHOP_SAMPLE_APP_SECRET")}\"")
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    // Compose
    val composeVersion = "1.2.1"
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.fragment:fragment:1.3.6")
    implementation("androidx.fragment:fragment-ktx:1.3.6")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("com.mparticle:android-core:5.45.0")

    implementation("androidx.navigation:navigation-fragment:2.3.5")
    implementation("androidx.navigation:navigation-ui:2.3.5")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    implementation("com.github.bumptech.glide:glide:4.13.2")

    api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.4")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation("com.squareup.retrofit2:converter-moshi:2.6.1")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.1")
    implementation("io.reactivex.rxjava2:rxjava:2.1.14")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.1")

    val roomVersion = "2.4.3"
    implementation("androidx.room:room-runtime:$roomVersion")
    // annotationProcessor("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    // ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-rxjava2:$roomVersion")
    // implementation("androidx.room:room-rxjava3:$roomVersion")
    // implementation("androidx.room:room-guava:$roomVersion")
    // implementation("androidx.room:room-paging:2.4.1")
    testImplementation("androidx.room:room-testing:$roomVersion")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:core:1.4.0")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.3")
    androidTestImplementation("androidx.test.ext:truth:1.4.0")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    androidTestUtil("androidx.test:orchestrator:1.4.1")
}

fun buildVersionCode(): Int {
    val df = SimpleDateFormat("yyyyMMddHH")
    df.timeZone = TimeZone.getTimeZone("EST")
    return df.format(Date()).toInt()
}
