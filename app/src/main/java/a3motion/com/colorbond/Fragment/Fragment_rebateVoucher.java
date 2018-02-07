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

import a3motion.com.colorbond.Adapter.VoucherAdapter;
import a3motion.com.colorbond.Model.Voucher;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 14/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_rebateVoucher extends Fragment {

    private View view;
    private List<Voucher> vouchers;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private VoucherAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rebate_voucher, container, false);

        vouchers = getVouchers();
        rv = view.findViewById(R.id.rv_vocer);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        adapter = new VoucherAdapter(getActivity(), vouchers);
        rv.setAdapter(adapter);
        return view;
    }

    private List<Voucher> getVouchers() {

        List<Voucher> vouchers = new ArrayList<>();
        vouchers.add(new Voucher("100.000", "@IKEA ALAM SUTERA", getResources().getColor(R.color.biru)));
        vouchers.add(new Voucher("200.000", "@PERBAKIN SHOOTING RANGE", getResources().getColor(R.color.biru_tras)));
        vouchers.add(new Voucher("300.000", "@ACE HARDWARE", getResources().getColor(R.color.black2)));
        vouchers.add(new Voucher("100.000", "@IKEA ALAM SUTERA", getResources().getColor(R.color.biru)));
        vouchers.add(new Voucher("200.000", "@PERBAKIN SHOOTING RANGE", getResources().getColor(R.color.biru_tras)));
        vouchers.add(new Voucher("300.000", "@ACE HARDWARE", getResources().getColor(R.color.black2)));


        return vouchers;
    }
}
