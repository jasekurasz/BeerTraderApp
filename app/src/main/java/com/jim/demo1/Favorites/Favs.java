package com.jim.demo1.Favorites;

/**
 * Created by Jim on 5/11/2015.
 */
public class Favs{
    String fav_name;
    String fav_type;


    public Favs(String fav_name, String fav_type){
        this.fav_name = fav_name;
        this.fav_type = fav_type;

    }

    public String getFav_name() {
        return fav_name;
    }

    public String getFav_type() { return fav_type; }
}
