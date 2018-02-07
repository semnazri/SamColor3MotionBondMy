package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Model.TeamAchivement;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.MyTeamAchivementViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class MyTeamAchivementAdapter extends RecyclerView.Adapter<MyTeamAchivementViewHolder> {

    private List<TeamAchivement> mValues;
    private Context mContext;

    public MyTeamAchivementAdapter(Context context, List<TeamAchivement> items) {
        mContext = context;
        mValues = items;
    }

    @Override
    public MyTeamAchivementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myteam_achivement, parent, false);
        return new MyTeamAchivementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyTeamAchivementViewHolder holder, int position) {
        holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.abutransparent));
        holder.team_name.setText(mValues.get(position).getTeam_name());
        holder.team_position.setText(mValues.get(position).getTeam_position());
        holder.team_point.setText("Reward Point :" + mValues.get(position).getTeam_point());
        holder.team_order.setText(mValues.get(position).getTeam_order_q() + "ton");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
