package com.company.localization;

public class LocalizationItems {
    private String key;
    private String value;

    // region Constructor
    public LocalizationItems(String key, String value) {
        this.key = key;
        this.value = value;
    }
    // endregion Constructor

    // region accessors
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    // endregion accessors

    // region mutators
    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
    // endregion mutators
}
