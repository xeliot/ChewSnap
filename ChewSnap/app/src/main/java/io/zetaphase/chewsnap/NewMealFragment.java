package io.zetaphase.chewsnap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class NewMealFragment extends Fragment{

    View view;
    private ListView dishListView;
    //MainActivity superActivity = (MainActivity) getActivity();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity superActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.new_meal_fragment, container, false);
        Button finishButton = (Button) view.findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (MainActivity.dishList.isEmpty()){
                    Toast.makeText(getActivity(), "Please add some dishes.", Toast.LENGTH_LONG).show();
                }else{
                    addMeal();
                    resetFragment();
                    Toast.makeText(getActivity(), "New Meal has been added!", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button addButton = (Button) view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent popIntent = new Intent(getActivity(), PopDish.class);
                startActivity(popIntent);
            }
        });
        dishListView = (ListView) view.findViewById(R.id.dishList);
        dishListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("CLICKPOSITION", ""+position);
                Intent intent = new Intent(getActivity(), ViewDishPopup.class);
                intent.putExtra("CLICKPOSITION", ""+position);
                startActivity(intent);
            }
        });
        dishListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                final CharSequence[] items = { "Delete", "Cancel" };

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(MainActivity.dishList.get(pos).getTitle().toUpperCase());
                final int position = pos;
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Delete")) {
                            MainActivity.dishList.remove(position);
                            MainActivity.dishAdapter.updateDishList(MainActivity.dishList);
                            MainActivity.dishAdapter.notifyDataSetChanged();
                        }
                        dialog.dismiss();
                    }
                });
                builder.show();
                return true;
            }
        });
        MainActivity.dishAdapter = new DishAdapter(getActivity(), 0, superActivity.dishList);
        dishListView.setAdapter(MainActivity.dishAdapter);
        return view;
    }

    public void addMeal(){

        TextView title = (TextView) getActivity().findViewById(R.id.mealName);
        TextView description = (TextView) getActivity().findViewById(R.id.description);
        TextView location = (TextView) getActivity().findViewById(R.id.restaurantName);

        Meal meal = new Meal(title.getText().toString(), description.getText().toString(), location.getText().toString());
        meal.setDishes(MainActivity.dishList);
        double averageRating = 0;
        for(Dish dish : MainActivity.dishList){
            averageRating += dish.getRating();
        }
        averageRating = (averageRating*1.0)/MainActivity.dishList.size();
        meal.setNumStars((int) averageRating);
        int randInt = (int)(Math.random()*MainActivity.dishList.size());
        meal.setBitmap(MainActivity.dishList.get(randInt).getBitmap());
        MainActivity superActivity = (MainActivity) getActivity();
        superActivity.mealList.add(meal);
        MainActivity.mealAdapter.updateMealList(superActivity.mealList);
        MainActivity.mealAdapter.notifyDataSetChanged();
        Log.d("addMEAL", ""+superActivity.mealList.get(0).getTitle());

    }

    public void resetFragment(){
        MainActivity.dishList = new ArrayList<Dish>();
        MainActivity superActivity = (MainActivity) getActivity();
        MainActivity.dishAdapter = new DishAdapter(getActivity(), 0, superActivity.dishList);
        dishListView.setAdapter(MainActivity.dishAdapter);
        TextView title = (TextView) getActivity().findViewById(R.id.mealName);
        TextView description = (TextView) getActivity().findViewById(R.id.description);
        TextView restaurant = (TextView) getActivity().findViewById(R.id.restaurantName);
        title.setText("");
        description.setText("");
        restaurant.setText("");

    }

}
