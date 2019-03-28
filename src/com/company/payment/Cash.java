package com.company.payment;

public class Cash extends Payment {

    // region Constructor
    public Cash(float amount) {
        super(amount);
    }
    // endregion Constructor

    protected void logPayment() {
        //todo implement
        throw new UnsupportedOperationException();
    }

    protected void printReceipt() {
        //todo implement
        hardwareRep.printReceipt("");
        throw new UnsupportedOperationException();
    }

    protected void performTransaction() {
        //todo implement
        throw new UnsupportedOperationException();
    }
}
