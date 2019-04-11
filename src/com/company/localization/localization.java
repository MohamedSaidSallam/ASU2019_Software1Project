package com.company.localization;

import java.util.HashMap;

public class localization {

    // region Constants
    private static final String KEY_NOT_FOUND = "KEY_NOT_FOUND";
    // endregion Constants

    // region Variables
    private static HashMap<String, String> localizedText = new HashMap<>();
    // endregion Variables

    // region constructor
    private localization(){

    }
    // endregion constructor

    public static void init(){
        //todo read json
    }

    public static String getText(String key){
        return localizedText.getOrDefault(key, KEY_NOT_FOUND);
    }
}
