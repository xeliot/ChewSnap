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

public class InboxFragment extends Fragment {

    private ListView inboxListView;

    @Nullable
    @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inbox_fragment, container, false);
        MainActivity superActivity = (MainActivity) getActivity();
        inboxListView = (ListView) view.findViewById(R.id.inboxList);
        MealAdapter listAdapter = new MealAdapter(getActivity(), 0, superActivity.mealList);
        inboxListView.setAdapter(listAdapter);
        return view;
    }
}
