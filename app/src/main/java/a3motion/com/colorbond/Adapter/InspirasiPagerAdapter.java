package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import a3motion.com.colorbond.Model.Sliderpoto;
import a3motion.com.colorbond.POJO.DatumInspirasi;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 3/6/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class InspirasiPagerAdapter extends PagerAdapter {
    LayoutInflater inflater;
    int[] image;
    String[] title;
    String[] subtitle;

    private Context mContext;
    private List<DatumInspirasi> mValues;

    public InspirasiPagerAdapter(Context mContext, List<DatumInspirasi> items) {
        this.mContext = mContext;
        mValues = items;
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;

    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView txtitle, txt_subtitle,txt_count;
        ImageView tximage;

        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_vp_new, container, false);

        tximage = (ImageView) view.findViewById(R.id.imageVP);
        txt_count = (TextView) view.findViewById(R.id.count);
        txtitle = (TextView) view.findViewById(R.id.img_title);
        txt_subtitle = (TextView) view.findViewById(R.id.img_subtitle);

//        if (mValues.get(position).getCount() == 0){
//            txt_count.setVisibility(View.GONE);
//        }else{
//            txt_count.setVisibility(View.VISIBLE);
//            txt_count.setText(String.valueOf(mValues.get(position).getCount()));
//        }

//        String id = mValues.get(position).getSlideId();
//        String image = mValues.get(position).getSlideImage();
//
        txtitle.setText(mValues.get(position).getTitle());
        Glide.with(mContext).load(mValues.get(position).getImageSlider()).into(tximage);
//        tximage.setImageResource(image[position]);
//        txtitle.setText(title[position]);
//        txt_subtitle.setText(mValues.get(position).getSubtitle());

        ((ViewPager) container).addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        (container).removeView((CoordinatorLayout) object);

    }
}
