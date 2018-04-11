package a3motion.com.colorbond.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import a3motion.com.colorbond.Model.VariantColor;
import a3motion.com.colorbond.R;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 26/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class VariantAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<VariantColor> mValues;
    private LayoutInflater infaInflater;

    public VariantAdapter(Context context, ArrayList<VariantColor> items) {
        this.mContext = context;
        this.mValues = items;
        infaInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getGroupCount() {
        return mValues.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mValues.get(groupPosition).text.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mValues.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mValues.get(groupPosition).text.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = infaInflater.inflate(R.layout.item_elistview_parent, null);
            VariantColor variantColor = (VariantColor) getGroup(groupPosition);

            ImageView img = convertView.findViewById(R.id.img_parent);

            String type = variantColor.Txt;
            if (type.equals("xpd")) {
                Glide.with(mContext).load(R.drawable.color_xpd).into(img);
            } else if (type.equals("xrw")) {
                Glide.with(mContext).load(R.drawable.color_xrw).into(img);
            } else if (type.equals("ultra")) {
                Glide.with(mContext).load(R.drawable.color_ultra).into(img);
            } else if (type.equals("xal")) {
                Glide.with(mContext).load(R.drawable.color_xal).into(img);
            } else if (type.equals("m")) {
                Glide.with(mContext).load(R.drawable.color_m).into(img);
            }

        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = infaInflater.inflate(R.layout.item_elist_child, null);
            String child = (String) getChild(groupPosition, childPosition);

            TextView xt = convertView.findViewById(R.id.txt_child_elistv);

            String type_variant = getGroup(groupPosition).toString();
            if (type_variant.equals("xpd")) {
                xt.setText(Html.fromHtml("<strong>COLORBOND XPD</strong> " + child));
            } else if (type_variant.equals("xrw")) {
                xt.setText(Html.fromHtml(child));
            } else if (type_variant.equals("ultra")) {
                xt.setText(Html.fromHtml("<strong>COLORBOND ULTRA</strong> " + child));
            } else if (type_variant.equals("xal")) {
                xt.setText(Html.fromHtml("<strong>COLORBOND XAL</strong> " + child));
            } else if (type_variant.equals("m")) {
                xt.setText(Html.fromHtml("<strong>COLORBOND M</strong> " + child));
            }
            
//            if (type_variant.equals("xpd")) {
//                xt.setText(Html.fromHtml(child));
//            } else if (type_variant.equals("xrw")) {
//                xt.setText(Html.fromHtml(child));
//            } else if (type_variant.equals("ultra")) {
//                xt.setText(Html.fromHtml(child));
//            } else if (type_variant.equals("xal")) {
//                xt.setText(Html.fromHtml(child));
//            } else if (type_variant.equals("m")) {
//                xt.setText(Html.fromHtml(child));
//            }
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
