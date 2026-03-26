// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlinter) apply false
}

subprojects {
    apply(plugin = "org.jmailen.kotlinter")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
