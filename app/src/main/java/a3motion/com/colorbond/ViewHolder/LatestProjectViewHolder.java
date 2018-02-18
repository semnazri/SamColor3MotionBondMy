package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/3/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LatestProjectViewHolder extends RecyclerView.ViewHolder {
    public TextView txt_project_name,txt_project_details,txt_project_status;
    public LatestProjectViewHolder(View itemView) {
        super(itemView);

        txt_project_name = (TextView) itemView.findViewById(R.id.project_name);
        txt_project_details = (TextView) itemView.findViewById(R.id.project_desc);
    }
}
