import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
    id("org.openjfx.javafxplugin") version "0.0.8"
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls", "javafx.graphics")
}

group = "me.tsnan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation("no.tornado:tornadofx:1.7.20")
    testImplementation(kotlin("test-junit"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}
