package com.pluang.BuySellStock.strategy;

import com.pluang.BuySellStock.constant.StockStrategy;
import com.pluang.BuySellStock.dto.StockProfitBasedV3IntraResponse;
import com.pluang.BuySellStock.entity.StockAuditDetail;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StockProfitBasedIntra {

    private static StockProfitBasedV3IntraResponse.StockProfitDayDetail getStockProfitBasedStrategy(BigDecimal shortProfit, BigDecimal longProfit,
                                                                                                    Date on) {
        if(shortProfit.compareTo(longProfit)
                > -1
        ) {
            return new StockProfitBasedV3IntraResponse.StockProfitDayDetail(on,
                    StockStrategy.Short,
                    shortProfit);
        }
        else {
            return new StockProfitBasedV3IntraResponse.StockProfitDayDetail(on,
                    StockStrategy.Long,
                    longProfit);
        }
    }

    public static StockProfitBasedV3IntraResponse.StockProfitDayDetail getStockProfit(StockAuditDetail stockAuditDetail) {
        BigDecimal shortProfit = stockAuditDetail.getOpenVal().subtract(stockAuditDetail.getLowVal());
        BigDecimal longProfit = stockAuditDetail.getHighVal().subtract(stockAuditDetail.getOpenVal());
        return getStockProfitBasedStrategy(shortProfit, longProfit, stockAuditDetail.getOnDate());
    }

    public static StockProfitBasedV3IntraResponse getStockProfit(List<StockAuditDetail> stockAuditDetailList) {
        StockProfitBasedV3IntraResponse stockProfitBasedIntraResponse = new StockProfitBasedV3IntraResponse(new BigDecimal("0.0"), new ArrayList<>());
        for(StockAuditDetail stockAuditDetail :stockAuditDetailList) {
            StockProfitBasedV3IntraResponse.StockProfitDayDetail stockProfitDayDetail = getStockProfit(stockAuditDetail);
            stockProfitBasedIntraResponse.setTotalProfit(stockProfitBasedIntraResponse.getTotalProfit().add(stockProfitDayDetail.getProfitPerUnit()));
            stockProfitBasedIntraResponse.getStockProfitDayDetailList().add(stockProfitDayDetail);
        }

        return stockProfitBasedIntraResponse;
    }
}
