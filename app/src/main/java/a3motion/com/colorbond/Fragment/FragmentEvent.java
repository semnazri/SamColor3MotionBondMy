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

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.EventAdapter;
import a3motion.com.colorbond.Adapter.FollowersAdapter;
import a3motion.com.colorbond.Listener.Event_listener;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Event;
import a3motion.com.colorbond.Model.Followers;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentEvent extends Fragment implements Event_listener {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_event, container, false);


        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        img_nav = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_title.setText("BONDPARTNER EVENT");
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("BONDPARTNER EVENT");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("BONDPARTNER EVENT");
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

        events = getAllEVent();
        rv = view.findViewById(R.id.rv_event);

        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new EventAdapter(getActivity(), events, FragmentEvent.this);
        rv.setAdapter(adapter);
        return view;


    }

    private List<Event> getAllEVent() {

        List<Event> lp = new ArrayList<>();
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));
        lp.add(new Event("20 November 2017", "18:00 AM till end", "ARCHITECT 101", "Mempererat Persaudaraan", "Muthiarys", "Tokyo Dome"));

        return lp;

    }

    @Override
    public void show_event(String date, String hour, String nama_event, String tema_event, String pic, String location) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_join);

        TextView tv_join_disjoin = (TextView) dialog.findViewById(R.id.txt_join_disjoin);
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
}
