package io.github.echopay.processor.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionProcessingService.class);

    @Transactional
    public void processTransaction(String transactionUuid) {
        logger.info("Processing transaction with UUID: {}", transactionUuid);

        // Simulate processing (e.g., delay, external API call)
        simulateProcessing();

        // Update transaction status to FINISHED
        logger.info("Transaction {} processed and updated to FINISHED", transactionUuid);
    }

    private void simulateProcessing() {
        try {
            Thread.sleep(3000);  // Simulate delay
        } catch (InterruptedException e) {
            logger.error("Error during processing", e);
        }
    }
}
