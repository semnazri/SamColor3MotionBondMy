package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import a3motion.com.colorbond.Listener.RewardListener;
import a3motion.com.colorbond.POJO.DatumList;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.VoucherViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 08/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class VoucherAdapter extends RecyclerView.Adapter<VoucherViewHolder> {
    private List<DatumList> mValues;
    private Context mContext;
    private RewardListener listener;

    public VoucherAdapter(Context context, List<DatumList> items, RewardListener listener) {
        mContext = context;
        mValues = items;
        this.listener = listener;
    }

    @Override
    public VoucherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voucher_new, parent, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VoucherViewHolder holder, final int position) {

        Glide.with(mContext).load(mValues.get(position).getImage()).into(holder.img_pocer);
        holder.img_pocer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.show_dialog(mValues.get(position).getImage(), mValues.get(position).getPoin(), mValues.get(position).getDescription(),mValues.get(position).getIdMasterReward());

            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
