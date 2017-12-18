package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class FollowersViewHolder extends RecyclerView.ViewHolder {
    public TextView folowers_name, folowers_job, folowers_company;
    public FollowersViewHolder(View itemView) {
        super(itemView);

        folowers_name = (TextView) itemView.findViewById(R.id.followers_name);
        folowers_job = (TextView) itemView.findViewById(R.id.followers_job);
        folowers_company = (TextView) itemView.findViewById(R.id.followers_company);
    }
}
