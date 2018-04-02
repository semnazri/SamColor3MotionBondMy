package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.VoucherAdapter;
import a3motion.com.colorbond.Model.Voucher;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.RewardListResponse;
import a3motion.com.colorbond.Presenter.RewardListPresenter;
import a3motion.com.colorbond.Presenter.RewardListPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.RewardListVIew;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 14/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_rebateVoucher extends Fragment implements RewardListVIew {

    private View view;
    //    private List<Voucher> vouchers;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private VoucherAdapter adapter;
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid, merchant_type, tokenz,reward_id;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;
    private RewardListPresenter rewardListPresenter;
    private SharedPreferences prefsprivate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rebate_voucher, container, false);

        reward_id = getArguments().getString("reward_id");
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);

        Log.d("ahhaha", reward_id);

//        vouchers = getVouchers();
        rv = view.findViewById(R.id.rv_vocer);
        rewardListPresenter = new RewardListPresenterImp(this);

        checkConnections();


        return view;
    }

    private void checkConnections() {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            merchant_type = prefsprivate.getString(BlueScoopPreferences.merchant_type, "null");
            userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "null");
            getDialog_progress();
            rewardListPresenter.getListRewards(tokenz, userid, reward_id);


        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }

    private List<Voucher> getVouchers() {

        List<Voucher> vouchers = new ArrayList<>();
        vouchers.add(new Voucher("100.000", "@IKEA ALAM SUTERA", R.drawable.ikea));
        vouchers.add(new Voucher("200.000", "@PERBAKIN SHOOTING RANGE", R.drawable.indomerit));
        vouchers.add(new Voucher("300.000", "@ACE HARDWARE", R.drawable.cgv));


        return vouchers;
    }

    @Override
    public void ResultList(String response_message, RewardListResponse rewardListResponse) {
        dialog_muter.dismiss();

        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new VoucherAdapter(getActivity(), rewardListResponse.getData());
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
