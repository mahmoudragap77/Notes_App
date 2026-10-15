// Top-level build file where you can add configuration options common to all sub-projects/projects.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.28" apply false
    id("org.jetbrains.kotlin.plugin.parcelize") version "2.5.0-Beta1" apply false
}