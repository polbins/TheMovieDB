package com.polbins.themoviedb.app.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by polbins on 25/02/2017.
 */

public class JsonTestUtil {
    private static ObjectMapper mObjectMapper;

    private static ObjectMapper getObjectMapper() {
        if (mObjectMapper == null) {
            mObjectMapper = new ObjectMapper();
        }

        return mObjectMapper;
    }

    @JsonIgnore
    public static <M> M fromString(String jsonString, Class<M> modelClass) throws IOException {
        return getObjectMapper().readValue(jsonString, modelClass);
    }

    @JsonIgnore
    public static String fromJson(Object object) throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(object);
    }

    public static <M> M getJsonFromFile(String jsonFileName, Class<M> jsonClass) {
        InputStream inputStream = getInputStreamFromFile(jsonFileName);
        String jsonString = convertStreamToString(inputStream);
        M jsonObject = null;

        try {
            jsonObject = fromString(jsonString, jsonClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private static InputStream getInputStreamFromFile(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }

    private static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
