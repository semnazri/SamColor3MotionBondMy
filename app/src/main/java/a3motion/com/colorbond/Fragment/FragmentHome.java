package a3motion.com.colorbond.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import a3motion.com.colorbond.Adapter.LatestProjectAdapter;
import a3motion.com.colorbond.Model.LatestProject;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/24/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentHome extends Fragment {

    private View view;
    private List<LatestProject> latestProjects;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private LatestProjectAdapter adapter;
    private ImageView img_top,img_bonpart_program;
    private Button btn_join,btn_detail_info;
    private LinearLayout ll_project_history;
    private MaterialDialog mDialog;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        latestProjects = getProjects();
        rv = (RecyclerView) view.findViewById(R.id.home_last_project);
        img_top = (ImageView) view.findViewById(R.id.home_top_image);
        img_bonpart_program  = (ImageView) view.findViewById(R.id.bonpart_program);
        btn_join = (Button) view.findViewById(R.id.join);
        ll_project_history = (LinearLayout) view.findViewById(R.id.linear_project_history);
        btn_detail_info = (Button) view.findViewById(R.id.btn_detail_info);


        img_top.setFocusable(true);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new LatestProjectAdapter(getActivity(),latestProjects);
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

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container_body, new Project_HistoryParent(), "pembayaran").addToBackStack("pembayaran");
                fragmentTransaction.commit();
            }
        });
        btn_detail_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
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

        TextView tv_join_disjoin = (TextView) dialog.findViewById(R.id.txt_join_disjoin);
        tv_join_disjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private List<LatestProject> getProjects() {
        List<LatestProject> lp = new ArrayList<>();
        lp.add(new LatestProject("Project 1", getString(R.string.lorem)));
        lp.add(new LatestProject("Project 2", getString(R.string.lorem)));
        lp.add(new LatestProject("Project 3", getString(R.string.lorem)));
        lp.add(new LatestProject("Project 4", getString(R.string.lorem)));


        return lp;
    }
}
