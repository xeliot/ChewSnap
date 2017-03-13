package io.zetaphase.chewsnap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class MealListFragment extends Fragment {

    private ListView mealListView;
    //private MealAdapter<Meal> listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.add(this, "mealListView");
        //ft.commit();
        MainActivity superActivity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.meal_list_fragment, container , false);
        mealListView = (ListView) view.findViewById(R.id.mealList);
        //String[] meals = new String[] {"apple", "steak"};
        //ArrayList<String> mealList = new ArrayList<>();
        //mealList.addAll(Arrays.asList(meals));
        //superActivity.mealList.add(new Meal("Steak", "This Steak is delicious", 5));
        MainActivity.mealAdapter = new MealAdapter(getActivity(), 0, superActivity.mealList);
        mealListView.setAdapter(MainActivity.mealAdapter);
        return view;
    }


}
