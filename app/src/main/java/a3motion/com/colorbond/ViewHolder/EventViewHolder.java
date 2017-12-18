package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class EventViewHolder extends RecyclerView.ViewHolder {
    public TextView tanggal, jam, namaEvent, temaEvent, PIC, lcoation;
    public Button btn_join;

    public EventViewHolder(View itemView) {
        super(itemView);

        tanggal = itemView.findViewById(R.id.date);
        jam = itemView.findViewById(R.id.eventtime);
        btn_join = (Button) itemView.findViewById(R.id.btn_join);
        namaEvent = itemView.findViewById(R.id.event_name);
        temaEvent = itemView.findViewById(R.id.tema_event);
        PIC = itemView.findViewById(R.id.PIC_event);
        lcoation = itemView.findViewById(R.id.Location_event);

    }
}
