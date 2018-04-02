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

import a3motion.com.colorbond.POJO.DataSlider;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 3/6/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RewardsPagerAdapter extends PagerAdapter {
    LayoutInflater inflater;
    int[] image;
    String[] title;
    String[] subtitle;

    private Context mContext;
    private List<DataSlider> mValues;

    public RewardsPagerAdapter(Context mContext, List<DataSlider> items) {
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
        TextView txtitle, txt_subtitle, txt_count;
        ImageView tximage;

        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_reward_new, container, false);

        tximage = view.findViewById(R.id.imageVP);

        txtitle = view.findViewById(R.id.img_title);


        txtitle.setText(mValues.get(position).getName());
        Glide.with(mContext).load(mValues.get(position).getImage()).into(tximage);

        ((ViewPager) container).addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        (container).removeView((CoordinatorLayout) object);

    }
}
