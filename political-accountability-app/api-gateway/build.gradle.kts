plugins {
    kotlin("jvm")
    id("application") // Ensure the application plugin is explicitly declared
}

dependencies {
    implementation(project(":common"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

application {
    mainClass.set("com.publicrecord.api.MainKt")
}
