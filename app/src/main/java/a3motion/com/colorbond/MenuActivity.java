package a3motion.com.colorbond;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import a3motion.com.colorbond.Utility.BlueScoopPreferences;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class MenuActivity extends AppCompatActivity {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    View btn_architect, btn_roll, btn_contractor;
    private TextView txt_forgot, txt_help;
    private SharedPreferences prefsprivate;
    private String userid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        btn_architect = findViewById(R.id.bondclub);
        btn_roll = findViewById(R.id.bondpart);
        btn_contractor = findViewById(R.id.boncontract);
        txt_help = findViewById(R.id.txt_help);
        txt_forgot = findViewById(R.id.txt_forgot);

        prefsprivate = getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, null);

//        Toast.makeText(this, userid, Toast.LENGTH_SHORT).show();

        if (userid != null){
            if (userid.equals("1")) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            } else {
                Intent i = new Intent(getApplicationContext(), MainActivity_owner.class);
                startActivity(i);

            }
        }

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
                i.putExtra("img", "0");

                startActivity(i);

            }
        });

        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "1");
                i.putExtra("img", "1");

                startActivity(i);
            }
        });

        btn_contractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "0");
                i.putExtra("img", "2");

                startActivity(i);
            }
        });
    }
}
