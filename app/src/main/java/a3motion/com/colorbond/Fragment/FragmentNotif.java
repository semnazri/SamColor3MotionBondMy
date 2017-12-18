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

import a3motion.com.colorbond.Adapter.NotificationAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.Model.Notification;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FragmentNotif extends Fragment {

    private View view;
    private RecyclerView rv;
    private List<Notification> notif;
    private LinearLayoutManager lm;
    private NotificationAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_notifikasi, container, false);
        MainActivity.img_title.setVisibility(View.GONE);
        MainActivity.title_page.setVisibility(View.VISIBLE);
        MainActivity.title_page.setText("NOTIFICATION");
        rv = view.findViewById(R.id.rv_notif);
        notif = getAllNotif();

        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new NotificationAdapter(getActivity(), notif);
        rv.setAdapter(adapter);


        return view;
    }

    private List<Notification> getAllNotif() {


        List<Notification> lp = new ArrayList<>();
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));
        lp.add(new Notification("PROJECT UPDATE", "LOREM IPSUM", getString(R.string.lorem)));

        return lp;
    }
}
