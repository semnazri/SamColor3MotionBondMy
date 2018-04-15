package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import a3motion.com.colorbond.Model.Gender;
import a3motion.com.colorbond.Model.Profesi;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/19/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class SpinnerGenderAdapter extends BaseAdapter implements SpinnerAdapter {

    private Context mContext;
    private List<Gender> mValues;

    public SpinnerGenderAdapter(Context context, List<Gender> items) {
        mContext = context;
        mValues = items;

    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Object getItem(int position) {
        return mValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_spiner, parent, false);
        }

        TextView province_name = (TextView) convertView.findViewById(R.id.province_name__);
        TextView province_id = (TextView) convertView.findViewById(R.id.province_id__);

        province_name.setText(mValues.get(position).getTipe_name());
        province_id.setText(mValues.get(position).getTipe_id());
        return convertView;

    }
}
