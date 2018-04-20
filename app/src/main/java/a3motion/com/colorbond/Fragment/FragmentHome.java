package a3motion.com.colorbond.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

import a3motion.com.colorbond.Adapter.FollowersAdapter;
import a3motion.com.colorbond.Adapter.LatestProjectAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Followers;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.HomeResponse;
import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.Presenter.DisJoinEventPresenter;
import a3motion.com.colorbond.Presenter.DisJoinEventPresenterImp;
import a3motion.com.colorbond.Presenter.HomePresejter;
import a3motion.com.colorbond.Presenter.HomePresemterImp;
import a3motion.com.colorbond.Presenter.JoinEventPresenter;
import a3motion.com.colorbond.Presenter.JoinEventPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.EventDisjoin;
import a3motion.com.colorbond.View.EventJoin;
import a3motion.com.colorbond.View.HomeView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/24/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentHome extends Fragment implements HomeView, EventJoin, EventDisjoin {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid, nama, points, tokenz, merchant_type;
    private View view;
    //    private List<LatestProjectfront> latestProjects;
    private List<Followers> followers;
    private RecyclerView rv;
    private TextView txt_name, txt_point, txt_title_event1, txt_date_event1, txt_no_project;
    private LinearLayoutManager lm, lm_followers;
    private LatestProjectAdapter adapter;
    private FollowersAdapter followersAdapter;
    private ImageView img_top, img_2nd, img_3rd, img_bonpart_program, home_4rd_image;
    private Button btn_join_eveng_1, btn_detail_info;
    private LinearLayout ll_project_history, ll_point, ll_latestproject;
    private MaterialDialog mDialog, dialog_muter;
    private SharedPreferences prefsprivate;
    private HomePresejter homePresejter;
    private JoinEventPresenter joinEventPresenter;
    private DisJoinEventPresenter disJoinEventPresenter;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private Button tv_join_disjoin,tv_join_join;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
//        latestProjects = getProjects();
        rv = view.findViewById(R.id.home_last_project);
        img_top = view.findViewById(R.id.home_top_image);
        img_2nd = view.findViewById(R.id.img_2nd);
        img_3rd = view.findViewById(R.id.home_3rd_image);
        btn_join_eveng_1 = view.findViewById(R.id.join_event1);
        ll_project_history = view.findViewById(R.id.linear_project_history);
        btn_detail_info = view.findViewById(R.id.btn_detail_info);
        ll_point = view.findViewById(R.id.layout_point);
        ll_latestproject = view.findViewById(R.id.ll_latestproject);
        home_4rd_image = view.findViewById(R.id.home_4rd_image);
        txt_name = view.findViewById(R.id.home_name);
        txt_point = view.findViewById(R.id.txt_point);
        txt_title_event1 = view.findViewById(R.id.title_event1);
        txt_date_event1 = view.findViewById(R.id.date_event1);
        txt_no_project = view.findViewById(R.id.txt_no_project);

        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        merchant_type = prefsprivate.getString(BlueScoopPreferences.merchant_type, "1");
        nama = prefsprivate.getString(BlueScoopPreferences.nama, "username");
        points = prefsprivate.getString(BlueScoopPreferences.poin, "10000");
        homePresejter = new HomePresemterImp(this);
        joinEventPresenter = new JoinEventPresenterImp(this);
        disJoinEventPresenter = new DisJoinEventPresenterImp(this);
        checkConnections();

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

        img_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container_body, new Fragment_bondPartMerchant_benefit(), "home").addToBackStack("pembayaran");
                fragmentTransaction.commit();
            }
        });
        img_3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (merchant_type.equals("0")) {
                    startNewActivity(getActivity(), "com.waw.wawcard");
                } else {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.container_body, new Point_Parent(), "home").addToBackStack("pembayaran");
                    fragmentTransaction.commit();

                }
            }
        });
        ll_project_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ll_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_detail_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        home_4rd_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private void checkConnections() {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            getDialog_progress();
            homePresejter.getHomeApi(tokenz);

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

    private void showDialogProgram() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_bondpart_program);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView tv_program_desc = (TextView) dialog.findViewById(R.id.txt_bond_part_program);
        tv_program_desc.setText(getString(R.string.lorem));
        dialog.setCancelable(true);
        dialog.show();
    }

    private void showDialogjoin(String fileimg, String name, String tema, String address, String cp, String cp_name, String date, final String id) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_join);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
//        dialog.getWindow().setLayout((8 * width) / 9, (5 * height) / 5);


        tv_join_disjoin = dialog.findViewById(R.id.txt_join_disjoin);
        tv_join_join = dialog.findViewById(R.id.txt_join_join);

        LinearLayout ll_folowers = dialog.findViewById(R.id.ll_folowers);
        ImageView event_img = dialog.findViewById(R.id.event_img);
        TextView title = dialog.findViewById(R.id.title);
        TextView date_top = dialog.findViewById(R.id.date);
        TextView event_name = dialog.findViewById(R.id.event_name_desc);
        TextView address_event = dialog.findViewById(R.id.event_address_desc);
        TextView cp_event = dialog.findViewById(R.id.event_contact_person_desc);

        title.setText(name);
        date_top.setText(date);
        event_name.setText(tema);
        address_event.setText(address);
        cp_event.setText(cp_name + " " + cp);


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
//                Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();

//                dialog.dismiss();
            }
        });

//        ll_folowers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog_listFolowers();
//            }
//        });

        Glide.with(getActivity()).load(fileimg).into(event_img);

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
    public void ResultHome(String response_message, final HomeResponse homeResponse) {
        dialog_muter.dismiss();
        txt_name.setText(getResources().getString(R.string.hi) + " " + homeResponse.getProfile().getFirstName() + "!");
        txt_point.setText(homeResponse.getProfile().getPoin());
        txt_title_event1.setText(homeResponse.getEvent().get(0).getName());
        txt_date_event1.setText(homeResponse.getEvent().get(0).getDate());

        Glide.with(getActivity()).load(homeResponse.getEvent().get(0).getFileimg()).into(img_top);
        Glide.with(getActivity()).load(homeResponse.getImage().getImage2()).into(img_2nd);
        Glide.with(getActivity()).load(homeResponse.getImage().getImage3()).into(img_3rd);
        btn_join_eveng_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogjoin(
                        homeResponse.getEvent().get(0).getFileimg(),
                        homeResponse.getEvent().get(0).getName(),
                        homeResponse.getEvent().get(0).getTema(),
                        homeResponse.getEvent().get(0).getAddress(),
                        homeResponse.getEvent().get(0).getCp(),
                        homeResponse.getEvent().get(0).getCP_Name(),
                        homeResponse.getEvent().get(0).getDate(),
                        homeResponse.getEvent().get(0).getId());
            }
        });

        if (homeResponse.getLatestProject() != null) {
            rv.setVisibility(View.VISIBLE);
            txt_no_project.setVisibility(View.GONE);
            rv.setHasFixedSize(true);
            lm = new LinearLayoutManager(getActivity());
            rv.setLayoutManager(lm);
            adapter = new LatestProjectAdapter(getActivity(), homeResponse.getLatestProject());
            rv.setAdapter(adapter);
        } else {
            rv.setVisibility(View.GONE);
            txt_no_project.setVisibility(View.VISIBLE);

        }

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
}
