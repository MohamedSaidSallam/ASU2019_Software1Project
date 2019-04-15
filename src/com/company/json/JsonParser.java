package com.company.json;

import com.company.cinema.Genre;
import com.company.cinema.MPAA;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
import com.company.externalapi.imdb.response.IMDBResponse;
import com.company.prototyping.APIData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    public static void writeMovie(IMDBResponse movieInfoJson) {
        String json = gson.toJson(movieInfoJson);

        try {
            Files.write(Paths.get(FOLDER_JSON_MOVIES + movieInfoJson.getImdbID() + ".json"), json.getBytes());
        } catch (IOException e) {
//            getMovieDetails todo
            e.printStackTrace();
        }
    }

    public static IMDBResponse readIMDBResponse(String MovieID) {
        String fileData = null;
        try {
            fileData = new String(Files.readAllBytes(Paths.get(FOLDER_JSON_MOVIES + MovieID + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gson.fromJson(fileData, IMDBResponse.class);
    }

    public static IMDBResponse imdbResponseFromString(String data){
        return gson.fromJson(data, IMDBResponse.class);
    }

    public static List<APIData> stringToAPIData(String apiDataString){
        //todo wrong place
        Type apiDataType = new TypeToken<List<APIData>>(){}.getType();
        return gson.fromJson(apiDataString, apiDataType);
    }

    public static void main(String[] args) {
        //for Testing purposes

    }

}
