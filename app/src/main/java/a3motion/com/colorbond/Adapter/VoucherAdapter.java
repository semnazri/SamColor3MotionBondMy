package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import a3motion.com.colorbond.Model.Voucher;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.EventViewHolder;
import a3motion.com.colorbond.ViewHolder.VoucherViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 08/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class VoucherAdapter extends RecyclerView.Adapter<VoucherViewHolder> {
    private List<Voucher> mValues;
    private Context mContext;

    public VoucherAdapter(Context context, List<Voucher> items) {
        mContext = context;
        mValues = items;
    }

    @Override
    public VoucherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voucher_new, parent, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VoucherViewHolder holder, int position) {

        Glide.with(mContext).load(mValues.get(position).getBg()).into(holder.img_pocer);

//        holder.ammount.setVisibility(View.GONE);
//        holder.place.setVisibility(View.GONE);
//        Glide.with(mContext).load(mValues.get(position).getBg()).into(holder.ll_parent);

//        holder.ll_parent.setBackgroundColor(mValues.get(position).getBg());
//        holder.ammount.setText(mValues.get(position).getAmount());
//        holder.place.setText(mValues.get(position).getPlace());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
