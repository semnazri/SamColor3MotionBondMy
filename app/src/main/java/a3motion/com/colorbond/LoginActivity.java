package a3motion.com.colorbond;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import a3motion.com.colorbond.Utility.BlueScoopPreferences;

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
    private SharedPreferences prefsprivate;
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";

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
        edt_email = findViewById(R.id.edt_email);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edt_email.getText().toString();
                prefsprivate = getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
                SharedPreferences.Editor preEditor = prefsprivate.edit();
                preEditor.putString(BlueScoopPreferences.user_id, email);
                preEditor.commit();

                if (email.equals("owner")){
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }else{

                    Intent i = new Intent(getApplicationContext(), MainActivity_owner.class);
                    startActivity(i);

                }
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
