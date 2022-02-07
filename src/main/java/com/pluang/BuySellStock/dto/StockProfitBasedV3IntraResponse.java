package com.pluang.BuySellStock.dto;

import com.pluang.BuySellStock.constant.StockStrategy;
import com.pluang.BuySellStock.constant.StockTargetTime;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StockProfitBasedV3IntraResponse {

    BigDecimal totalProfit;
    List<StockProfitDayDetail> stockProfitDayDetailList;

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public List<StockProfitDayDetail> getStockProfitDayDetailList() {
        return stockProfitDayDetailList;
    }

    public StockProfitBasedV3IntraResponse(BigDecimal totalProfit, List<StockProfitDayDetail> stockProfitDayDetailList) {
        this.totalProfit = totalProfit;
        this.stockProfitDayDetailList = stockProfitDayDetailList;
    }

    public static class StockProfitDayDetail {
        public StockProfitDayDetail(Date on, StockStrategy stockStrategy, BigDecimal profitPerUnit) {
            this.on = on;
            this.stockStrategy = stockStrategy;
            this.profitPerUnit = profitPerUnit;
        }

        public Date getOn() {
            return on;
        }

        public StockStrategy getStockStrategy() {
            return stockStrategy;
        }

        public BigDecimal getProfitPerUnit() {
            return profitPerUnit;
        }

        Date on;
        StockStrategy stockStrategy;
        BigDecimal profitPerUnit;
    }
}
