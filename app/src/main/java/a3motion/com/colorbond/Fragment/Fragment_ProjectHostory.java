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

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.ProjectHistoryAdapter;
import a3motion.com.colorbond.Model.LatestProject_;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.ProjectHistoryResponse;
import a3motion.com.colorbond.Presenter.ProjectHistoryPresenter;
import a3motion.com.colorbond.Presenter.ProjectHistoryPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.ProjectHistoryView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/10/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_ProjectHostory extends Fragment implements ProjectHistoryView {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String tokenz,point;
    private View view;
    //    private List<LatestProject_> latestProjects;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private ProjectHistoryAdapter adapter;
    private SharedPreferences prefsprivate;
    private ProjectHistoryPresenter projectHistoryPresenter;
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
        view = inflater.inflate(R.layout.fragment_project_hostory, container, false);
        txt_myPoint = view.findViewById(R.id.mypoint);
//        latestProjects = getProjects();
        rv = view.findViewById(R.id.rv_laastProject);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        projectHistoryPresenter = new ProjectHistoryPresenterImp(this);
        checkConnections();


        return view;
    }

    private void checkConnections() {

        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            point = prefsprivate.getString(BlueScoopPreferences.poin, "null");
            getDialog_progress();
            txt_myPoint.setText(point);
            projectHistoryPresenter.getProjectHistory(tokenz);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }

    public void getDialog_progress() {

        dialog_muter = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .content(R.string.please_wait)
                .progress(true, 0)
                .show();
    }

    private void getdialogerror(String response_message) {
        dialog_muter.dismiss();
        mDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .content(response_message)
                .positiveText("Close")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mDialog.dismiss();

                    }
                })
                .show();
    }

    private List<LatestProject_> getProjects() {
        List<LatestProject_> lp = new ArrayList<>();
        lp.add(new LatestProject_("BANDUNG", "(Taman Gedebage", "21 April 2016", 0));
        lp.add(new LatestProject_("JAKARTA", "(Taman Suropati", "21 April 2017", 1));
        lp.add(new LatestProject_("BANDUNG", "(Taman Gedebage", "21 April 2016", 0));
        lp.add(new LatestProject_("JAKARTA", "(Taman Suropati", "21 April 2017", 1));
        lp.add(new LatestProject_("BANDUNG", "(Taman Gedebage", "21 April 2016", 0));
        lp.add(new LatestProject_("JAKARTA", "(Taman Suropati", "21 April 2017", 1));
        lp.add(new LatestProject_("BANDUNG", "(Taman Gedebage", "21 April 2016", 0));
        lp.add(new LatestProject_("JAKARTA", "(Taman Suropati", "21 April 2017", 1));


        return lp;
    }

    @Override
    public void ResultProjectHistory(String response_message, ProjectHistoryResponse projectHistoryResponse) {
        dialog_muter.dismiss();

        if (projectHistoryResponse != null) {
            rv.setHasFixedSize(true);
            lm = new LinearLayoutManager(getActivity());
            rv.setLayoutManager(lm);
            adapter = new ProjectHistoryAdapter(getActivity(), projectHistoryResponse.getProvince());
            rv.setAdapter(adapter);
        }
    }

    @Override
    public void setelseEror(String response_message) {

    }
}
