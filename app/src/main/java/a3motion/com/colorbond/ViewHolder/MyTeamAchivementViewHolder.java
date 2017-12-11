package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import a3motion.com.colorbond.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class MyTeamAchivementViewHolder extends RecyclerView.ViewHolder {
    public CircleImageView imageview;
    public TextView team_name, team_position, team_order, team_point;
    public MyTeamAchivementViewHolder(View itemView) {
        super(itemView);

        imageview = (CircleImageView) itemView.findViewById(R.id.team_photo);
        team_name = (TextView) itemView.findViewById(R.id.team_name);
        team_position = (TextView) itemView.findViewById(R.id.team_job);
        team_order = (TextView) itemView.findViewById(R.id.team_order_intact);
        team_point = (TextView) itemView.findViewById(R.id.team_reward_point);
    }
}
