package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Model.LatestProject_;
import a3motion.com.colorbond.POJO.Province;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.LatestProjectViewHolder;
import a3motion.com.colorbond.ViewHolder.LatestProjectViewHolder_;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/3/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ProjectHistoryAdapter extends RecyclerView.Adapter<LatestProjectViewHolder_> {
    private List<Province> mValues;
    private Context mContext;

    public ProjectHistoryAdapter(Context context, List<Province> items) {
        mContext = context;
        mValues = items;
    }


    @Override
    public LatestProjectViewHolder_ onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_history, parent, false);
        return new LatestProjectViewHolder_(view);
    }

    @Override
    public void onBindViewHolder(LatestProjectViewHolder_ holder, int position) {
        holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.abutransparent));
        holder.place.setText(mValues.get(position).getLocation());
        holder.place_detail.setText(mValues.get(position).getDetail());
        holder.dates.setText(mValues.get(position).getDate());

        if (mValues.get(position).getStatus().equals("1")){
            holder.img_progess.setBackground(mContext.getResources().getDrawable(R.drawable.btn_rounded_black));
            holder.img_progess.setText("ON PROGRESS");
        }else{
            holder.img_progess.setBackground(mContext.getResources().getDrawable(R.drawable.btn_rounded_ijo));
            holder.img_progess.setText("DONE");

        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
