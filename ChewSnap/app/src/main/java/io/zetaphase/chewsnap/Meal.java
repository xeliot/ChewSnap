package io.zetaphase.chewsnap;

/**
 * Created by Dave Ho on 3/7/2017.
 */

public class Meal {
    private String title;
    private String description;
    //private Bitmap appetizer;
    //private Bitmap mainCourse;
    //private Bitmap dessert;

    public Meal(String title, String description){
        this.title = title;
        this.description = description;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

}
