package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robohorse.pagerbullet.PagerBullet;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.InspirasiPagerAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Inspirasi;
import a3motion.com.colorbond.Model.Sliderpoto;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_Inspirasi extends Fragment {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    View view;
    List<Sliderpoto> slide;
    RecyclerView recyclerView;
    InspirasiPagerAdapter adapter;
    String userid;
    private SharedPreferences prefsprivate;
    private PagerBullet pager;
    private TextView txt_title;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_inspirasi, container, false);
        pager = view.findViewById(R.id.photos_viewpager);
        pager.setIndicatorTintColorScheme(Color.WHITE, Color.GRAY);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_title.setText("INSPIRATION");

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("COLORBOND INSPIRATION");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("COLORBOND INSPIRATION");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
        }

        slide = getSlide();
        adapter = new InspirasiPagerAdapter(getActivity(), slide);
        pager.setAdapter(adapter);
        return view;
    }

    private List<Sliderpoto> getSlide() {
        List<Sliderpoto> ins = new ArrayList<>();

        ins.add(new Sliderpoto(1, "Lorem Ipsum", "Lorem Ipsum"));
        ins.add(new Sliderpoto(1, "Lorem Ipsum", "Lorem Ipsum"));
        ins.add(new Sliderpoto(1, "Lorem Ipsum", "Lorem Ipsum"));
        ins.add(new Sliderpoto(1, "Lorem Ipsum", "Lorem Ipsum"));
        ins.add(new Sliderpoto(1, "Lorem Ipsum", "Lorem Ipsum"));

        return ins;

    }


    private List<Inspirasi> getListInspirasi() {
        List<Inspirasi> ins = new ArrayList<>();

        ins.add(new Inspirasi("Lorem Ipsum", "Syafira Muthiary", "Photographer"));
        ins.add(new Inspirasi("Lorem Ipsum", "Nindya Iswari Hayuningrum", "Interpreneur"));
        ins.add(new Inspirasi("Lorem Ipsum", "Nevertari Vivi", "Queen Of Arabasta"));
        ins.add(new Inspirasi("Lorem Ipsum", "Nami", "Navigator"));
        ins.add(new Inspirasi("Lorem Ipsum", "Nico Robin", "Archeolog"));
        ins.add(new Inspirasi("Lorem Ipsum", "Erza Scarlet", "Armor Fairy Wizard"));
        ins.add(new Inspirasi("Lorem Ipsum", "Lucy Heartfilia", "Stars Fairy Wizard"));
        ins.add(new Inspirasi("Lorem Ipsum", "Juvia", "Water Fairy Wizard"));

        return ins;
    }
}
