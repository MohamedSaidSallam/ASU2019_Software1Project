package com.company.payment;

import com.company.prototyping.HardwareProto;

public class Cash extends Payment {

    // region Constructor
    public Cash(float amount) {
        super(amount);
    }
    // endregion Constructor

    @Override
    protected void logPayment() {
        //todo implement
        throw new UnsupportedOperationException();
    }

    @Override
    protected void printReceipt() {
        //todo implement
        HardwareProto.printReceipt("");
        throw new UnsupportedOperationException();
    }

    @Override
    protected void performTransaction() {
        //todo implement
        throw new UnsupportedOperationException();
    }
}
