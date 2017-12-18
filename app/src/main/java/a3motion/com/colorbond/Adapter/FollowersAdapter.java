package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Model.Followers;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.FollowersViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersViewHolder> {
    private List<Followers> mValues;
    private Context mContext;

    public FollowersAdapter(Context context, List<Followers> items) {
        mContext = context;
        mValues = items;
    }

    @Override
    public FollowersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_followers, parent, false);
        return new FollowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FollowersViewHolder holder, int position) {
        holder.folowers_name.setText(mValues.get(position).getFollowers_name());
        holder.folowers_job.setText(mValues.get(position).getFollowers_job());
        holder.folowers_company.setText("Company : " + mValues.get(position).getFollowers_company());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
