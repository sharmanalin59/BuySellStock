drop table stock_audit_detail;
CREATE TABLE stock_audit_detail (
	id BigInt NOT NULL AUTO_INCREMENT,
    on_date Date,
	open_val DECIMAL(20,10),
    high_val DECIMAL(20,10),
	low_val DECIMAL(20,10),
    close_val DECIMAL(20,10),
    volume BigInt,
    PRIMARY KEY (id)
);