package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import a3motion.com.colorbond.Listener.InspirasiListener;
import a3motion.com.colorbond.Model.Inspirasi;
import a3motion.com.colorbond.POJO.DatumInspirasi;
import a3motion.com.colorbond.POJO.InspirasiResponse;
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

    private List<DatumInspirasi> mValues;
    private Context mContext;
    private InspirasiListener listener;

    public InspirasiAdapter(List<DatumInspirasi> items, Context context,InspirasiListener listener){
        mValues = items;
        mContext = context;
        this.listener = listener;
    }


    @Override
    public InspirasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inspirasi_new,parent, false);

        return new InspirasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InspirasiViewHolder holder, int position) {
        final String title = mValues.get(position).getTitle();
        final String image = mValues.get(position).getImageSlider();
        final String imagebot = mValues.get(position).getImageBottom();
        final String author = mValues.get(position).getAuthor();
        final String date = mValues.get(position).getDateSubmit();
        final String content = mValues.get(position).getContent();

        Log.d("image", image);

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.color.abu3)
                .error(R.color.abu3);
        Glide.with(mContext).load(image).into(holder.image_inspiarsi);

        holder.txt_inspirasi_title.setText(title);

//        Glide.with(mContext).load(image).listener(new RequestListener<Drawable>() {
//            @Override
//            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                return false;
//            }
//        }).apply(requestOptions).into(holder.image_inspiarsi);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.getDetail(image,title,author,date,content,imagebot);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
