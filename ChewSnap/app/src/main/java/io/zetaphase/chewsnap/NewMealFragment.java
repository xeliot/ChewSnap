package io.zetaphase.chewsnap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class NewMealFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_meal_fragment, container, false);
    }

    public void addMeal(){
        TextView title = (TextView) getActivity().findViewById(R.id.nameLabel);
        TextView description
    }
}
