package io.zetaphase.chewsnap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dave Ho on 3/9/2017.
 */

public class DishAdapter extends ArrayAdapter<Dish>{
    private Context context;
    private List<Dish> dishList;

    public DishAdapter(Context context, int resource, ArrayList<Dish> dishes){
        super(context, resource, dishes);
        this.context = context;
        this.dishList = dishes;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Dish dish = dishList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dish_row, null);

        TextView title = (TextView) view.findViewById(R.id.dishRowName);
        TextView description = (TextView) view.findViewById(R.id.dishRowDescription);
        TextView location = (TextView) view.findViewById(R.id.dishRowLocation);
        ImageView image = (ImageView) view.findViewById(R.id.dishRowImage);
        RatingBar rating = (RatingBar) view.findViewById(R.id.dishRowRating);

        title.setText(dish.getTitle());
        description.setText(dish.getDescription());
        location.setText();

        return view;
    }

    public List<Dish> getDishList(){
        return dishList;
    }

    public void updateDishList(ArrayList<Dish> dishes){
        dishList = dishes;
    }

}
