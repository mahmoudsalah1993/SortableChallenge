package com.sortable.Utils;

import com.sortable.Models.Listing;
import com.sortable.Models.Product;
import com.sortable.Models.Result;
import jodd.json.JsonSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mahmoud on 27/10/16.
 */
public class ListingsMapper {

    HashMap<String,ArrayList<Product>> manufacturers;
    ArrayList<Listing> listings;
    HashMap<String, Result> results;

    public ListingsMapper(ArrayList<String> productsString, ArrayList<String> listingsString){
        manufacturers = new HashMap<String, ArrayList<Product>>();
        listings = new ArrayList<Listing>();
        results = new HashMap<String, Result>();
        for(String s:productsString){
            Product p = Parser.parse(s,Product.class);
            if(manufacturers.containsKey(p.getManufacturer())){
                manufacturers.get(p.getManufacturer()).add(p);
            }
            else{
                ArrayList<Product> prds = new ArrayList<Product>();
                prds.add(p);
                manufacturers.put(p.getManufacturer(), prds);
            }
        }
        for(String s:listingsString){
            Listing l = Parser.parse(s, Listing.class);
            listings.add(l);
        }
    }

    public void mapListings(){
        for(Listing l:listings){
            for(Map.Entry<String,ArrayList<Product>> entry:manufacturers.entrySet()){
                if(check(l.getManufacturer(),entry.getKey())){
                    for(Product p:entry.getValue()){
                        if(check(l.getTitle(), p.getProduct_name()) || (check(l.getTitle(),p.getFamily()) &&
                                check(l.getTitle(),p.getModel()))){
                            if(results.containsKey(p.getProduct_name())){
                                results.get(p.getProduct_name()).getListings().add(l);
                            }
                            else{
                                Result r = new Result(p.getProduct_name());
                                r.getListings().add(l);
                                results.put(p.getProduct_name(),r);
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }

    }

    private boolean check(String title, String productName) {
        boolean ans = false;
        try{
            ans = title.contains(productName);
        }
        catch (Exception e){

        }
        return ans;
    }

    public ArrayList<String> printResults(){
        ArrayList<String> output = new ArrayList<String>();
        JsonSerializer serializer = new JsonSerializer();
        for(Map.Entry<String,Result> entry:results.entrySet()){
            output.add(serializer.include("listings").serialize(entry.getValue()));
        }
        return output;
    }
}
