package io.zetaphase.chewsnap;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Dave Ho on 3/6/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0){
        switch(arg0){
            case 0:
                return new MealListFragment();
            case 1:
                return new NewMealFragment();
            case 2:
                return new InboxFragment();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 3;
    }
}
