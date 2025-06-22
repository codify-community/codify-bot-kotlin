plugins {
    kotlin("jvm") version "2.1.20"
}

group = "io.github.codify"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.dv8tion:JDA:5.6.1")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
    implementation("org.jetbrains.exposed:exposed-core:0.61.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.61.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.61.0")
    implementation("com.h2database:h2:2.3.232")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}