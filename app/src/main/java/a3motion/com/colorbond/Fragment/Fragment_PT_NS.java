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
import android.widget.TextView;

import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_PT_NS extends Fragment {

    private View view;
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    private SharedPreferences prefsprivate;
    private ImageView img_nav;
    private TextView txt_title,txt_about,txt_about2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pt_ns,container,false);
        img_nav = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_about = view.findViewById(R.id.txt_about);
        txt_about2 = view.findViewById(R.id.txt_about2);
        txt_title.setText("PT NS BLUESCOPE INDONESIA");

        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("PT NS BLUESCOPE INDONESIA");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("PT NS BLUESCOPE INDONESIA");
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

        txt_about.setText(Html.fromHtml("PT NS BlueScope Indonesia is a joint venture company between BlueScope and Nippon Steel & Sumitomo Metal Corporation (NSSMC). NS BlueScope Indonesia was formed in 1994. The business commissioned its flat steel metallic coating and painting (55% Zn AL) facility in Cilegon in 1995. The company is the pioneer of local manufacturers of zinc/aluminium metallic coated steel in Indonesia with a major manufacturing plant in Cilegon."));
        txt_about2.setText(Html.fromHtml("For over 50 years, the leadership of Colorbond has stood untested. The pre-painted steel is the premier choice for commercial, industrial, public and residential infrastructure across South East Asia and sets the benchmark of excellence in today’s global steel industry <br><br>PT NS BLUESCOPE INDONESIA<br>BRI II Building 9th Floor, Suite 902, RT.14/RW.1, Bend. Hilir,<br>Tanah Abang, Kota Jakarta Pusat,<br>Daerah Khusus Ibukota Jakarta 10210"));
        return view;
    }
}
