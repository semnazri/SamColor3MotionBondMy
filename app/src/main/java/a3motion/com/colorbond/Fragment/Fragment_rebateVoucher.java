package a3motion.com.colorbond.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;

import a3motion.com.colorbond.Adapter.VoucherAdapter;
import a3motion.com.colorbond.Listener.RewardListener;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.RewardListResponse;
import a3motion.com.colorbond.POJO.SubmitResponse;
import a3motion.com.colorbond.Presenter.RewardListPresenter;
import a3motion.com.colorbond.Presenter.RewardListPresenterImp;
import a3motion.com.colorbond.Presenter.RewardReedemPresenter;
import a3motion.com.colorbond.Presenter.RewardReedemPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.RewardListVIew;
import a3motion.com.colorbond.View.RewardReedemView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 14/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_rebateVoucher extends Fragment implements RewardListVIew, RewardListener, RewardReedemView {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid, type, merchant_type, tokenz, reward_id, point_user;
    private View view;
    //    private List<Voucher> vouchers;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private VoucherAdapter adapter;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;
    private RewardListPresenter rewardListPresenter;
    private RewardReedemPresenter rewardReedemPresenter;
    private SharedPreferences prefsprivate;
    private Dialog dialog_followers;

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
        point_user = prefsprivate.getString(BlueScoopPreferences.poin, "null");
        Log.d("ahhaha", reward_id);

//        vouchers = getVouchers();
        rv = view.findViewById(R.id.rv_vocer);
        rewardListPresenter = new RewardListPresenterImp(this);
        rewardReedemPresenter = new RewardReedemPresenterImp(this);

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
            rewardListPresenter.getListRewards(tokenz, merchant_type, userid, reward_id);


        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }


    @Override
    public void ResultList(String response_message, RewardListResponse rewardListResponse) {
        dialog_muter.dismiss();

        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new VoucherAdapter(getActivity(), rewardListResponse.getData(), this);
        rv.setAdapter(adapter);
    }

    @Override
    public void ResultList(String response_message, SubmitResponse submitResponse) {
        getSUcessREquest("Your request is being processed");

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

    private void getSUcessREquest(String response_message) {
        dialog_muter.dismiss();
        mDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .content(response_message)
                .positiveText("Close")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mDialog.dismiss();
                        dialog_followers.dismiss();
                    }
                })
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
    public void show_dialog(String image, final String point, String nama_reward, final String id_master_reward) {

        dialog_followers = new Dialog(getActivity());
        dialog_followers.setContentView(R.layout.layout_request);
        dialog_followers.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        final Button btn_back = dialog_followers.findViewById(R.id.btn_close);
        final Button btn_reedem = dialog_followers.findViewById(R.id.btn_redem);
        final TextView txt_detail = dialog_followers.findViewById(R.id.txt_detail_voucher);
        final ImageView img_voucher = dialog_followers.findViewById(R.id.img_voucher);
        final EditText voucher_qty = dialog_followers.findViewById(R.id.edt_quantitiy_voucher);

        Glide.with(getActivity()).load(image).into(img_voucher);

        txt_detail.setText(nama_reward + "\n" + point + "Point");


        btn_reedem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String qty = voucher_qty.getText().toString();
//                Toast.makeText(getActivity(), qty, Toast.LENGTH_SHORT).show();

                if (Integer.parseInt(point_user) < Integer.parseInt(qty)) {
                    getdialogerror("insufficient points to proceed");
                } else {
                    rewardReedemPresenter.doOrderReward(tokenz, id_master_reward, userid, qty);
                }

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_followers.dismiss();
            }
        });

        dialog_followers.show();

    }
}
