package com.pluang.BuySellStock.controller;

import com.pluang.BuySellStock.constant.PathConstants;
import com.pluang.BuySellStock.dto.*;
import com.pluang.BuySellStock.exception.ApplicationException;
import com.pluang.BuySellStock.service.StockAuditDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Controller
public class StockAuditController {

    @Autowired
    StockAuditDetailService auditDetailService;

    @PostMapping(value = PathConstants.ADD_STOCK_AUDIT)
    public ResponseEntity<Void> auditStocks(@RequestBody @NonNull StockAuditRequest stockAuditRequest) {
        auditDetailService.addStockAuditDetailBatch(stockAuditRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/{date}")
    public ResponseEntity<StockProfitBasedV1NonIntraResponse> maxProfit(@PathVariable("date") String dateStr) {

        try {
            DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy");
            java.sql.Date formattedDate = new java.sql.Date(targetFormat.parse(dateStr).getTime());

            return new ResponseEntity<>(auditDetailService.getIntraStockProfit(formattedDate), HttpStatus.OK);
        } catch (ParseException e) {
            throw new ApplicationException("Date is invalid");
        }
    }

    @GetMapping(value = "/api/v2/{fromDate}/{toDate}")
    public ResponseEntity<StockProfitBasedV2NonIntraResponse> maxProfitNonIntra(@PathVariable("fromDate") String fromDateStr, @PathVariable("toDate") String toDateStr) {

        try {
            DateFormat fromFormat = new SimpleDateFormat("MM-dd-yyyy");
            java.sql.Date fromFormattedDate = new java.sql.Date(fromFormat.parse(fromDateStr).getTime());

            DateFormat toFormat = new SimpleDateFormat("MM-dd-yyyy");
            java.sql.Date toFormattedDate = new java.sql.Date(toFormat.parse(toDateStr).getTime());

            return new ResponseEntity<>(auditDetailService.getNonIntraStockAuditDetail(fromFormattedDate, toFormattedDate), HttpStatus.OK);
        } catch (ParseException e) {
            throw new ApplicationException("Date is invalid");
        }
    }

    @GetMapping(value = "/api/v3/{fromDate}/{toDate}")
    public ResponseEntity<StockProfitBasedV3IntraResponse> maxProfitIntra(@PathVariable("fromDate") String fromDateStr, @PathVariable("toDate") String toDateStr) {

        try {
            DateFormat fromFormat = new SimpleDateFormat("MM-dd-yyyy");
            java.sql.Date fromFormattedDate = new java.sql.Date(fromFormat.parse(fromDateStr).getTime());

            DateFormat toFormat = new SimpleDateFormat("MM-dd-yyyy");
            java.sql.Date toFormattedDate = new java.sql.Date(toFormat.parse(toDateStr).getTime());

            return new ResponseEntity<>(auditDetailService.getIntraStockProfit(fromFormattedDate, toFormattedDate), HttpStatus.OK);
        } catch (ParseException e) {
            throw new ApplicationException("Date is invalid");
        }
    }
}
