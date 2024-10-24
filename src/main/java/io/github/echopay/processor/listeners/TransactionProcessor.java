package io.github.echopay.processor.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class TransactionProcessor {

    @Value("${ECHO_PAY_URL}")
    private String echoPayUrl;

    private static final Logger logger = LoggerFactory.getLogger(TransactionProcessor.class);

    private final RestTemplate restTemplate;

    public TransactionProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @KafkaListener(topics = "transactions", groupId = "transaction-processor-group")
    public void processTransaction(String transactionUuid) {
        logger.info("Processing transaction with UUID: {}", transactionUuid);

        simulateProcessing();

        logger.info("Processing of transaction {} completed", transactionUuid);
        String updateUrl = echoPayUrl + transactionUuid + "/status";
        logger.info("URL: {}", updateUrl);
        logger.info("Updating transaction status to FINISHED: {}", transactionUuid);
        restTemplate.put(updateUrl, TransactionStatusUpdateRequest.finished());


        logger.info("Transaction {} processed and status updated to FINISHED", transactionUuid);
    }

    private void simulateProcessing() {
        try {
            Thread.sleep(3000);  // Simulate some processing delay
        } catch (InterruptedException e) {
            logger.error("Error during processing", e);
        }
    }
}
