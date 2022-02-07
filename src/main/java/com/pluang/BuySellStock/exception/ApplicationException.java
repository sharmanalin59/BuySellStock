package com.pluang.BuySellStock.exception;

public class ApplicationException extends RuntimeException {
    String mssg;

    public ApplicationException(String mssg) {
        this.mssg = mssg;
    }
}
