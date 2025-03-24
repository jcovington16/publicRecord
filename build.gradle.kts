plugins {
    kotlin("jvm") version "1.9.24"
    id("com.github.johnrengelman.shadow") version "8.1.1"
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

    // SLF4J API
    implementation("org.slf4j:slf4j-api:2.0.7")
    // Logback Classic (SLF4J implementation)
    implementation("ch.qos.logback:logback-classic:1.4.7")
}

tasks.shadowJar {
    archiveFileName.set("political-accountability-app-all.jar")
    manifest {
        attributes["Main-Class"] = "com.publicrecord.Main"
    }
    mergeServiceFiles()  // This is critical to merge META-INF/services files
}



tasks.test {
    useJUnitPlatform()
}