package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.MyTeamAchivementAdapter;
import a3motion.com.colorbond.Model.TeamAchivement;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/10/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_MyTeamAchivement extends Fragment {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String tokenz, point;
    private View view;
    private List<TeamAchivement> teamAchivements;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private MyTeamAchivementAdapter adapter;
    private SharedPreferences prefsprivate;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;
    private TextView txt_myPoint;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_myteam_achivement, container, false);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        teamAchivements = getAchivement();
        rv = view.findViewById(R.id.rv_team_achivement);
        txt_myPoint = view.findViewById(R.id.mypoint);

        point = prefsprivate.getString(BlueScoopPreferences.poin, "null");

        txt_myPoint.setText(point);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new MyTeamAchivementAdapter(getActivity(), teamAchivements);
        rv.setAdapter(adapter);

        return view;
    }

    private List<TeamAchivement> getAchivement() {

        List<TeamAchivement> lp = new ArrayList<>();
        lp.add(new TeamAchivement("John Smith", "Sales", "200", "1000"));
        lp.add(new TeamAchivement("John Smith", "Sales", "200", "1000"));
        lp.add(new TeamAchivement("John Smith", "Sales", "200", "1000"));
        lp.add(new TeamAchivement("John Smith", "Sales", "200", "1000"));
        lp.add(new TeamAchivement("John Smith", "Sales", "200", "1000"));
        lp.add(new TeamAchivement("John Smith", "Sales", "200", "1000"));

        return lp;
    }
}
