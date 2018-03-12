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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.NotificationAdapter;
import a3motion.com.colorbond.Listener.NotificationListener;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Notification;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.ResponseNotifications;
import a3motion.com.colorbond.Presenter.NotificationsPresenter;
import a3motion.com.colorbond.Presenter.NotificationsPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.NotificationView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentNotif extends Fragment implements NotificationListener, NotificationView {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid, tokenz;
    private View view;
    private RecyclerView rv;
    private List<Notification> notif;
    private LinearLayoutManager lm;
    private NotificationAdapter adapter;
    private TextView txt_title;
    private SharedPreferences prefsprivate;
    private ImageView img_nav;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;
    private NotificationsPresenter notificationsPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_notifikasi, container, false);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_title.setText("NOTIFICATION");
        img_nav = view.findViewById(R.id.img_tolbar);
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("NOTIFICATION");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("NOTIFICATION");
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

        rv = view.findViewById(R.id.rv_notif);
        notificationsPresenter = new NotificationsPresenterImp(this);

        checkConnections();
//        notif = getAllNotif();
//
//        rv.setHasFixedSize(true);
//        lm = new LinearLayoutManager(getActivity());
//        rv.setLayoutManager(lm);
//        adapter = new NotificationAdapter(getActivity(), notif, FragmentNotif.this);
//        rv.setAdapter(adapter);


        return view;
    }

    private void checkConnections() {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            getDialog_progress();
            notificationsPresenter.getListNotifications(tokenz);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }

    }

    private List<Notification> getAllNotif() {


        List<Notification> lp = new ArrayList<>();
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 0));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 1));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 2));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 0));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 1));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 2));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 0));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 1));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 2));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 0));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 1));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 2));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 0));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 1));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 2));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 0));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 1));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem), 2));

        return lp;
    }

    @Override
    public void typeDialog(String typeDialog) {

        if (typeDialog.equals("0")) {

            getDialogthanku();
        } else if (typeDialog.equals("1")) {

            getDialogCongrats();
        } else {

            getDialogApproveDisapprove();
        }
    }

    private void getDialogApproveDisapprove() {

        final Dialog dialog_followers = new Dialog(getActivity());
        dialog_followers.setContentView(R.layout.layout_approve);
        dialog_followers.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        final Button btn_back = dialog_followers.findViewById(R.id.btn_dissapprove);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_followers.dismiss();
            }
        });

        dialog_followers.show();
    }

    private void getDialogCongrats() {
        final Dialog dialog_followers = new Dialog(getActivity());
        dialog_followers.setContentView(R.layout.layout_congrats);
        dialog_followers.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        final Button btn_back = dialog_followers.findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_followers.dismiss();
            }
        });

        dialog_followers.show();
    }

    private void getDialogthanku() {

        final Dialog dialog_followers = new Dialog(getActivity());
        dialog_followers.setContentView(R.layout.layout_thank);
        dialog_followers.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        final Button btn_back = dialog_followers.findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_followers.dismiss();
            }
        });

        dialog_followers.show();


    }

    @Override
    public void ResultNotif(String response_message, ResponseNotifications responseNotifications) {
        dialog_muter.dismiss();
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new NotificationAdapter(getActivity(), responseNotifications.getData(), FragmentNotif.this);
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
