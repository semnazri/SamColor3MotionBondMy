package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_colorbond_insipiration extends Fragment {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    private View view;
    private SharedPreferences prefsprivate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_colorbond_inspiration,container,false);

        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");

        if (userid.equals("1")) {

            MainActivity.title_page.setText("COLORBOND INSPIRATION");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.title_page.setText("COLORBOND INSPIRATION");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
