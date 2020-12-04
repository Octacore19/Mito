object Versions {
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30
    const val minSdkVersion = 23
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildToolVersion = "30.0.0"
    const val kotlin = "1.4.20"
    const val gradle = "4.0.1"
    const val jvm = "1.8"

    const val legacySupport = "1.0.0"
    const val androidxCore = "1.3.2"
    const val androidxAppCompat = "1.2.0"
    const val cardView = "1.0.0"
    const val recyclerView = "1.1.0"
    const val constraintLayout = "2.0.4"
    const val lifecycle = "2.2.0"
    const val junit = "4.13.1"
    const val androidJUnit = "1.1.2"
    const val espresso = "3.3.0"
    const val runner = "1.2.0"
    const val googleServices = "4.3.3"
    const val navigation = "2.3.0"
    const val material = "1.2.1"
    const val glide = "4.11.0"
    const val room = "2.2.5"
    const val coroutine = "2.3.0-beta01"
    const val work = "2.4.0"
    const val dagger = "2.27"
    const val firebase = "26.0.0"
    const val circleImageView = "3.0.1"
    const val mockito = "3.3.1"
    const val coreTesting = "1.1.1"
}

object DefaultConfigs {
    const val dataBinding = true

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
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val coreTesting = "android.arch.core:core-testing:${Versions.coreTesting}"
}

object CoreDependencies {
    const val kotlinLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
}

object ViewsDependencies {
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"
}

object AndroidArchDependencies {
    const val navFragKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    const val room = "androidx.room:room-ktx:${Versions.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val work = "androidx.work:work-runtime-ktx:${Versions.work}"

    const val dagger =  "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object FirebaseDependencies {
    const val platformBOM = "com.google.firebase:firebase-bom:${Versions.firebase}"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val auth = "com.google.firebase:firebase-auth-ktx"
    const val firestore = "com.google.firebase:firebase-firestore-ktx"
}

object OtherUtilityDependencies {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object CoroutineDependencies {
    const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutine}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutine}"
    const val liveData =  "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.coroutine}"
}

object NetworkDependencies {

}