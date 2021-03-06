package io.zetaphase.chewsnap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class MealListFragment extends Fragment {

    private ListView mealListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity superActivity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.meal_list_fragment, container , false);
        mealListView = (ListView) view.findViewById(R.id.mealList);
        mealListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), ViewMealPopup.class);
                intent.putExtra("CLICKPOSITION", ""+position);
                startActivity(intent);
            }
        });
        mealListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                final CharSequence[] items = { "Delete", "Share", "Cancel" };

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(MainActivity.mealList.get(pos).getTitle().toUpperCase());
                final int position = pos;
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Delete")) {
                            MainActivity.mealList.remove(position);
                            MainActivity.mealAdapter.updateMealList(MainActivity.mealList);
                            MainActivity.mealAdapter.notifyDataSetChanged();
                        }
                        dialog.dismiss();
                    }
                });
                builder.show();
                return true;
            }
        });
        //String[] meals = new String[] {"apple", "steak"};
        //ArrayList<String> mealList = new ArrayList<>();
        //mealList.addAll(Arrays.asList(meals));
        //superActivity.mealList.add(new Meal("Steak", "This Steak is delicious", 5));
        MainActivity.mealAdapter = new MealAdapter(getActivity(), 0, superActivity.mealList);
        mealListView.setAdapter(MainActivity.mealAdapter);
        return view;
    }


}
