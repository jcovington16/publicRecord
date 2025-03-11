plugins {
    kotlin("jvm") version "1.9.24"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")

    group = "com.publicrecord"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    java { // ✅ Keep only this for Java 21
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }
}

dependencies {
    implementation(project(":storage-service"))
    implementation(project(":api-gateway"))

    // Add Dropwizard dependencies to the root project
    implementation("io.dropwizard:dropwizard-core:2.1.4")
    implementation("io.dropwizard:dropwizard-client:2.1.4")
    implementation("io.dropwizard:dropwizard-auth:2.1.4")
    implementation("io.dropwizard:dropwizard-assets:2.1.4")
}

tasks.test {
    useJUnitPlatform()
}