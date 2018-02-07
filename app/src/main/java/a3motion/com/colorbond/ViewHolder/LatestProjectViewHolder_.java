package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/3/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LatestProjectViewHolder_ extends RecyclerView.ViewHolder {
    public TextView place, place_detail, dates;
    public Button img_progess;
    public CardView cardView;

    public LatestProjectViewHolder_(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardView);
        place = itemView.findViewById(R.id.place_name);
        place_detail = itemView.findViewById(R.id.place_detail);
        dates = itemView.findViewById(R.id.project_date);
        img_progess = itemView.findViewById(R.id.button_progres);
    }
}
