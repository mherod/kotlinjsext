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
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.31")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("io.ktor:ktor-client-core:1.6.7")
    implementation("io.ktor:ktor-client-json:1.6.7")
    implementation("io.ktor:ktor-client-serialization:1.6.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation(npm("kotlin", "^1.5.31", generateExternals = false))
    implementation(npm("node-fetch", "^3.0.0", generateExternals = false))
}

kotlin {
    js(LEGACY) {
//        binaries.executable()
        nodejs()
    }
}

val build = tasks.getByName("build")

val copyBuildToRoot = task<Copy>("copyBuildToRoot") {
    dependsOn(build)
    from("$buildDir/js/packages/${rootProject.name}/kotlin/")
    into("$projectDir")
    include { it.file.isFile }
}

build.finalizedBy(copyBuildToRoot)

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
