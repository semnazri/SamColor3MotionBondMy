package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.PublicKey;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class InspirasiViewHolder extends RecyclerView.ViewHolder{
    public ImageView image_inspiarsi;
    public TextView txt_inspirasi_title;
    public RelativeLayout relativeLayout;


    public InspirasiViewHolder(View itemView) {
        super(itemView);

        image_inspiarsi = itemView.findViewById(R.id.img_inspirasi);
        txt_inspirasi_title = itemView.findViewById(R.id.txt_title_inspirasi);
        relativeLayout = itemView.findViewById(R.id.parent);
    }
}
