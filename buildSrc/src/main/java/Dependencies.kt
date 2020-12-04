object Versions {
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30
    const val minSdkVersion = 23
    const val buildToolVersion = "30.0.0"
    const val versionCode = 1
    const val versionName = "1.0"
    const val kotlin = "1.4.20"
    const val gradle = "4.0.1"
    const val jvm = "1.8"

    const val coreKtx = "1.0.2"
    const val legacySupport = "1.0.0"
    const val androidxCore = "1.3.2"
    const val androidxAppCompat = "1.2.0"
    const val lifecycle = "2.0.0"
    const val junit = "4.13.1"
    const val androidJUnit = "1.1.2"
    const val espresso = "3.3.0"
    const val runner = "1.2.0"
    const val googleServices = "4.3.3"
    const val navigation = "2.3.0"
    const val material = "1.2.1"
}

object DefaultConfigs {
    const val applicationId = "com.octacoresoftwares.mito"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val consumerProguard = "consumer-rules.pro"
}

object AppClassPaths {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object TestDependencies {
    const val jUnit = "junit:junit:${Versions.junit}"
    const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object CoreDependencies {
    const val kotlinLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
}

object NavigationArchDependencies {
    const val navFragKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
}