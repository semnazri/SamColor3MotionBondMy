package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.BuildingCatAdapter;
import a3motion.com.colorbond.Adapter.MaterialAdapter;
import a3motion.com.colorbond.Adapter.SizeMaterialAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Building_cats;
import a3motion.com.colorbond.Model.Material;
import a3motion.com.colorbond.Model.Size_material;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 31/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_Submit extends Fragment {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid,point;
    private View view;
    private SharedPreferences prefsprivate;
    private TextView txt_title, txt_m2_sup,txt_point;
    private ImageView img_tolbar;
    private List<Building_cats> building_cats;
    private List<Material> materials;
    private List<Size_material> Size_material;
    private Spinner spinner_building_catgory, spinner_material_1, spinner_material_2;
    private BuildingCatAdapter adapter;
    private MaterialAdapter adapterM;
    private SizeMaterialAdapter adapterS;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_submit, container, false);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        point = prefsprivate.getString(BlueScoopPreferences.poin, "1");
        img_tolbar = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_m2_sup = view.findViewById(R.id.txt_m2_sup);
        txt_point = view.findViewById(R.id.point);
        txt_title.setText("SUBMIT PROJECT");

        txt_m2_sup.setText(Html.fromHtml(getResources().getString(R.string.sup)));
        spinner_building_catgory = view.findViewById(R.id.spinner_building_catgory);
        spinner_material_1 = view.findViewById(R.id.spinner_material_1);
        spinner_material_2 = view.findViewById(R.id.spinner_material_2);

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("SUBMIT PROJECT");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
            img_tolbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (MainActivity.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity.mDrawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            });

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("SUBMIT PROJECT");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
            img_tolbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (MainActivity_owner.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity_owner.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity_owner.mDrawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            });
        }


        txt_point.setText(point);
        building_cats = getTipe();
        materials = getMaterial();
        Size_material = getSize();

        adapter = new BuildingCatAdapter(getActivity(), building_cats);
        spinner_building_catgory.setAdapter(adapter);

        adapterM = new MaterialAdapter(getActivity(), materials);
        spinner_material_1.setAdapter(adapterM);

        adapterS = new SizeMaterialAdapter(getActivity(), Size_material);
        spinner_material_2.setAdapter(adapterS);

        return view;
    }

    private List<Building_cats> getTipe() {
        List<Building_cats> tp = new ArrayList<>();
        tp.add(new Building_cats("Industrial", "0"));
        tp.add(new Building_cats("Comercial", "1"));
        return tp;
    }

    private List<Material> getMaterial() {
        List<Material> tp = new ArrayList<>();
        tp.add(new Material("XPD", "0"));
        tp.add(new Material("XRW", "1"));
        tp.add(new Material("XAL", "2"));
        tp.add(new Material("Ultimate", "3"));
        return tp;
    }

    private List<Size_material> getSize() {
        List<Size_material> tp = new ArrayList<>();
        tp.add(new Size_material("0.30 BMT", "0"));
        tp.add(new Size_material("0.35 BMT", "1"));
        tp.add(new Size_material("0.40 BMT", "2"));
        tp.add(new Size_material("0.45 BMT", "3"));
        tp.add(new Size_material("0.50 BMT", "4"));
        tp.add(new Size_material("0.55 BMT", "5"));
        tp.add(new Size_material("0.60 BMT", "6"));
        tp.add(new Size_material("0.65 BMT", "7"));
        tp.add(new Size_material("0.70 BMT", "8"));

        return tp;
    }
}
