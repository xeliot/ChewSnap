package io.zetaphase.chewsnap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    ViewPager viewpager;
    Meal currentMeal;
    ArrayList<Meal> mealList = new ArrayList<Meal>();
    ArrayList<Meal> inboxList = new ArrayList<Meal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter padapter = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(padapter);
    }

}
