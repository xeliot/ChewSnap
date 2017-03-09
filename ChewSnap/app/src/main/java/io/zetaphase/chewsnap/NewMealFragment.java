package io.zetaphase.chewsnap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class NewMealFragment extends Fragment{

    View view;
    //MainActivity superActivity = (MainActivity) getActivity();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity superActivity = (MainActivity) getActivity();
        superActivity.currentMeal = new Meal("", "", -1);
        view = inflater.inflate(R.layout.new_meal_fragment, container, false);
        Button finishButton = (Button) view.findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                addMeal();
            }
        });
        Button addButton = (Button) view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent popIntent = new Intent(getActivity(), PopDish.class);
                //popIntent.putExtra("context", );
                startActivity(popIntent);
            }
        });
        return view;
    }

    public void addMeal(){
        /*
        TextView title = (TextView) getActivity().findViewById(R.id.mealName);
        TextView description = (TextView) getActivity().findViewById(R.id.description);
        RatingBar rating = (RatingBar) getActivity().findViewById(R.id.appetizerRating);

        Meal meal = new Meal(title.getText().toString(), description.getText().toString(), (int) rating.getRating());
        MainActivity superActivity = (MainActivity) getActivity();
        superActivity.mealList.add(meal);
        Log.d("addMEAL", ""+getFragmentManager().findFragmentByTag("MealListFragment"));
        */
    }

}
