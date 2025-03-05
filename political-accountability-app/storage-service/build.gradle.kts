plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation("org.postgresql:postgresql:42.5.1")
    implementation("org.jetbrains.exposed:exposed-core:0.41.1") // Kotlin SQL ORM
    implementation("org.elasticsearch.client:elasticsearch-rest-high-level-client:7.17.5")
}
