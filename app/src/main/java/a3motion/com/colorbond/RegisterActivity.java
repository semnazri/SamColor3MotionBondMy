package a3motion.com.colorbond;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.SpinnerPorfesiAdapter;
import a3motion.com.colorbond.Model.Profesi;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.Presenter.RegisterPresenter;
import a3motion.com.colorbond.Presenter.RegisterPresenterImp;
import a3motion.com.colorbond.View.RegisterView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/19/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private Spinner spinner_profesi;
    private List<Profesi> profsi;
    private SpinnerPorfesiAdapter adapter;
    private TextView txt_title;
    private ImageView imageView;
    private EditText edt_name, edt_profesion, edt_title, edt_email, edt_password, edt_rePass;
    private Button btn_signUp;
    private MaterialDialog mDialog, dialog_muter;
    private Boolean isInternetPresent = false;
    private ConnectionDetector cd;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.register_activity);
        final String img = getIntent().getStringExtra("img");

        imageView = findViewById(R.id.img_view);
        edt_name = findViewById(R.id.edt_name_register);
        edt_profesion = findViewById(R.id.edt_profesion_register);
        edt_title = findViewById(R.id.edt_title_register);
        edt_email = findViewById(R.id.edt_email_register);
        edt_password = findViewById(R.id.edt_phone_register);
        edt_rePass = findViewById(R.id.edt_retype_register);
        btn_signUp = findViewById(R.id.btn_signup);
        cd = new ConnectionDetector(this);
        registerPresenter = new RegisterPresenterImp(this);

        if (img.equals("0")) {
            Glide.with(this).load(R.drawable.new_bondclub).into(imageView);
        } else if (img.equals("1")) {
            Glide.with(this).load(R.drawable.new_partner).into(imageView);
        } else if (img.equals("2")) {
            Glide.with(this).load(R.drawable.new_contractor).into(imageView);
        }


        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnections(edt_name.getText().toString(), edt_profesion.getText().toString(), edt_title.getText().toString(), edt_email.getText().toString(),
                        edt_password.getText().toString(), edt_rePass.getText().toString(), img);
            }
        });

//        profsi = getTipe();
//        adapter = new SpinnerPorfesiAdapter(this, profsi);
//        spinner_profesi.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        registerPresenter.onDestroy();
        super.onDestroy();
    }

    private void checkConnections(String name, String profession, String title, String email, String password, String repassword, String img) {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {

            registerPresenter.validateCredentials(email, "-", "-", name, "-", profession, "-", "-", "-",
                    "-", img, "0", ".jpg", password,"", repassword);

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
                        finish();
                    }
                })
                .show();
    }

    private List<Profesi> getTipe() {

        List<Profesi> tp = new ArrayList<>();
        tp.add(new Profesi("Pilih", "0"));
        tp.add(new Profesi("Architect", "1"));
        tp.add(new Profesi("Structural Consultant", "2"));
        tp.add(new Profesi("Quantity Surveyor", "3"));

        return tp;
    }

    @Override
    public void setfristNameError() {

    }

    @Override
    public void setlastNameError() {

    }

    @Override
    public void setNameError() {
        edt_name.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setAddressError() {
    }

    @Override
    public void setProfessionError() {
        edt_profesion.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setPhoneError() {

    }

    @Override
    public void setDOBError() {

    }

    @Override
    public void setGenderError() {

    }

    @Override
    public void setCompanyError() {

    }

    @Override
    public void setTypeError() {

    }

    @Override
    public void setimageError() {

    }

    @Override
    public void setTypeUserError() {

    }

    @Override
    public void setTitleError() {

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
        edt_password.setError(getString(R.string.password_error));
    }

    @Override
    public void setPasswordInvalid() {
        edt_password.setError(getString(R.string.password_error2));
    }

    @Override
    public void setRePassError() {
        edt_rePass.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setRePassInvalid() {
        edt_rePass.setError(getString(R.string.password_miss_match));
    }

    @Override
    public void setvalid() {
        getDialog_progress();
    }

    @Override
    public void ResultRegister(String response_message, RegisterResponse registerResponse) {
        dialog_muter.dismiss();
        getdialogerror(registerResponse.getMessage());
    }

    @Override
    public void setelseEror(String response_message) {
        getdialogerror(response_message);
    }
}
