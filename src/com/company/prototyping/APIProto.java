package com.company.prototyping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class APIProto {

    // region Static
    private APIProto() {

    }
    // endregion Static

    public static String getAPIData() {
        String fileData = null;
        try {
            fileData = new String(Files.readAllBytes(Paths.get("src/resources/json/APIData.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }

    public static void main(String[] args) {
        //for Testing purposes

        System.out.println(getAPIData());
    }
}
