package a3motion.com.colorbond.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rebate_voucher,container,false);
        return view;
    }
}