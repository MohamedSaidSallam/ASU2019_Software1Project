package com.company.hardwarereplacement;

public class HardwareRep {

    // region Singleton
    private static HardwareRep instance = null;

    private HardwareRep() {

    }

    public static HardwareRep getInstance() {
        if (instance == null)
            instance = new HardwareRep();

        return instance;
    }
    // endregion Singleton

    private void ShowMsg(String msg) {
        //todo implement
        throw new UnsupportedOperationException();
    }

    public void printReceipt(String msg) {
        ShowMsg(msg);
    }

    public void printTicket(String msg) {
        ShowMsg(msg);
    }
}
