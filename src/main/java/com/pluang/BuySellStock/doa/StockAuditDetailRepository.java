package com.pluang.BuySellStock.doa;

import com.pluang.BuySellStock.entity.StockAuditDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StockAuditDetailRepository extends CrudRepository<StockAuditDetail, Date> {
    public StockAuditDetail findStockAuditDetailByOnDate(Date on);

    @Query(value = "from StockAuditDetail t where t.onDate BETWEEN :startDate AND :endDate")
    public List<StockAuditDetail> getAllBetweenDates(@Param("startDate")Date startDate, @Param("endDate") Date endDate);}
