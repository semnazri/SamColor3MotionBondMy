package a3motion.com.colorbond.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 08/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class VoucherViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout ll_parent;
    public TextView ammount, place;
    public ImageView img_pocer;
    public VoucherViewHolder(View itemView) {
        super(itemView);

        img_pocer = itemView.findViewById(R.id.img_pocer);

//        ll_parent = itemView.findViewById(R.id.parent);
//        ammount = itemView.findViewById(R.id.txt_amount);
//        place = itemView.findViewById(R.id.txt_place);
    }
}
