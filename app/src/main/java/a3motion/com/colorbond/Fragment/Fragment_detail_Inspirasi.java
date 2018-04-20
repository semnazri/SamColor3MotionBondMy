package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_detail_Inspirasi extends Fragment {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    private View view;
    private SharedPreferences prefsprivate;
    private TextView txt_title, txt_inspirasi, txt_titleInspirasi, txt_author, txt_date, txt_content;
    private ImageView img_nav, img_thumbnail, img_content;
    private String image, title, author, datez, detailcontent,imagebot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detail_inspirasi, container, false);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_title.setText("INSPIRATION");
        img_nav = view.findViewById(R.id.img_tolbar);
        img_content = view.findViewById(R.id.img_content);
        img_thumbnail = view.findViewById(R.id.img_thumbnail);
        txt_inspirasi = view.findViewById(R.id.txt_inspirasi);
        txt_titleInspirasi = view.findViewById(R.id.txt_title);
        txt_author = view.findViewById(R.id.author);
        txt_date = view.findViewById(R.id.txt_date);
        txt_content = view.findViewById(R.id.txt_content);


        img_thumbnail = view.findViewById(R.id.img_thumbnail);
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("INSPIRATION");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("INSPIRATION");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
        }

        img_nav.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        img_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        image = getArguments().getString("image");
        imagebot = getArguments().getString("imagebot");
        title = getArguments().getString("title");
        author = getArguments().getString("author");
        datez = getArguments().getString("date");
        detailcontent = getArguments().getString("detail_inspirasi");

        txt_titleInspirasi.setText(title);
        txt_author.setText(author);
        txt_content.setText(detailcontent);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date;
        try {
            date = dateformat.parse(datez);
            DateFormat dayFormate = new SimpleDateFormat("EEEE dd MMMM yyyy hh:mm");
            String dayFromDate = dayFormate.format(date);
            txt_date.setText(dayFromDate + " WIB");

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.color.abu3)
                .error(R.color.abu3);

        Glide.with(getActivity()).load(image).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).apply(requestOptions).into(img_thumbnail);


        Glide.with(getActivity()).load(imagebot).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).apply(requestOptions).into(img_content);


        return view;
    }
}
