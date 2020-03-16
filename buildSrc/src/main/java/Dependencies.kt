import Versions.android_ktx_version
import Versions.appcompat_version
import Versions.arch_test_version
import Versions.constraintlayout_version
import Versions.coroutines_version
import Versions.espresso_version
import Versions.junit_android_version
import Versions.junit_version
import Versions.koin_version
import Versions.kotlin_version
import Versions.lifecycle_version
import Versions.mockk_version
import Versions.moshi_version
import Versions.retrofit_coroutines_version
import Versions.retrofit_version
import Versions.room_version

object Versions {
    const val kotlin_version = "1.3.70"
    const val appcompat_version = "1.1.0"
    const val android_ktx_version = "1.2.0"
    const val koin_version = "2.1.4"
    const val coroutines_version = "1.3.4"
    const val lifecycle_version = "2.2.0"
    const val retrofit_version = "2.7.1"
    const val moshi_version = "2.6.0"
    const val retrofit_coroutines_version = "0.9.2"
    const val room_version = "2.2.4"
    const val mockk_version = "1.9.3"
    const val junit_version = "4.13"
    const val junit_android_version = "1.1.1"
    const val arch_test_version = "1.1.1"
    const val espresso_version = "3.2.0"
    const val constraintlayout_version = "1.1.3"


}

object Dependencies {
    //kotlinlib
    val kotlinLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    //appcompat
    val appcompat = "androidx.appcompat:appcompat:$appcompat_version"

    //constrainlayout
    val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintlayout_version"

    //androidktx
    val androidKtxCore = "androidx.core:core-ktx:$android_ktx_version"

    //lifecycle
    val lifecycleAnnotations = "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
    val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    val viewModelScope = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"

    //coroutines
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"

    //koin
    val koinAndroid = "org.koin:koin-android:$koin_version"
    val koinAndroidScope = "org.koin:koin-android-scope:$koin_version"
    val koinViewModel = "org.koin:koin-android-viewmodel:$koin_version"
    val koinExperimental = "org.koin:koin-android-ext:$koin_version"

    //retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
    val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:$moshi_version"
    val retrofitCoroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$retrofit_coroutines_version"

    //room
    val room = "androidx.room:room-runtime:$room_version"
    val roomCompiler = "androidx.room:room-compiler:$room_version"
    val roomKtxCoroutines = "androidx.room:room-ktx:$room_version"

    //test
    //mockk
    val mockK = "io.mockk:mockk:$mockk_version"
    val mockKAndroid = "io.mockk:mockk-android:$mockk_version"

    //junit
    val junit = "junit:junit:$junit_version"
    val junitAndroid = "androidx.test.ext:junit:$junit_android_version"

    //architecture core test
    val archTest = "android.arch.core:core-testing:$arch_test_version"

    //espresso
    val espresso = "androidx.test.espresso:espresso-core:$espresso_version"

    //coroutines
    val coroutinesTestRule = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version"
}