package io.zetaphase.chewsnap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class MealListFragment extends Fragment {

    private ListView mealListView;
    private ArrayAdapter<String> listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity superActivity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.meal_list_fragment, container , false);
        mealListView = (ListView) view.findViewById(R.id.mealList);
        //String[] meals = new String[] {"apple", "steak"};
        //ArrayList<String> mealList = new ArrayList<>();
        //mealList.addAll(Arrays.asList(meals));
        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.meal_row, superActivity.mealList);
        mealListView.setAdapter(listAdapter);
        return view;
    }



}
