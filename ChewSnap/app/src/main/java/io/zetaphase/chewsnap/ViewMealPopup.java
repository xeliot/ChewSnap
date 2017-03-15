package io.zetaphase.chewsnap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Dave Ho on 3/15/2017.
 */

public class ViewMealPopup extends Activity{ //when creating new activity popup, make sure to modify manifest xml

    private ListView mealDishListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_meal);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.8));

        Intent intent = getIntent();
        int clickedPosition = Integer.valueOf(intent.getStringExtra("CLICKPOSITION"));

        Meal meal = MainActivity.mealList.get(clickedPosition);

        TextView title = (TextView) findViewById(R.id.viewMealTitle);
        TextView description = (TextView) findViewById(R.id.viewMealDescription);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.viewMealRating);

        title.setText(meal.getTitle());
        description.setText(meal.getDescription());
        ratingBar.setRating(meal.getNumStars());

        mealDishListView = (ListView) findViewById(R.id.viewMealList);
        MainActivity.dishAdapter = new DishAdapter(this, 0, meal.getDishes());
        mealDishListView.setAdapter(MainActivity.dishAdapter);

    }
}
