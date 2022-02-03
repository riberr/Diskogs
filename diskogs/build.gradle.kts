plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    //id("maven-publish")
}

group = "me.riberr.diskogs"
version = "0.0.1"//project.property("VERSION_NAME") as String

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    js(IR) {
        browser()
        binaries.executable()
    }
    /*
    js(BOTH) {
        nodejs()

        //browser {
        //    commonWebpackConfig {
        //        cssSupport.enabled = true
        //    }
        //}
    }
    */

    /*
    // todo: native will work once kotlin 1.6.20 is released:
    // https://youtrack.jetbrains.com/issue/KT-49330

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    */


    val ktorVersion = "1.6.7"

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.ktor:ktor-client-core:$ktorVersion")
                api("io.ktor:ktor-client-serialization:$ktorVersion")
                api("io.ktor:ktor-client-logging:$ktorVersion")
                api("ch.qos.logback:logback-classic:1.2.10")
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        //val nativeMain by getting
        //val nativeTest by getting
    }
}

// Reduces Kotlin/JS bundle size
// https://youtrack.jetbrains.com/issue/KTOR-1084
tasks.withType<org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile> {
    kotlinOptions {
        freeCompilerArgs += listOf("-Xir-per-module", "-Xir-property-lazy-initialization")
    }
}
