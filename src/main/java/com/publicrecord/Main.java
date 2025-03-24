package com.publicrecord;

import com.publicrecord.api.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting Political Accountability System...");

        try {
            App.main(new String[]{"server", "api-gateway/src/main/resources/config.yml"});
            logger.info("API Gateway started successfully.");
        } catch (Exception e) {
            logger.error("Error starting API Gateway: " + e.getMessage(), e);
        }

        logger.info("All services started successfully.");
    }
}
