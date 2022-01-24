plugins {
    kotlin("multiplatform") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("maven-publish")
}

group = "me.riberr.discogskt"
//group = "com.github.riberr"
version = "0.0.1"

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
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    val ktorVersion = "1.6.7"

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.ktor:ktor-client-core:$ktorVersion")
                //api("io.ktor:ktor-client-auth:$ktorVersion")
                api("io.ktor:ktor-client-serialization:$ktorVersion")
                api("io.ktor:ktor-client-logging:$ktorVersion")
                api("ch.qos.logback:logback-classic:1.2.10")
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }
        val jsTest by getting
        val nativeMain by getting {
            dependencies {
                // todo: install libcurl
                //implementation("io.ktor:ktor-client-curl:$ktorVersion")
            }
        }
        val nativeTest by getting
    }
}

// Reduces Kotlin/JS bundle size
// https://youtrack.jetbrains.com/issue/KTOR-1084
tasks.withType<org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile> {
    kotlinOptions {
        freeCompilerArgs += listOf("-Xir-per-module", "-Xir-property-lazy-initialization")
    }
}
