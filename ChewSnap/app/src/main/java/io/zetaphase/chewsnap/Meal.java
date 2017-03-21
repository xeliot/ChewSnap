package io.zetaphase.chewsnap;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Dave Ho on 3/7/2017.
 */

public class Meal {
    private String title;
    private String description;
    private String location;
    private int numStars;
    private ArrayList<Dish> dishes;
    private Bitmap image;

    public Meal(String title, String description, String location){
        this.title = title;
        this.description = description;
        this.numStars = 0;
        this.location = location;
        dishes = new ArrayList<Dish>();
    }

    public void setLocation(String location) {this.location = location;}

    public String getLocation() {return this.location;}

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

    public void setNumStars(int numStars){
        this.numStars = numStars;
    }

    public void setDishes(ArrayList<Dish> dishes){
        this.dishes = dishes;
    }

    public void addDish(Dish dish){
        dishes.add(dish);
    }

    public void removeDish(Dish dish){
        dishes.remove(dish);
    }

    public ArrayList<Dish> getDishes(){
        return dishes;
    }

    public void setBitmap(Bitmap image){
        this.image = image;
    }

    public Bitmap getBitmap(){
        return this.image;
    }
}
