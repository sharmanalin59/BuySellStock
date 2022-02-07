package com.pluang.BuySellStock.dto;

import com.pluang.BuySellStock.constant.StockStrategy;
import com.pluang.BuySellStock.constant.StockTargetTime;

import java.math.BigDecimal;

public class StockProfitBasedV1NonIntraResponse {
    StockStrategy stockStrategy;
    StockTargetTime stockTargetTime;
    BigDecimal profitPerUnit;

    public StockStrategy getStockStrategy() {
        return stockStrategy;
    }

    public StockTargetTime getStockTargetTime() {
        return stockTargetTime;
    }

    public BigDecimal getProfitPerUnit() {
        return profitPerUnit;
    }

    public StockProfitBasedV1NonIntraResponse(StockStrategy stockStrategy, StockTargetTime stockTargetTime, BigDecimal profitPerUnit) {
        this.stockStrategy = stockStrategy;
        this.stockTargetTime = stockTargetTime;
        this.profitPerUnit = profitPerUnit;
    }
}
