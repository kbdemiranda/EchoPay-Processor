package io.github.echopay.processor.listeners;

public class TransactionStatusUpdateRequest {

    private String status;

    public TransactionStatusUpdateRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static TransactionStatusUpdateRequest finished() {
        return new TransactionStatusUpdateRequest("FINISHED");
    }
}
