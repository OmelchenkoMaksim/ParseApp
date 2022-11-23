plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.data"
    compileSdk = 33
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
}