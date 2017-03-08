package io.zetaphase.chewsnap;

/**
 * Created by Dave Ho on 3/7/2017.
 */

public class Meal {
    private String title;
    private String description;
    private int numStars;
    //private Bitmap appetizer;
    //private Bitmap mainCourse;
    //private Bitmap dessert;

    public Meal(String title, String description, int numStars){
        this.title = title;
        this.description = description;
        this.numStars = numStars;
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

    public int getNumStars(){
        return numStars;
    }

}
