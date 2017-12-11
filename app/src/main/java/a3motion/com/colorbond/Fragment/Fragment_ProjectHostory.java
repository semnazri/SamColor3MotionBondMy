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

import a3motion.com.colorbond.Adapter.ProjectHistoryAdapter;
import a3motion.com.colorbond.Model.LatestProject;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/10/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_ProjectHostory extends Fragment {

    private View view;
    private List<LatestProject> latestProjects;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private ProjectHistoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_project_hostory, container, false);
        latestProjects = getProjects();
        rv = (RecyclerView) view.findViewById(R.id.rv_laastProject);


        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new ProjectHistoryAdapter(getActivity(), latestProjects);
        rv.setAdapter(adapter);
        return view;
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
