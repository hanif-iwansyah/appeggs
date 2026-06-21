package com.hindustries.util;

import java.math.BigDecimal;

public class InsufficientStockException extends RuntimeException {
    private final String resourceName;
    private final BigDecimal requiredAmount;
    private final BigDecimal availableAmount;

    public InsufficientStockException(String resourceName, BigDecimal requiredAmount, BigDecimal availableAmount) {
        super(String.format("Stok tidak mencukupi untuk %s. Dibutuhkan: %s, Tersedia: %s",
                resourceName, requiredAmount.toPlainString(), availableAmount.toPlainString()));
        this.resourceName = resourceName;
        this.requiredAmount = requiredAmount;
        this.availableAmount = availableAmount;
    }

    public InsufficientStockException(String message) {
        super(message);
        this.resourceName = "";
        this.availableAmount = BigDecimal.ZERO;
        this.requiredAmount = BigDecimal.ZERO;
    }

    public String getResourceName() { return resourceName; }
    public BigDecimal getRequiredAmount() { return requiredAmount; }
    public BigDecimal getAvailableAmount() { return availableAmount; }

}
