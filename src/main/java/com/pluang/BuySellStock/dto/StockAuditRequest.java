package com.pluang.BuySellStock.dto;

import java.util.List;

public class StockAuditRequest {
    List<StockAuditDetail> stockAuditDetailList;

    public void setStockAuditDetailList(List<StockAuditDetail> stockAuditDetailList) {
        this.stockAuditDetailList = stockAuditDetailList;
    }

    public List<StockAuditDetail> getStockAuditDetailList() {
        return stockAuditDetailList;
    }


}
