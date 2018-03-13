package a3motion.com.colorbond;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 01/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Activity_Help extends AppCompatActivity {
    private ImageView img_nav;
    private TextView txt_title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_help);
        img_nav = findViewById(R.id.img_tolbar);
        txt_title = findViewById(R.id.txt_title_page);
        txt_title.setText("FAQ");
        img_nav.setVisibility(View.GONE);
    }
}
