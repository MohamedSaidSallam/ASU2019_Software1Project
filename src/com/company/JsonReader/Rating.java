package com.company.JsonReader;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    // region Variables
    @SerializedName("Source")
    @Expose
    private String source;
    @SerializedName("Value")
    @Expose
    private String value;
    // endregion Variables

    // region accessors
    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }
    // endregion accessors

    // region mutators
    public void setSource(String source) {
        this.source = source;
    }

    public void setValue(String value) {
        this.value = value;
    }
    // endregion mutators
}



