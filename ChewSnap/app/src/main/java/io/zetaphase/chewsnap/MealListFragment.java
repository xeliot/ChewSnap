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

    ListView mealListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meal_list_fragment, container , false);
        mealListView = (ListView) getView().findViewById(R.id.mealList);
        return view;
    }


}
