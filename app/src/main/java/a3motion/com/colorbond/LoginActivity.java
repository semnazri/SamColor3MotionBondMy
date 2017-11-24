package a3motion.com.colorbond;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LoginActivity extends Activity {
    private EditText edt_email,edt_pass;
    private TextView txt_register,txt_forgotpass;
    private LinearLayout ll_register;
    private Button btn_login;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity);
        String is_visible = getIntent().getStringExtra("visible");
        ll_register = (LinearLayout) findViewById(R.id.linear_regis);
        txt_register = (TextView) findViewById(R.id.txt_register);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i
                );
            }
        });

        if (is_visible.equals("0")){
            ll_register.setVisibility(View.GONE);
        }

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);

            }
        });



    }
}
