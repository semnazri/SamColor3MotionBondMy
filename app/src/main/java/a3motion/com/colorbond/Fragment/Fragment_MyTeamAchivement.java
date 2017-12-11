package a3motion.com.colorbond.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.MyTeamAchivementAdapter;
import a3motion.com.colorbond.Model.TeamAchivement;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/10/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_MyTeamAchivement extends Fragment {
    private View view;
    private List<TeamAchivement> teamAchivements;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private MyTeamAchivementAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_myteam_achivement, container, false);

        teamAchivements = getAchivement();
        rv = (RecyclerView) view.findViewById(R.id.rv_team_achivement);


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
