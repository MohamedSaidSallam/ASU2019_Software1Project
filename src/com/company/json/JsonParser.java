package com.company.json;

import com.company.externalapi.imdb.response.IMDBResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

    // region Constants
    private static final String FOLDER_JSON = "src/resources/json/";
    private static final String FOLDER_JSON_MOVIES = FOLDER_JSON + "movies/";
    // endregion Constants

    // region Variables
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().serializeNulls().create();
    // endregion Variables

    // region Constructor
    private JsonParser() {
    }
    // endregion Constructor

    public static void writeMovie(MovieInfoJson movieInfoJson) {
        String json = gson.toJson(movieInfoJson);

        try {
            Files.write(Paths.get(FOLDER_JSON_MOVIES), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MovieInfoJson readMovie(String MovieID) {
        String fileData = null;
        try {
            fileData = new String(Files.readAllBytes(Paths.get(FOLDER_JSON_MOVIES + MovieID)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gson.fromJson(fileData, MovieInfoJson.class);
    }

    public static IMDBResponse imdbResponseFromString(String data){
        return gson.fromJson(data, IMDBResponse.class);
    }

    public static void main(String[] args) {
        //for Testing purposes
        System.out.println(readMovie("tt3896198.json"));
    }
}
