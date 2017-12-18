package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Listener.Event_listener;
import a3motion.com.colorbond.Model.Event;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.EventViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 19/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private Context mContext;
    private List<Event> mValues;
    private Event_listener listener;

    public EventAdapter(Context context, List<Event> items, Event_listener listener) {
        mContext = context;
        mValues = items;
        this.listener = listener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final String date = mValues.get(position).getDate();
        final String hour = mValues.get(position).getJam();
        final String nama_event = mValues.get(position).getNama_event();
        final String tema = mValues.get(position).getTemaevent();
        final String pic = mValues.get(position).getPic();
        final String lcoat = mValues.get(position).getLocation();

        holder.tanggal.setText(date);
        holder.jam.setText(hour);
        holder.namaEvent.setText(nama_event);
        holder.temaEvent.setText(tema);
        holder.PIC.setText(pic);
        holder.lcoation.setText(lcoat);
        holder.btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.show_event(date,hour,nama_event,tema, pic, lcoat);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}