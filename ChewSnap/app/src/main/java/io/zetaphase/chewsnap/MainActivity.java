package io.zetaphase.chewsnap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    ViewPager viewpager;
    public static ArrayList<Meal> mealList = new ArrayList<Meal>();
    public static ArrayList<Dish> dishList = new ArrayList<Dish>();
    ArrayList<Meal> inboxList = new ArrayList<Meal>();
    public static DishAdapter dishAdapter;
    public static MealAdapter mealAdapter;
    public static MealDishAdapter mealDishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter padapter = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(padapter);
    }

}
