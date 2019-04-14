
package com.company.payment;

public abstract class Payment {

    // region variables
    protected float amount;
    // region variables

    // region Constructor
    public Payment(float amount) {
        this.amount = amount;
    }
    // endregion Constructor

    // region accessors
    public float getAmount() {
        return amount;
    }
    // endregion accessors

    // region mutators
    public void setAmount(float amount) {
        this.amount = amount;
    }
    // endregion mutators

    protected abstract void logPayment();

    protected abstract void printReceipt();

    protected abstract void performTransaction();

    public void pay() {
        performTransaction();
        logPayment();
        printReceipt();
    }
}
