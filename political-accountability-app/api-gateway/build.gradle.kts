plugins {
    kotlin("jvm")
    id("application") // Ensure the application plugin is explicitly declared
}

dependencies {
    implementation(project(":common"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("io.dropwizard:dropwizard-core:2.1.6")
    implementation("org.postgresql:postgresql:42.5.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.0")
    implementation("org.hibernate:hibernate-core:6.2.0.Final")
    implementation("org.hibernate:hibernate-envers:6.2.0.Final") // For auditing
}

application {
    mainClass.set("com.publicrecord.api.MainKt")
}
