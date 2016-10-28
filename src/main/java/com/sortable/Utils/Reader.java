package com.sortable.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mahmoud on 27/10/16.
 */
public class Reader {

    public static ArrayList<String> read(String fileName) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null)
        {
           lines.add(line);
        }
        reader.close();
        return lines;
    }
}
