package com.sortable.Utils;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/**
 * Created by mahmoud on 27/10/16.
 */
public class FileWriter {

    public static void write(String fileName, ArrayList<String> contents) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(fileName,"UTF-8");
        for(int i = 0; i < contents.size(); i++){
            writer.println(contents.get(i));
        }
        writer.close();
    }
}