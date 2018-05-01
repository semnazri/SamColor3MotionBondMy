package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Listener.NotificationListener;
import a3motion.com.colorbond.POJO.Datum;
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
    private List<Datum> mValuses;
    private NotificationListener listener;

    public NotificationAdapter(Context context, List<Datum> items, NotificationListener listener) {
        mContext = context;
        mValuses = items;
        this.listener = listener;

    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notif, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NotificationViewHolder holder, final int position) {
        String title = mValuses.get(position).getTitleNotification();
        String headline = mValuses.get(position).getNotification();
        String desc = mValuses.get(position).getProjectLocation();
        final String sales = mValuses.get(position).getSalesIncharge();
        final String qty = mValuses.get(position).getQuantity();
        final String prjt_name = mValuses.get(position).getProjectName();

        if (mValuses.get(position).getStatus().equals("0")) {
            holder.is_read.setVisibility(View.GONE);
        }

        holder.des_notif.setVisibility(View.GONE);
        holder.title_notif.setText(title);
        holder.hedline_notif.setText(headline);
        holder.des_notif.setText(desc);
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.typeDialog(mValuses.get(position).getTypeNotification(), mValuses.get(position).getIdNotification(), sales, qty, prjt_name);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValuses.size();
    }

    public int updatelist(List<Datum> list) {
        return list.size();
    }
}
