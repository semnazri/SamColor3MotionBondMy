package a3motion.com.colorbond;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class MenuActivity extends AppCompatActivity {

    Button btn_architect,btn_roll, btn_contractor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_activity);

        btn_architect = (Button) findViewById(R.id.btn_architect);
        btn_roll = (Button) findViewById(R.id.btn_roll_former);
        btn_contractor = (Button) findViewById(R.id.btn_Contractor);


        btn_architect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "1");

                startActivity(i);

            }
        });

        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "0");

                startActivity(i);
            }
        });

        btn_contractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(MenuActivity.this, LoginActivity.class));
                i.putExtra("visible", "1");

                startActivity(i);
            }
        });
    }
}
