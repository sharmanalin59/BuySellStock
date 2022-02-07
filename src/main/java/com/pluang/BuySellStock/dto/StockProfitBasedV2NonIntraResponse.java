package com.pluang.BuySellStock.dto;

import com.pluang.BuySellStock.constant.StockStrategy;
import com.pluang.BuySellStock.constant.StockTargetTime;

import java.math.BigDecimal;

public class StockProfitBasedV2NonIntraResponse {
    StockStrategy stockStrategy;
    BigDecimal profitPerUnit;

    public StockStrategy getStockStrategy() {
        return stockStrategy;
    }

    public BigDecimal getProfitPerUnit() {
        return profitPerUnit;
    }

    public StockProfitBasedV2NonIntraResponse(StockStrategy stockStrategy, BigDecimal profitPerUnit) {
        this.stockStrategy = stockStrategy;
        this.profitPerUnit = profitPerUnit;
    }
}
