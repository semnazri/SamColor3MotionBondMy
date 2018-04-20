package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Listener.Event_listener;
import a3motion.com.colorbond.Model.Event;
import a3motion.com.colorbond.POJO.EventResponse;
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
    private List<a3motion.com.colorbond.POJO.Event> mValues;
    private Event_listener listener;

    public EventAdapter(Context context, List<a3motion.com.colorbond.POJO.Event> items, Event_listener listener) {
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
    public void onBindViewHolder(EventViewHolder holder, final int position) {
//        final String hour = mValues.get(position).getJam();
        final String hour = "";
        final String nama_event = mValues.get(position).getName();
        final String tema = mValues.get(position).getTema();
        final String date = mValues.get(position).getDate();
        final String lcoat = mValues.get(position).getAddress();
        final String cpname = mValues.get(position).getCp();
        final String cp = mValues.get(position).getCP_Name();
        final String pic = mValues.get(position).getFileimg();
        final String id = mValues.get(position).getId();

        holder.tanggal.setText(date);
//        holder.jam.setText("");
        holder.namaEvent.setText(nama_event);
        holder.temaEvent.setText(tema);
        holder.PIC.setText(pic);
        holder.lcoation.setText(lcoat);
        holder.btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.show_event(date,hour,nama_event,tema, pic, lcoat, mValues.get(position).getFileimg());
                listener.show_event(nama_event,tema,date,lcoat,cpname,cp,pic,id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
