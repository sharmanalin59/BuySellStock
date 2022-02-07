package com.pluang.BuySellStock.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="stock_audit_detail")
public class StockAuditDetail {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="on_date")
    Date onDate;

    @Column(name="open_val")
    BigDecimal openVal;
    @Column(name="high_val")
    BigDecimal highVal;
    @Column(name="low_val")
    BigDecimal lowVal;
    @Column(name="close_val")
    BigDecimal closeVal;
    @Column(name="volume")
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
