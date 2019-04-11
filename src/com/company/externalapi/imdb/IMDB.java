package com.company.externalapi.imdb;

import com.company.externalapi.imdb.response.IMDBResponse;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class IMDB {

    // region Constants
    private static final String URL = "http://www.omdbapi.com";
    private static final String CHARSET = java.nio.charset.StandardCharsets.UTF_8.name();
    // endregion Constants

    // region Variables
    private static String apiFormat;
    private static boolean initialized = false;
    // endregion Variables

    // region Constructor
    private IMDB() {
    }
    // endregion Constructor

    public static void init(){
        Dotenv dotenv = Dotenv.load();

        apiFormat = "apikey=" + dotenv.get("omdbapi_APIKey") + "&i=";

        initialized = true;
    }

    private static String getMovieDetailsString(String movieID) {
        if(initialized) {
            try {
                String query = apiFormat + URLEncoder.encode(movieID, CHARSET);

                URLConnection connection = new URL(URL + "?" + query).openConnection();

                InputStream response = connection.getInputStream();

                StringBuilder responseString = new StringBuilder();

                Scanner sc = new Scanner(response);
                while (sc.hasNext()) {
                    responseString.append(sc.nextLine());
                }

                sc.close();

                return responseString.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else{
            return null;
        }
    }

    public static IMDBResponse getMovieDetails(String movieID) {
        String jsonString = getMovieDetailsString(movieID);

        //Call to string to IMDBResponse
//        IMDBResponse imdbResponse = ;

        //todo implement
        throw new UnsupportedOperationException();

//        return imdbResponse;
    }

    public static void main(String[] args) {
        //for Testing purposes
        init();
        System.out.println(getMovieDetails("tt3896198"));
    }
}
