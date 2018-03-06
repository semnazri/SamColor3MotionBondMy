package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
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
 * mr.shanky08@gmail.com on 18/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_account extends Fragment {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid,fullname,company,point;
    FragmentManager fragmentManager;
    private View view;
    private SharedPreferences prefsprivate;
    private ImageView img_nav;
    private TextView txt_title, txt_edt_profile, txt_chg_pass,person_name,person_company,txt_point,txt_redem;
    private FragmentTransaction ft;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);
        img_nav = view.findViewById(R.id.img_tolbar);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);

        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        fullname = prefsprivate.getString(BlueScoopPreferences.nama, "1");
        company = prefsprivate.getString(BlueScoopPreferences.company, "1");
        point = prefsprivate.getString(BlueScoopPreferences.poin, "1");

        txt_title = view.findViewById(R.id.txt_title_page);
        txt_edt_profile = view.findViewById(R.id.edt_profile);
        txt_chg_pass = view.findViewById(R.id.chg_password);
        person_name = view.findViewById(R.id.person_name);
        person_company = view.findViewById(R.id.person_company);
        txt_point = view.findViewById(R.id.txt_point);
        txt_redem = view.findViewById(R.id.txt_redem_point);

        txt_title.setText("MY ACCOUNT");
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("MY ACCOUNT");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("MY ACCOUNT");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
        }

        txt_edt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container_body, new Fragment_Edit_profile(), "home").addToBackStack("menu");
                ft.commit();
            }
        });

        txt_chg_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container_body, new Fragment_Change_Password(), "home").addToBackStack("menu");
                ft.commit();
            }
        });
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

        person_name.setText(fullname);
        person_company.setText(company);
        txt_point.setText(point);
        txt_redem.setText(point);



        return view;
    }


}
