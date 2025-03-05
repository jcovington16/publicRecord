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

    kotlin {
        jvmToolchain(21) // ✅ Use this instead of `jvmTarget = 21`
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21)) // ✅ Explicitly set Java 21
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }
}

tasks.test {
    useJUnitPlatform()
}
