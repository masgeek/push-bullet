
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    id("maven-publish")
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    id("java-library")
}

group = "com.masgeek"
//version = "1.0.0"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }

}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:32.1.2-jre")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0") // Jackson integration
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")

//    testImplementation("org.mockito.core:5.5.0")
//    testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")


}

configure<PublishingExtension> {
    publications.create<MavenPublication>("push-bullet") {
        groupId = project.group as String
        artifactId = project.name
        version = project.version as String
        pom.packaging = "jar"
        //artifact("$buildDir/libs/pushbullet.jar")

    }
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin{
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.named("jar") {
    enabled = true
}
