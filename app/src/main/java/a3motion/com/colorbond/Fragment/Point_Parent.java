package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.robohorse.pagerbullet.PagerBullet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import a3motion.com.colorbond.Adapter.InspirasiPagerAdapter;
import a3motion.com.colorbond.Adapter.ListBeritaParentAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Sliderpoto;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Point_Parent extends Fragment {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;
    String userid, merchant_type;
    List<Sliderpoto> slide;
    InspirasiPagerAdapter adapter;
    private View view;
    private SharedPreferences prefsprivate;
    private TextView txt_title;
    private PagerBullet pager;
    private ImageView img_nav;
    private String[] tab_name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_parent_point, container, false);
        tabLayout = view.findViewById(R.id.home_tabs);
        viewPager = view.findViewById(R.id.homeviewpager);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_title.setText("REWARD");
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        merchant_type = prefsprivate.getString(BlueScoopPreferences.merchant_type, "0");
        pager = view.findViewById(R.id.photos_viewpager);
        pager.setIndicatorTintColorScheme(Color.WHITE, Color.GRAY);
        img_nav = view.findViewById(R.id.img_tolbar);

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("REWARD");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.title_page.setText("REWARD");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
            MainActivity_owner.mToolbar.setVisibility(View.GONE);

        }


        if (merchant_type.equals("0")) {
            tab_name = getResources().getStringArray(R.array.bondclub_reward);
        } else if (merchant_type.equals("1")) {
            if (userid.equals("0")) {
                tab_name = getResources().getStringArray(R.array.bondpartner_sales);
            } else {
                tab_name = getResources().getStringArray(R.array.bondpartner_owner);
            }
        } else if (merchant_type.equals("2")) {
            tab_name = getResources().getStringArray(R.array.bondcontractor_sales);
        }

        img_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userid.equals("1")) {
                    if (MainActivity.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity.mDrawerLayout.openDrawer(GravityCompat.START);
                    }

                } else {
                    if (MainActivity_owner.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity_owner.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity_owner.mDrawerLayout.openDrawer(GravityCompat.START);
                    }

                }
            }
        });


        slide = getSlide();
        adapter = new InspirasiPagerAdapter(getActivity(), slide);
        pager.setAdapter(adapter);

//        viewPager.setAdapter(new Adapter(getChildFragmentManager()));
        getTab();
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return view;
    }

    private void getTab() {

        List<HashMap<String, Fragment>> halamannya = new ArrayList<HashMap<String, Fragment>>();
        for (int i = 0; i < tab_name.length; i++) {

            Fragment_rebateVoucher fragment = new Fragment_rebateVoucher();
            Bundle bundle = new Bundle();
//            bundle.putString("kanal_id", kanal_id);
            fragment.setArguments(bundle);
            HashMap<String, Fragment> halaman = new HashMap<String, Fragment>();
            halaman.put(tab_name[i], fragment);
            halamannya.add(halaman);
        }

        ListBeritaParentAdapter adapternya = new ListBeritaParentAdapter(getChildFragmentManager());
        adapternya.addFragment(halamannya);
        viewPager.setAdapter(adapternya);


    }

    private List<Sliderpoto> getSlide() {
        List<Sliderpoto> ins = new ArrayList<>();

        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Business Trip", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));


        return ins;

    }

//    static class Adapter extends FragmentPagerAdapter {
//
//        public Adapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    return new Fragment_rebateVoucher();
//                case 1:
//                    return new Fragment_rebateVoucher();
//                case 2:
//                    return new Fragment_rebateVoucher();
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return int_items;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//
//            switch (position) {
//                case 0:
//                    return "Shopping Voucher";
//                case 1:
//                    return "Business Travel";
//                case 2:
//                    return "Business Gathering";
//
//            }
//            return null;
//        }
//    }
}
