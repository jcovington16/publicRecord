package com.publicrecord;

import com.publicrecord.api.App;
import com.publicrecord.storage.services.DatabaseService;
import com.publicrecord.storage.services.ElasticSearchService;
import com.publicrecord.storage.services.MinIOService;
import com.publicrecord.storage.services.KafkaService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Political Accountability System...");

        // Define path to config.yml
        String configPath = "api-gateway/src/main/resources/config.yml";

        // Initialize all core services
        DatabaseService databaseService = new DatabaseService();
        ElasticSearchService elasticsearchService = new ElasticSearchService();
        MinIOService minioService = new MinIOService();
        KafkaService kafkaService = new KafkaService();

        try {
            App app = new App();
            app.startServer();
        } catch (Exception e) {
            System.err.println("Error starting API Gateway: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("All services started successfully.");
    }
}
