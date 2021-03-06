package a3motion.com.colorbond;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;

import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.Auth;
import a3motion.com.colorbond.Presenter.LoginPresenter;
import a3motion.com.colorbond.Presenter.LoginPresenterImp;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.LoginView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LoginActivity extends Activity implements LoginView {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    private EditText edt_email, edt_pass;
    private TextView txt_register, txt_forgotpass;
    private LinearLayout ll_register;
    private Button btn_login;
    private SharedPreferences prefsprivate;
    private LoginPresenter loginPresenter;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private ImageView imageView;
    private MaterialDialog mDialog, dialog_muter;
    private String img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        String is_visible = getIntent().getStringExtra("visible");
        img = getIntent().getStringExtra("img");
        txt_register = findViewById(R.id.txt_register);
        btn_login = findViewById(R.id.btn_login);
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_password);
        txt_forgotpass = findViewById(R.id.txt_forgot);
        ll_register = findViewById(R.id.ll_register);
        imageView = findViewById(R.id.imageView);
        cd = new ConnectionDetector(this);
        loginPresenter = new LoginPresenterImp(this);

        if (img.equals("0")) {
            Glide.with(this).load(R.drawable.new_bondclub).into(imageView);
        } else if (img.equals("1")) {
            Glide.with(this).load(R.drawable.new_partner).into(imageView);
        } else if (img.equals("2")) {
            Glide.with(this).load(R.drawable.new_contractor).into(imageView);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getDialog_progress();
                checkconnection(edt_email.getText().toString(), edt_pass.getText().toString());

            }
        });

        if (is_visible.equals("1")) {
            ll_register.setVisibility(View.GONE);
        }

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                i.putExtra("img",img );
                startActivity(i);

            }
        });

        txt_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ForgotActivity.class);
                i.putExtra("img",img);
                startActivity(i);
            }
        });


    }

    @Override
    public void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setEmailError() {
        edt_email.setError(getString(R.string.email_empty));
    }

    @Override
    public void setEmailInvalid() {
        edt_email.setError(getString(R.string.invalid_email));
    }

    @Override
    public void setPasswordError() {
        edt_pass.setError(getString(R.string.password_error));
    }

    @Override
    public void setPasswordInvalid() {
        edt_pass.setError(getString(R.string.password_error2));
    }

    @Override
    public void setvalid() {
        getDialog_progress();
    }

    @Override
    public void ResultLogin(String response_message, Auth auth) {
        dialog_muter.dismiss();

        prefsprivate = getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        SharedPreferences.Editor preEditor = prefsprivate.edit();

        preEditor.putString(BlueScoopPreferences.token, auth.getToken());
        preEditor.putString(BlueScoopPreferences.mem_type, auth.getType());
//        preEditor.putString(BlueScoopPreferences.nama, username);
        preEditor.putString(BlueScoopPreferences.firstname, auth.getFirstName());
        preEditor.putString(BlueScoopPreferences.lastname, auth.getLasstName());

        preEditor.putString(BlueScoopPreferences.email, auth.getEmail());
        preEditor.putString(BlueScoopPreferences.Phone, auth.getPhone());
        preEditor.putString(BlueScoopPreferences.company, auth.getCompany());
        preEditor.putString(BlueScoopPreferences.DOB, auth.getDate_of_birth());
        preEditor.putString(BlueScoopPreferences.poin, auth.getPoin());
        preEditor.putString(BlueScoopPreferences.merchant_type,img);


        preEditor.commit();

        if (auth.getType().equals("1")) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        } else {
            Intent i = new Intent(getApplicationContext(), MainActivity_owner.class);
            startActivity(i);

        }

    }



    @Override
    public void setelseEror(String response_message) {
        getdialogerror(response_message);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void checkconnection(String email, String password) {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {

            loginPresenter.validateCredentials(edt_email.getText().toString(), edt_pass.getText().toString(), img);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }

    public void getDialog_progress() {

        dialog_muter = new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content(R.string.please_wait)
                .progress(true, 0)
                .show();
    }

    private void getdialogerror(String response_message) {
        dialog_muter.dismiss();
        mDialog = new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content(response_message)
                .positiveText("Close")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mDialog.dismiss();
                    }
                })
                .show();
    }


}
