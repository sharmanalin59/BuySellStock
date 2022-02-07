package com.pluang.BuySellStock.strategy;

import com.pluang.BuySellStock.constant.StockStrategy;
import com.pluang.BuySellStock.constant.StockTargetTime;
import com.pluang.BuySellStock.dto.StockProfitBasedV1NonIntraResponse;
import com.pluang.BuySellStock.dto.StockProfitBasedV2NonIntraResponse;
import com.pluang.BuySellStock.entity.StockAuditDetail;

import java.math.BigDecimal;
import java.util.List;

public class StockProfitBasedNonIntra {

    private static StockProfitBasedV2NonIntraResponse getStockProfitBasedStrategy(BigDecimal shortProfit, BigDecimal longProfit) {
        if(shortProfit.compareTo(longProfit)
                > -1
        ) {
            return new StockProfitBasedV2NonIntraResponse(StockStrategy.Short, shortProfit);
        }
        else {
            return new StockProfitBasedV2NonIntraResponse(StockStrategy.Long, longProfit);
        }
    }

    public static StockProfitBasedV1NonIntraResponse getStockProfitBasedStrategyV1(BigDecimal shortProfit, BigDecimal longProfit) {
        if(shortProfit.compareTo(longProfit)
                > -1
        ) {
            return new StockProfitBasedV1NonIntraResponse(StockStrategy.Short,
                    StockTargetTime.Low,
                    shortProfit);
        }
        else {
            return new StockProfitBasedV1NonIntraResponse(StockStrategy.Long,
                    StockTargetTime.High,
                    longProfit);
        }
    }

    public static StockProfitBasedV1NonIntraResponse getStockProfitV1(StockAuditDetail stockAuditDetail) {
        BigDecimal shortProfit = stockAuditDetail.getOpenVal().subtract(stockAuditDetail.getLowVal());
        BigDecimal longProfit = stockAuditDetail.getHighVal().subtract(stockAuditDetail.getOpenVal());
        return getStockProfitBasedStrategyV1(shortProfit, longProfit);
    }

    public static StockProfitBasedV2NonIntraResponse getStockProfit(List<StockAuditDetail> stockAuditDetailList) {
        BigDecimal shortProfit = new BigDecimal("0.0");
        BigDecimal longProfit = new BigDecimal("0.0");
        for(StockAuditDetail stockAuditDetail : stockAuditDetailList) {
            shortProfit = shortProfit.add(stockAuditDetail.getOpenVal().subtract(stockAuditDetail.getLowVal()));
            longProfit = longProfit.add(stockAuditDetail.getHighVal().subtract(stockAuditDetail.getOpenVal()));
        }
        return getStockProfitBasedStrategy(shortProfit, longProfit);
    }
}
