package io.zetaphase.chewsnap;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dave Ho on 3/8/2017.
 */
public class PopDish extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_dish_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.8));

        Button finishDishButton = (Button) findViewById(R.id.finishButton);
        finishDishButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //change meal
            }
        });
    }
}
