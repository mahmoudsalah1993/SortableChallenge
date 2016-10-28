package com.sortable.Utils;

import jodd.json.JsonParser;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by mahmoud on 27/10/16.
 */
public class Parser{

    public static <T>T parse(String jsonString, Class<T> type) {
        JsonParser parser = new JsonParser();
        T obj = parser.parse(jsonString, type);
        return obj;
    }

}
