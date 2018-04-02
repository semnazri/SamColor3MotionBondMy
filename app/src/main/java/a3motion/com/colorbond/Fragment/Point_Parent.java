package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.robohorse.pagerbullet.PagerBullet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import a3motion.com.colorbond.Adapter.ListBeritaParentAdapter;
import a3motion.com.colorbond.Adapter.RewardsPagerAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Sliderpoto;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.RewardSliderResponse;
import a3motion.com.colorbond.Presenter.RewardSliderPresenter;
import a3motion.com.colorbond.Presenter.RewardSliderPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.RewardSliderVIew;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Point_Parent extends Fragment implements RewardSliderVIew {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;
    String userid, merchant_type;
    //    List<Sliderpoto> slide;
    RewardsPagerAdapter adapter;
    private View view;
    private SharedPreferences prefsprivate;
    private TextView txt_title;
    private PagerBullet pager;
    private ImageView img_nav;
    private String[] tab_name,tab_id;
    private String tokenz;
    private RewardSliderPresenter rewardSliderPresenter;

    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_parent_point, container, false);
        tabLayout = view.findViewById(R.id.home_tabs);
        viewPager = view.findViewById(R.id.homeviewpager);
        txt_title = view.findViewById(R.id.txt_title_page);
        rewardSliderPresenter = new RewardSliderPresenterImp(this);
        txt_title.setText("REWARD");
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        merchant_type = prefsprivate.getString(BlueScoopPreferences.merchant_type, "0");
        pager = view.findViewById(R.id.photos_viewpager);
        pager.setIndicatorTintColorScheme(Color.WHITE, Color.GRAY);
        img_nav = view.findViewById(R.id.img_tolbar);

        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("REWARD");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);

        } else {
            MainActivity_owner.title_page.setText("REWARD");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
            MainActivity_owner.mToolbar.setVisibility(View.GONE);

        }


        if (merchant_type.equals("0")) {
            tab_name = getResources().getStringArray(R.array.bondclub_reward);
            tab_id = getResources().getStringArray(R.array.bondclub_reward_id);
        } else if (merchant_type.equals("1")) {
            if (userid.equals("0")) {
                tab_name = getResources().getStringArray(R.array.bondpartner_sales);
                tab_id = getResources().getStringArray(R.array.bondpartner_sales_id);
            } else {
                tab_name = getResources().getStringArray(R.array.bondpartner_owner);
                tab_id = getResources().getStringArray(R.array.bondpartner_owner_id);
            }
        } else if (merchant_type.equals("2")) {
            tab_name = getResources().getStringArray(R.array.bondcontractor_sales);
            tab_id = getResources().getStringArray(R.array.bondcontractor_sales_id);
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


        checkConnections();

//        viewPager.setAdapter(new Adapter(getChildFragmentManager()));
        getTab();
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return view;
    }

    private void checkConnections() {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            getDialog_progress();
            rewardSliderPresenter.getListEvent(tokenz,merchant_type);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }

    private void getTab() {

        List<HashMap<String, Fragment>> halamannya = new ArrayList<HashMap<String, Fragment>>();
        for (int i = 0; i < tab_name.length; i++) {

            Fragment_rebateVoucher fragment = new Fragment_rebateVoucher();
            Bundle bundle = new Bundle();
            bundle.putString("reward_id", tab_id[i]);
            fragment.setArguments(bundle);
            HashMap<String, Fragment> halaman = new HashMap<String, Fragment>();
            halaman.put(tab_name[i], fragment);
            halamannya.add(halaman);
        }

        ListBeritaParentAdapter adapternya = new ListBeritaParentAdapter(getChildFragmentManager());
        adapternya.addFragment(halamannya);
        viewPager.setAdapter(adapternya);


    }

    private List<Sliderpoto> getSlide() {
        List<Sliderpoto> ins = new ArrayList<>();

        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Business Trip", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));
        ins.add(new Sliderpoto(0, R.drawable.bisnistrip, "Lorem Ipsum", ""));


        return ins;

    }

    @Override
    public void ResultSlider(String response_message, RewardSliderResponse rewardSliderResponse) {
        dialog_muter.dismiss();
        adapter = new RewardsPagerAdapter(getActivity(), rewardSliderResponse.getData());
        pager.setAdapter(adapter);
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
