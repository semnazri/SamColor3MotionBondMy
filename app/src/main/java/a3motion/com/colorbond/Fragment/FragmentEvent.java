package a3motion.com.colorbond.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
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

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.EventAdapter;
import a3motion.com.colorbond.Adapter.FollowersAdapter;
import a3motion.com.colorbond.Listener.Event_listener;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Event;
import a3motion.com.colorbond.Model.Followers;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.EventResponse;
import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.Presenter.DisJoinEventPresenter;
import a3motion.com.colorbond.Presenter.DisJoinEventPresenterImp;
import a3motion.com.colorbond.Presenter.EventPresenter;
import a3motion.com.colorbond.Presenter.EventPresenterImp;
import a3motion.com.colorbond.Presenter.JoinEventPresenter;
import a3motion.com.colorbond.Presenter.JoinEventPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.EventDisjoin;
import a3motion.com.colorbond.View.EventJoin;
import a3motion.com.colorbond.View.EventView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentEvent extends Fragment implements Event_listener, EventView,EventJoin, EventDisjoin {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid, tokenz;
    private RecyclerView rv;
    private List<Event> events;
    private List<Followers> followers;
    private ImageView img_nav;
    private TextView txt_title;
    private LinearLayoutManager lm, lm_followers;
    private EventAdapter adapter;
    private FollowersAdapter followersAdapter;
    private View view;
    private SharedPreferences prefsprivate;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;
    private EventPresenter eventPresenter;
    private JoinEventPresenter joinEventPresenter;
    private DisJoinEventPresenter disJoinEventPresenter;
    private Button tv_join_disjoin,tv_join_join;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_event, container, false);


        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        img_nav = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_title.setText("EVENT");
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("EVENT");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("EVENT");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);

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

//        events = getAllEVent();
        rv = view.findViewById(R.id.rv_event);
        eventPresenter = new EventPresenterImp(this);
        joinEventPresenter = new JoinEventPresenterImp(this);
        disJoinEventPresenter = new DisJoinEventPresenterImp(this);
        checkConnections();

        return view;


    }

    private void checkConnections() {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            getDialog_progress();
            eventPresenter.getListEvent(tokenz);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }

    }


    @Override
    public void onDestroy() {
        eventPresenter.onDestroy();
        super.onDestroy();
    }
    private void showDialog_listFolowers() {


        final Dialog dialog_followers = new Dialog(getActivity());
        dialog_followers.setContentView(R.layout.layout_followers);
        dialog_followers.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        followers = getFollowers();
        RecyclerView rv_followers = (RecyclerView) dialog_followers.findViewById(R.id.rv_followers);
        final Button btn_back = (Button) dialog_followers.findViewById(R.id.btn_back);

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

    @Override
    public void ResulEvent(String response_message, EventResponse eventResponse) {
        dialog_muter.dismiss();
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new EventAdapter(getActivity(), eventResponse.getEvent(), FragmentEvent.this);
        rv.setAdapter(adapter);

    }

    @Override
    public void ResulDIsJoinEvent(String response_message, RegisterResponse registerResponse) {
        getdialogerror(registerResponse.getMessage());
    }

    @Override
    public void ResulJoinEvent(String response_message, RegisterResponse registerResponse) {
        getdialogerror(registerResponse.getMessage());
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
                    }
                })
                .show();
    }

    @Override
    public void show_event(String name_event, String tema_event, String date_event, String addres_event, String cp_name, String cp, String file_img, final String id) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_join);

        tv_join_disjoin = dialog.findViewById(R.id.txt_join_disjoin);
        tv_join_join = dialog.findViewById(R.id.txt_join_join);

        LinearLayout ll_folowers = dialog.findViewById(R.id.ll_folowers);
        ImageView event_img = dialog.findViewById(R.id.event_img);
        TextView title = dialog.findViewById(R.id.title);
        TextView date_top = dialog.findViewById(R.id.date);
        TextView event_name = dialog.findViewById(R.id.event_name_desc);
        TextView address_event = dialog.findViewById(R.id.event_address_desc);
        TextView cp_event = dialog.findViewById(R.id.event_contact_person_desc);

        title.setText(name_event);
        date_top.setText(date_event);
        event_name.setText(tema_event);
        address_event.setText(addres_event);
        cp_event.setText(cp + " " + cp_name);


        tv_join_disjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialog.dismiss();
                getdialogDiskonfirmasi("Are you want to disjoin?", id);
            }
        });

        tv_join_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdialogkonfirmasi("Are you sure want to join?", id);
//                dialog.dismiss();
            }
        });

//        ll_folowers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog_listFolowers();
//            }
//        });

        Glide.with(getActivity()).load(file_img).into(event_img);

        dialog.show();
    }

    private void getdialogkonfirmasi(String response_message, final String id) {
        dialog_muter.dismiss();
        mDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .content(response_message)
                .positiveText("Yes")
                .negativeText("No")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        joinEventPresenter.doJoinEvent(tokenz, id, "1");
                        tv_join_join.setVisibility(View.GONE);
                        tv_join_disjoin.setVisibility(View.VISIBLE);
                        mDialog.dismiss();

                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mDialog.dismiss();
                    }
                })
                .show();
    }

    private void getdialogDiskonfirmasi(String response_message, final String id) {
        dialog_muter.dismiss();
        mDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .content(response_message)
                .positiveText("Yes")
                .negativeText("No")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        disJoinEventPresenter.doDisJoinEvent(tokenz, id);
                        tv_join_disjoin.setVisibility(View.GONE);
                        tv_join_join.setVisibility(View.VISIBLE);
                        mDialog.dismiss();

                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mDialog.dismiss();
                    }
                })
                .show();
    }
}
