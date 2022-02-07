package com.pluang.BuySellStock.service;

import com.pluang.BuySellStock.doa.StockAuditDetailRepository;
import com.pluang.BuySellStock.dto.StockAuditRequest;
import com.pluang.BuySellStock.dto.StockProfitBasedV1NonIntraResponse;
import com.pluang.BuySellStock.dto.StockProfitBasedV3IntraResponse;
import com.pluang.BuySellStock.dto.StockProfitBasedV2NonIntraResponse;
import com.pluang.BuySellStock.entity.StockAuditDetail;
import com.pluang.BuySellStock.strategy.StockProfitBasedIntra;
import com.pluang.BuySellStock.strategy.StockProfitBasedNonIntra;
import com.pluang.BuySellStock.util.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StockAuditDetailService {

    @Autowired
    StockAuditDetailRepository stockAuditDetailRepository;

    public void addStockAuditDetailBatch(StockAuditRequest stockAuditRequest) {

        List<StockAuditDetail> stockAuditDetailList = DtoToEntity.getStockAuditDetailList(stockAuditRequest.getStockAuditDetailList());
        final int batchSize = 100;
        final int totalObjects = stockAuditDetailList.size();

        for (int i = 0; i < totalObjects; i = i + batchSize) {
            if (i + batchSize > totalObjects) {

                List<StockAuditDetail> stockAuditDetail = stockAuditDetailList.subList(i, totalObjects);

                stockAuditDetailRepository.saveAll(stockAuditDetail);

                break;

            }

            List<StockAuditDetail> stockAuditDetail = stockAuditDetailList.subList(i, i + batchSize);

            stockAuditDetailRepository.saveAll(stockAuditDetail);
        }
    }

    public StockProfitBasedV1NonIntraResponse getIntraStockProfit(Date on) {
        StockAuditDetail stockAuditDetail = stockAuditDetailRepository.findStockAuditDetailByOnDate(on);
        return StockProfitBasedNonIntra.getStockProfitV1(stockAuditDetail);
    }

    public StockProfitBasedV3IntraResponse getIntraStockProfit(Date from, Date to) {
        return StockProfitBasedIntra.getStockProfit(stockAuditDetailRepository.getAllBetweenDates(from, to));
    }

    public StockProfitBasedV2NonIntraResponse getNonIntraStockAuditDetail(Date from, Date to) {
        return StockProfitBasedNonIntra.getStockProfit(stockAuditDetailRepository.getAllBetweenDates(from, to));
    }
}
