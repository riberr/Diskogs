
plugins {
    kotlin("multiplatform") version "1.6.10" apply false
    kotlin("plugin.serialization") version "1.6.10" apply false
    kotlin("js") version "1.6.10" apply false
    kotlin("jvm") version "1.6.10" apply false
    // todo alias(libs.plugins.maven.publish) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}
