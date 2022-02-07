package com.pluang.BuySellStock.util;

import com.pluang.BuySellStock.dto.StockAuditRequest;
import com.pluang.BuySellStock.entity.StockAuditDetail;
import com.pluang.BuySellStock.exception.ApplicationException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DtoToEntity {

    public static StockAuditDetail getStockAuditDetail(com.pluang.BuySellStock.dto.StockAuditDetail stockAuditDetailDto) {
        StockAuditDetail stockAuditDetail = new StockAuditDetail();

        try {
            DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date formattedDate = new Date(targetFormat.parse(stockAuditDetailDto.getOnDate().toString()).getTime());
            stockAuditDetail.setOnDate(formattedDate);
        } catch (ParseException e) {
            throw new ApplicationException("Date is invalid");
        }
        stockAuditDetail.setOpenVal(stockAuditDetailDto.getOpenVal());
        stockAuditDetail.setHighVal(stockAuditDetailDto.getHighVal());
        stockAuditDetail.setLowVal(stockAuditDetailDto.getLowVal());
        stockAuditDetail.setCloseVal(stockAuditDetailDto.getCloseVal());
        stockAuditDetail.setVolume(stockAuditDetailDto.getVolume());
        return stockAuditDetail;
    }

    public static List<StockAuditDetail> getStockAuditDetailList(List<com.pluang.BuySellStock.dto.StockAuditDetail> stockAuditDetailDtoList) {
        List<StockAuditDetail> stockAuditDetailList = new ArrayList<>();
        for(com.pluang.BuySellStock.dto.StockAuditDetail stockAuditDetail: stockAuditDetailDtoList) {
            stockAuditDetailList.add(getStockAuditDetail(stockAuditDetail));
        }
        return stockAuditDetailList;
    }
}
