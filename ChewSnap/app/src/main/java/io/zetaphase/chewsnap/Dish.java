package io.zetaphase.chewsnap;

/**
 * Created by Dave Ho on 3/8/2017.
 */

public class Dish {
    //private bitmap image;
    private String title;
    private String description;
    private int rating;

    public Dish(String title, String description, int rating){
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public int getRating(){
        return rating;
    }
}
