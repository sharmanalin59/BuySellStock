package com.pluang.BuySellStock.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Date;

public class StockAuditDetail {

    @JsonProperty("Date")
    @JsonFormat(pattern = "MM/dd/yy")
    Date onDate;
    @JsonProperty("Open")
    BigDecimal openVal;
    @JsonProperty("High")
    BigDecimal highVal;
    @JsonProperty("Low")
    BigDecimal lowVal;
    @JsonProperty("Close")
    BigDecimal closeVal;
    @JsonProperty("Volume")
    Long volume;

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public void setOpenVal(BigDecimal openVal) {
        this.openVal = openVal;
    }

    public void setHighVal(BigDecimal highVal) {
        this.highVal = highVal;
    }

    public void setLowVal(BigDecimal lowVal) {
        this.lowVal = lowVal;
    }

    public void setCloseVal(BigDecimal closeVal) {
        this.closeVal = closeVal;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Date getOnDate() {
        return onDate;
    }

    public BigDecimal getOpenVal() {
        return openVal;
    }

    public BigDecimal getHighVal() {
        return highVal;
    }

    public BigDecimal getLowVal() {
        return lowVal;
    }

    public BigDecimal getCloseVal() {
        return closeVal;
    }

    public Long getVolume() {
        return volume;
    }
}