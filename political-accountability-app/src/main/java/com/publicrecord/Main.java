package com.publicrecord;

import com.publicrecord.api.App;
import com.publicrecord.storage.services.DatabaseService;
import com.publicrecord.storage.services.ElasticsearchService;
import com.publicrecord.storage.services.MinIOService;
import com.publicrecord.storage.services.KafkaService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Political Accountability System...");

        // Initialize all core services
        DatabaseService databaseService = new DatabaseService();
        ElasticsearchService elasticsearchService = new ElasticsearchService();
        MinIOService minioService = new MinIOService();
        KafkaService kafkaService = new KafkaService();

        databaseService.startService();
        elasticsearchService.startService();
        minioService.startService();
        kafkaService.startService();

        // Start Dropwizard API
        try {
            App.main(new String[]{"server", "api-gateway/src/main/resources/config.yml"});
        } catch (Exception e) {
            System.err.println("Error starting API Gateway: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("All services started successfully.");
    }
}
