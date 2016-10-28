package com.sortable.Models;

import java.util.ArrayList;

/**
 * Created by mahmoud on 27/10/16.
 */
public class Result {
    private String product_name;
    private ArrayList<Listing> listings;

    public Result(String productName){
        this.product_name = productName;
        listings = new ArrayList<Listing>();
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public ArrayList<Listing> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
    }
}
