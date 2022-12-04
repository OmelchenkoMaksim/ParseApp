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

    // need for tests
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter")
}
