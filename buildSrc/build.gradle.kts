plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.9.22"
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven {
        url = uri("https://repo.gradle.org/gradle/libs-releases")
    }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
}

kotlin{
    jvmToolchain(17)
}