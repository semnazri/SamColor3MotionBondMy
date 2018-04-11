package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import a3motion.com.colorbond.Adapter.ExpandableNewAdapter;
import a3motion.com.colorbond.Adapter.VariantAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.VariantColor;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 26/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_VariantColor extends Fragment {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private View view;
    private SharedPreferences prefsprivate;
    private ImageView img_nav;
    private TextView txt_title;
    private ExpandableListView elv;
    //    private ArrayList<VariantColor> variantColorArrayList;
    private VariantAdapter adapter;
    private ExpandableNewAdapter newAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_variant, container, false);
        img_nav = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);

        txt_title.setText("VARIANT COLORBOND");

        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("VARIANT COLORBOND");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("VARIANT COLORBOND");
            MainActivity_owner.img_title.setVisibility(View.VISIBLE);
            MainActivity_owner.title_page.setVisibility(View.GONE);
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
        elv = view.findViewById(R.id.eListview);
//        variantColorArrayList = getData();
//        final ArrayList<VariantColor> variantColorArrayList = getData();
//
//        adapter = new VariantAdapter(getActivity(), variantColorArrayList);
//        elv.setAdapter(adapter);

        getnewData();

        newAdapter = new ExpandableNewAdapter(getActivity(), listDataHeader, listDataChild);
        elv.setAdapter(newAdapter);

        return view;
    }

    private void getnewData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        // Adding child data
        listDataHeader.add("xpd");
        listDataHeader.add("xrw");
        listDataHeader.add("ultra");
        listDataHeader.add("xal");
        listDataHeader.add("m");

        // Adding child data
        List<String> xpd = new ArrayList<String>();
        xpd.add(getResources().getString(R.string.xpd));


        List<String> xrw = new ArrayList<String>();
        xrw.add(getResources().getString(R.string.xrw));


        List<String> ultra = new ArrayList<String>();
        ultra.add(getResources().getString(R.string.ultra));

        List<String> xal = new ArrayList<String>();
        xal.add(getResources().getString(R.string.xal));

        List<String> m = new ArrayList<String>();
        m.add(getResources().getString(R.string.m));


        listDataChild.put(listDataHeader.get(0), xpd); // Header, Child data
        listDataChild.put(listDataHeader.get(1), xrw);
        listDataChild.put(listDataHeader.get(2), ultra);
        listDataChild.put(listDataHeader.get(3), xal);
        listDataChild.put(listDataHeader.get(4), m);
    }


    private ArrayList<VariantColor> getData() {
        VariantColor vc1 = new VariantColor("xpd");
        vc1.text.add(getResources().getString(R.string.xpd));

        VariantColor vc2 = new VariantColor("xrw");
        vc2.text.add(getResources().getString(R.string.xrw));

        VariantColor vc3 = new VariantColor("ultra");
        vc3.text.add(getResources().getString(R.string.ultra));

        VariantColor vc4 = new VariantColor("xal");
        vc4.text.add(getResources().getString(R.string.xal));

        VariantColor vc5 = new VariantColor("m");
        vc5.text.add(getResources().getString(R.string.m));

        ArrayList<VariantColor> variantColors = new ArrayList<VariantColor>();
        variantColors.add(vc1);
        variantColors.add(vc2);
        variantColors.add(vc3);
        variantColors.add(vc4);
        variantColors.add(vc5);

        return variantColors;
    }

}
