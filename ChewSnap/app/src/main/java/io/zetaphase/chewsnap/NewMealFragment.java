package io.zetaphase.chewsnap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class NewMealFragment extends Fragment implements View.OnClickListener{

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.new_meal_fragment, container, false);
        Button button = (Button) view.findViewById(R.id.addButton);
        button.setOnClickListener(this);
        return view;
    }

    public void addMeal(){
        TextView title = (TextView) getActivity().findViewById(R.id.mealName);
        TextView description = (TextView) getActivity().findViewById(R.id.description);
        RatingBar rating = (RatingBar) getActivity().findViewById(R.id.appetizerRating);

        Meal meal = new Meal(title.getText().toString(), description.getText().toString(), (int) rating.getRating());
        MainActivity superActivity = (MainActivity) getActivity();
        superActivity.mealList.add(meal);
        Log.d("addMEAL", ""+getFragmentManager().findFragmentByTag("MealListFragment"));
    }

    @Override
    public void onClick(View view) {
        addMeal();
    }
}
