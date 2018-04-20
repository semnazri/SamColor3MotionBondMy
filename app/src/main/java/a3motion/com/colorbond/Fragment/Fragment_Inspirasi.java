package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.robohorse.pagerbullet.PagerBullet;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.EventAdapter;
import a3motion.com.colorbond.Adapter.InspirasiAdapter;
import a3motion.com.colorbond.Adapter.InspirasiPagerAdapter;
import a3motion.com.colorbond.Listener.InspirasiListener;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Inspirasi;
import a3motion.com.colorbond.Model.Sliderpoto;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.InspirasiResponse;
import a3motion.com.colorbond.Presenter.EventPresenter;
import a3motion.com.colorbond.Presenter.InspirasiPresenterImp;
import a3motion.com.colorbond.Presenter.InspirasriPresenter;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.InspirasiView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_Inspirasi extends Fragment implements InspirasiListener,InspirasiView {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    View view;
    List<Sliderpoto> slide;
    RecyclerView recyclerView;
    InspirasiPagerAdapter adapter;
    InspirasiAdapter inspirasiAdapter;
    LinearLayoutManager lm;
    private String tokenz;

    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;
    private InspirasriPresenter inspirasriPresenter;

    String userid;
    private SharedPreferences prefsprivate;
    private PagerBullet pager;
    private TextView txt_title;
    private RelativeLayout rl;
    private ImageView img_nav;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cd = new ConnectionDetector(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_inspirasi, container, false);
        pager = view.findViewById(R.id.photos_viewpager);
        pager.setIndicatorTintColorScheme(Color.WHITE, Color.GRAY);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_title.setText("INSPIRATION");
        inspirasriPresenter = new InspirasiPresenterImp(this);
        img_nav = view.findViewById(R.id.img_tolbar);
        recyclerView = view.findViewById(R.id.rv_inspirasi);
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("INSPIRATION");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("INSPIRATION");
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
//        slide = getSlide();

        checkconnections();

        return view;
    }

    private void checkconnections() {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            getDialog_progress();
            inspirasriPresenter.getListInspirasi(tokenz);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }

    }

    private List<Sliderpoto> getSlide() {
        List<Sliderpoto> ins = new ArrayList<>();

        ins.add(new Sliderpoto(10, R.drawable.inspirasi_slide, "Minimalism", "Style"));
        ins.add(new Sliderpoto(5, R.drawable.inspiras_2, "Modern", "Style"));
        ins.add(new Sliderpoto(10, R.drawable.inspiras_3, " Best Minimalism", "Style"));
        ins.add(new Sliderpoto(5, R.drawable.inspiras_4, "Modern", "Style"));


        return ins;

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


    @Override
    public void getDetail(String image, String title, String author, String date, String detail_inspirasi,String imagebot) {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment_detail_Inspirasi fragment_detail_inspirasi = new Fragment_detail_Inspirasi();
        Bundle bundle = new Bundle() ;
        bundle.putString("image", image);
        bundle.putString("imagebot", imagebot);
        bundle.putString("title", title);
        bundle.putString("author", author);
        bundle.putString("date", date);
        bundle.putString("detail_inspirasi", detail_inspirasi);
        fragment_detail_inspirasi.setArguments(bundle);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_body, fragment_detail_inspirasi, "inspirasi").addToBackStack("inspirasi");
        fragmentTransaction.commit();
    }

    @Override
    public void ResultInspirasi(String response_message, InspirasiResponse inspirasiResponse) {
        dialog_muter.dismiss();
        recyclerView.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(lm);
        inspirasiAdapter = new InspirasiAdapter(inspirasiResponse.getData(),getActivity(), Fragment_Inspirasi.this);
        recyclerView.setAdapter(inspirasiAdapter);


        adapter = new InspirasiPagerAdapter(getActivity(), inspirasiResponse.getData());
        pager.setAdapter(adapter);
    }

    @Override
    public void setelseEror(String response_message) {
        getdialogerror(response_message);
    }
}
