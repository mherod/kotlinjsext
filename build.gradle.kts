@file:Suppress("SuspiciousCollectionReassignment")

import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val requestedKotlinVersion = "1.6.10"
    kotlin("js") version requestedKotlinVersion
    kotlin("plugin.serialization") version requestedKotlinVersion
}

val kotlinVersion: String by lazy {
    KotlinCompilerVersion.VERSION
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        name = "ktor-eap"
    }
}

dependencies {
    implementation("io.ktor:ktor-client-core:2.0.0-eap-256")
    implementation("io.ktor:ktor-client-json:2.0.0-eap-256")
    implementation("io.ktor:ktor-client-serialization:2.0.0-eap-256")
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation(npm("kotlin", "^$kotlinVersion", generateExternals = false))
    implementation(npm("node-fetch", "^3.0.0", generateExternals = false))
}

kotlin {
    js(LEGACY) {
        nodejs()
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions { applyKotlinCompilerOptions() }
}

tasks.withType<Kotlin2JsCompile> {
    kotlinOptions { applyKotlinCompilerOptions() }
}

fun KotlinCommonOptions.applyKotlinCompilerOptions() {
    languageVersion = kotlinVersion.substringBeforeLast('.')
    listOf(
        "-Xopt-in=kotlin.RequiresOptIn",
        "-Xopt-in=kotlin.js.ExperimentalJsExport",
        "-Xopt-in=kotlin.experimental.ExperimentalTypeInference",
        "-Xir-property-lazy-initialization",
        "-Xerror-tolerance-policy=SYNTAX"
    ).filter { newArg ->
        newArg !in freeCompilerArgs
    }.forEach { newArg ->
        freeCompilerArgs += newArg
    }
}
