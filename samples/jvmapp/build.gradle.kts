plugins {
    kotlin("jvm")
    application
}

kotlin {
    dependencies {
        implementation(project(":diskogs"))
        implementation("io.ktor:ktor-client-cio:1.6.7")
        testImplementation(kotlin("test"))
    }

    tasks.test {
        useJUnitPlatform()
    }
}