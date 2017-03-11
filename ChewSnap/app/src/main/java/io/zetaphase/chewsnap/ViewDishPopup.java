package io.zetaphase.chewsnap;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Dave Ho on 3/10/2017.
 */

public class ViewDishPopup extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_dish_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.8));

        
    }
}
