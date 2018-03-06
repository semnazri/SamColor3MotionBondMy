package a3motion.com.colorbond;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class MenuActivity extends AppCompatActivity {

    View btn_architect,btn_roll, btn_contractor;
    private TextView txt_forgot, txt_help;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        btn_architect =  findViewById(R.id.bondclub);
        btn_roll =  findViewById(R.id.bondpart);
        btn_contractor = findViewById(R.id.boncontract);
        txt_help = findViewById(R.id.txt_help);
        txt_forgot = findViewById(R.id.txt_forgot);

        txt_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, Activity_Help.class);
                startActivity(i);
            }
        });

        btn_architect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "0");
                i.putExtra("img", "1");

                startActivity(i);

            }
        });

        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "1");
                i.putExtra("img", "2");

                startActivity(i);
            }
        });

        btn_contractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "0");
                i.putExtra("img", "3");

                startActivity(i);
            }
        });
    }
}
