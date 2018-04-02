package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Model.LatestProject_;
import a3motion.com.colorbond.Model.LatestProjectfront;
import a3motion.com.colorbond.POJO.HomeLatestProject;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.LatestProjectViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/3/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LatestProjectAdapter extends RecyclerView.Adapter<LatestProjectViewHolder> {
    private List<HomeLatestProject> mValues;
    private Context mContext;

    public LatestProjectAdapter(Context context, List<HomeLatestProject> items) {
        mContext = context;
        mValues = items;
    }


    @Override
    public LatestProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lastest_home, parent, false);
        return new LatestProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LatestProjectViewHolder holder, int position) {

//        holder.txt_project_name.setText(mValues.get(position).getProject_name());
        holder.txt_project_details.setText(mValues.get(position).getDetail());

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
