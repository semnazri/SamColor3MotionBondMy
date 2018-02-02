package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Model.Notification;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.NotificationViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    private Context mContext;
    private List<Notification> mValuses;

    public NotificationAdapter(Context context, List<Notification> items) {
        mContext = context;
        mValuses = items;

    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notif, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        String title = mValuses.get(position).getTitle();
        String headline = mValuses.get(position).getHeadline();
        String desc = mValuses.get(position).getDesc();
        holder.des_notif.setVisibility(View.GONE);
        holder.title_notif.setText(title);
        holder.hedline_notif.setText(headline);
        holder.des_notif.setText(desc);
    }

    @Override
    public int getItemCount() {
        return mValuses.size();
    }
}
