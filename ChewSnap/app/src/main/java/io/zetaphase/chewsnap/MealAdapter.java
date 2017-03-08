package io.zetaphase.chewsnap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dave Ho on 3/7/2017.
 */

public class MealAdapter extends ArrayAdapter {
    private static class ViewHolder {
        private TextView itemView;
    }

    public MealAdapter(Context context, int textViewResourceId, ArrayList<Meal> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.meal_list_fragment, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.ItemView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MyClass item = getItem(position);
        if (item!= null) {
            // My layout has only one TextView
            // do whatever you want with your string and long
            viewHolder.itemView.setText(String.format("%s %d", item.reason, item.long_val));
        }

        return convertView;
    }
}
