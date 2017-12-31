package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class InspirasiViewHolder extends RecyclerView.ViewHolder{
    public ImageView image_inspiarsi, image_inspirasi_creator;
    public TextView txt_inspirasi_title, txt_inspirasi_creator_name, txt_inspirasi_creator_job;


    public InspirasiViewHolder(View itemView) {
        super(itemView);

        image_inspiarsi = itemView.findViewById(R.id.img_inspirasi);
        image_inspirasi_creator = itemView.findViewById(R.id.img_inspirasi_creator);
        txt_inspirasi_title = itemView.findViewById(R.id.inspirasi_title);
        txt_inspirasi_creator_name = itemView.findViewById(R.id.inspirasi_creator_name);
        txt_inspirasi_creator_job = itemView.findViewById(R.id.inspirasi_creator_job);

    }
}
