@file:Suppress("SuspiciousCollectionReassignment")

import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("js") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
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
    implementation(npm("kotlin", "^1.5.31", generateExternals = false))
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
    languageVersion = "1.5"
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
