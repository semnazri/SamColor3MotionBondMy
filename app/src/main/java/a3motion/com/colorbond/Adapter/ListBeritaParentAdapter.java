package a3motion.com.colorbond.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by semmy on 2/24/2017.
 */

public class ListBeritaParentAdapter extends FragmentPagerAdapter {
    private List<HashMap<String, Fragment>> fragments;

    public ListBeritaParentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void addFragment(List<HashMap<String, Fragment>> fragment) {
        this.fragments = fragment;
    }


    @Override
    public Fragment getItem(int position) {
        String key = "";

        for (String hashmap : fragments.get(position).keySet()) {
            key = hashmap;
        }

        return fragments.get(position).get(key);

    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String key = "";

        for (String hashmap : fragments.get(position).keySet()) {
            key = hashmap;
        }
        return key;
    }
}
