package com.sortable;

import com.sortable.Exceptions.WrongParametersException;
import com.sortable.Utils.FileWriter;
import com.sortable.Utils.ListingsMapper;
import com.sortable.Utils.Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws WrongParametersException, IOException {
	    if(args.length!=3)
        {
            throw new WrongParametersException();
        }
        ArrayList<String> products = Reader.read(args[0]);
        ArrayList<String> listings = Reader.read(args[1]);
        ListingsMapper mapper = new ListingsMapper(products,listings);
        mapper.mapListings();
        FileWriter.write(args[2], mapper.printResults());
    }
}
