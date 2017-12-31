package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import a3motion.com.colorbond.Model.Inspirasi;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.ViewHolder.InspirasiViewHolder;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class InspirasiAdapter extends RecyclerView.Adapter<InspirasiViewHolder> {

    private List<Inspirasi> mValues;
    private Context mContext;

    public InspirasiAdapter(List<Inspirasi> items, Context context){
        mValues = items;
        mContext = context;
    }


    @Override
    public InspirasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inspiration_item,parent, false);

        return new InspirasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InspirasiViewHolder holder, int position) {
        String title = mValues.get(position).getInspirasiTitle();
        String name_crator = mValues.get(position).getInspirasi_creator_name();
        String job_creator = mValues.get(position).getInspirasi_creator_job();

        holder.txt_inspirasi_title.setText(title);
        holder.txt_inspirasi_creator_name.setText(name_crator);
        holder.txt_inspirasi_creator_job.setText(job_creator);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
