package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class NotificationViewHolder extends RecyclerView.ViewHolder{
    public TextView title_notif, hedline_notif, des_notif;
    public LinearLayout ll ;
    public NotificationViewHolder(View itemView) {
        super(itemView);

        title_notif = itemView.findViewById(R.id.notif_title);
        hedline_notif = itemView.findViewById(R.id.notif_headline);
        des_notif = itemView.findViewById(R.id.notif_desc);
        ll = itemView.findViewById(R.id.parent);
    }
}
