package a3motion.com.colorbond.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.FollowersAdapter;
import a3motion.com.colorbond.Adapter.LatestProjectAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Followers;
import a3motion.com.colorbond.Model.LatestProject_;
import a3motion.com.colorbond.Model.LatestProjectfront;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/24/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentHome extends Fragment {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid, nama,points;
    private View view;
    private List<LatestProjectfront> latestProjects;
    private List<Followers> followers;
    private RecyclerView rv;
    private TextView txt_name,txt_point;
    private LinearLayoutManager lm, lm_followers;
    private LatestProjectAdapter adapter;
    private FollowersAdapter followersAdapter;
    private ImageView img_top, img_bonpart_program, home_4rd_image;
    private Button btn_join, btn_detail_info;
    private LinearLayout ll_project_history, ll_point;
    private MaterialDialog mDialog;
    private SharedPreferences prefsprivate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        latestProjects = getProjects();
        rv = view.findViewById(R.id.home_last_project);
        img_top = view.findViewById(R.id.home_top_image);
        img_bonpart_program = view.findViewById(R.id.bonpart_program);
        btn_join = view.findViewById(R.id.join);
        ll_project_history = view.findViewById(R.id.linear_project_history);
        btn_detail_info = view.findViewById(R.id.btn_detail_info);
        ll_point = view.findViewById(R.id.layout_point);
        home_4rd_image = view.findViewById(R.id.home_4rd_image);
        txt_name = view.findViewById(R.id.home_name);
        txt_point = view.findViewById(R.id.txt_point);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        nama = prefsprivate.getString(BlueScoopPreferences.nama, "username");
        points = prefsprivate.getString(BlueScoopPreferences.poin,"10000");

        txt_name.setText("Hello ! " + nama);
        txt_point.setText(points);
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.VISIBLE);
            MainActivity.img_title.setVisibility(View.VISIBLE);
            MainActivity.title_page.setVisibility(View.GONE);

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.VISIBLE);
            MainActivity_owner.img_title.setVisibility(View.VISIBLE);
            MainActivity_owner.title_page.setVisibility(View.GONE);

        }

        img_top.setFocusable(true);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new LatestProjectAdapter(getActivity(), latestProjects);
        rv.setAdapter(adapter);

        img_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogjoin();
            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogjoin();

            }
        });
        img_bonpart_program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogProgram();
            }
        });
        ll_project_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.container_body, new Project_HistoryParent(), "pembayaran").addToBackStack("pembayaran");
//                fragmentTransaction.commit();
            }
        });

        ll_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.container_body, new Point_Parent(), "pembayaran").addToBackStack("pembayaran");
//                fragmentTransaction.commit();
            }
        });

        btn_detail_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.container_body, new Fragment_bondPartMerchant_benefit(), "pembayaran").addToBackStack("pembayaran");
//                fragmentTransaction.commit();
            }
        });

        home_4rd_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.container_body, new Fragment_colorbond_insipiration(), "pembayaran").addToBackStack("pembayaran");
//                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void showDialogProgram() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_bondpart_program);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView tv_program_desc = (TextView) dialog.findViewById(R.id.txt_bond_part_program);
        tv_program_desc.setText(getString(R.string.lorem));
        dialog.setCancelable(true);
        dialog.show();
    }

    private void showDialogjoin() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_join);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
//        dialog.getWindow().setLayout((8 * width) / 9, (5 * height) / 5);

        Button tv_join_disjoin = dialog.findViewById(R.id.txt_join_disjoin);
        LinearLayout ll_folowers = (LinearLayout) dialog.findViewById(R.id.ll_folowers);
        tv_join_disjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ll_folowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_listFolowers();
            }
        });

        dialog.show();

    }

    private void showDialog_listFolowers() {
        final Dialog dialog_followers = new Dialog(getActivity());
        dialog_followers.setContentView(R.layout.layout_followers);
        dialog_followers.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        followers = getFollowers();
        RecyclerView rv_followers = dialog_followers.findViewById(R.id.rv_followers);
        final Button btn_back = dialog_followers.findViewById(R.id.btn_back);

        rv_followers.setHasFixedSize(true);
        lm_followers = new LinearLayoutManager(getActivity());
        rv_followers.setLayoutManager(lm_followers);
        followersAdapter = new FollowersAdapter(getActivity(), followers);
        rv_followers.setAdapter(followersAdapter);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_followers.dismiss();
            }
        });

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog_followers.show();
//        dialog_followers.getWindow().setLayout((6 * width)/7, (6 * height)/7);

    }

    private List<LatestProjectfront> getProjects() {
        List<LatestProjectfront> lp = new ArrayList<>();
        lp.add(new LatestProjectfront("Project 1", getString(R.string.Lorem_Pendek)));
        lp.add(new LatestProjectfront("Project 2", getString(R.string.Lorem_Pendek)));
        lp.add(new LatestProjectfront("Project 3", getString(R.string.Lorem_Pendek)));
        lp.add(new LatestProjectfront("Project 4", getString(R.string.Lorem_Pendek)));


        return lp;
    }

    private List<Followers> getFollowers() {
        List<Followers> flw = new ArrayList<>();
        flw.add(new Followers("Syafira Muthiary", "PhotoGrapger", "Freelancer"));
        flw.add(new Followers("Nindya Iswari Hayuningrum", "Head Marketing", "PT. GrossFoodIndonesia"));
        flw.add(new Followers("Nevertari Vivi", "Queen Of Arabasta", "PT. Arabasta Companny"));
        flw.add(new Followers("Nico Robin", "Archeolog", "PT. StrawHat Pirate"));
        flw.add(new Followers("Nami", "Navigator", "PT. StrawHat Pirate"));

        return flw;
    }
}
