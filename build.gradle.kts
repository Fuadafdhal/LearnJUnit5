plugins {
    java
    kotlin("jvm") version "1.5.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")

    testImplementation("org.mockito:mockito-junit-jupiter:3.5.13")
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).all {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.named<Test>("test"){
    useJUnitPlatform {
        excludeTags("integration-test")
    }
}

tasks.register("integration-test", Test::class) {
    useJUnitPlatform {
        includeTags("integration-test")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform {
        excludeTags("integration-test")
    }
}