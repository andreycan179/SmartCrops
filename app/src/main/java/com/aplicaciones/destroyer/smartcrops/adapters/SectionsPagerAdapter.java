package com.aplicaciones.destroyer.smartcrops.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Destroyer on 14/01/2018.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList= new ArrayList<>();
    private final String[] titleList= {"Info","Automatic Task" , "Task"};

    public  void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
