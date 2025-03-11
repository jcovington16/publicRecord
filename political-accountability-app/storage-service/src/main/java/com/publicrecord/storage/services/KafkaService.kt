package com.publicrecord.storage.services

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties
import java.time.Duration

class KafkaService {
    private val bootstrapServers = "localhost:9092"
    private val topicName = "political-events"

    private val producerProps = Properties().apply {
        put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
        put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
        put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    }

    private val producer = KafkaProducer<String, String>(producerProps)

    fun startService() {
        println("✅ Kafka Service Started.")
    }


    fun sendMessage(key: String, message: String) {
        val record = ProducerRecord(topicName, key, message)
        producer.send(record)
        println("Sent message: $message")
    }

    private val consumerProps = Properties().apply {
        put("bootstrap.servers", bootstrapServers)
        put("group.id", "political-group")
        put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    }
    private val consumer = KafkaConsumer<String, String>(consumerProps)


    fun consumeMessages() {
        consumer.subscribe(listOf(topicName))
        while (true) {
            val records = consumer.poll(Duration.ofMillis(1000)) // ✅ Updated
            for (record in records) {
                println("Received message: ${record.value()}")
            }
        }
    }

}
