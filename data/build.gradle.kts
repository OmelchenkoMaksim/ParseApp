plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.data"
    compileSdk = 33
}

// need for tests
tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.core:core-ktx:1.10.1")

}
