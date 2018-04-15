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

import a3motion.com.colorbond.Adapter.MyTeamAchivementAdapter;
import a3motion.com.colorbond.Model.TeamAchivement;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.TeamAchivementResponse;
import a3motion.com.colorbond.Presenter.AchievementPresenter;
import a3motion.com.colorbond.Presenter.AchievementPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.AchievementVIew;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/10/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_MyTeamAchivement extends Fragment implements AchievementVIew {
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
    private AchievementPresenter achievementPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());
        achievementPresenter = new AchievementPresenterImp(this);
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
        checkConnections();



        return view;
    }

    private void checkConnections() {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            getDialog_progress();
            achievementPresenter.getAchievement(tokenz);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
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

    @Override
    public void ResultAchievement(String response_message, TeamAchivementResponse teamAchivement) {
        dialog_muter.dismiss();
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new MyTeamAchivementAdapter(getActivity(), teamAchivement.getData());
        rv.setAdapter(adapter);
    }

    @Override
    public void setelseEror(String response_message) {
        getdialogerror(response_message);
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
                        getFragmentManager().popBackStack();
                    }
                })
                .show();
    }
}
