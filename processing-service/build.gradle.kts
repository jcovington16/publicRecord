plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation("org.apache.kafka:kafka-clients:3.4.0")
    implementation("edu.stanford.nlp:stanford-corenlp:4.5.1") // NLP processing
}
