package a3motion.com.colorbond;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;

import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.ChangePassResponse;
import a3motion.com.colorbond.Presenter.ForgotPassPresenter;
import a3motion.com.colorbond.Presenter.ForgotPassPresenterImp;
import a3motion.com.colorbond.View.ForgotPassView;

public class ForgotActivity extends Activity implements ForgotPassView {
    private EditText edt_email;
    private Button btn_send;
    private MaterialDialog mDialog, dialog_muter;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private ForgotPassPresenter forgotPassPresenter;
    private ImageView imageView;
    String img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        img = getIntent().getStringExtra("img");
        imageView = findViewById(R.id.imageView);


        cd = new ConnectionDetector(this);
        forgotPassPresenter = new ForgotPassPresenterImp(this);

        if (img.equals("0")) {
            Glide.with(this).load(R.drawable.new_bondclub).into(imageView);
        } else if (img.equals("1")) {
            Glide.with(this).load(R.drawable.new_partner).into(imageView);
        } else if (img.equals("2")) {
            Glide.with(this).load(R.drawable.new_contractor).into(imageView);
        }


        edt_email = findViewById(R.id.edt_email);
        btn_send = findViewById(R.id.btn_submit);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkconnections(edt_email.getText().toString());
            }
        });
    }

    private void checkconnections(String s) {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {

            forgotPassPresenter.doForgot(edt_email.getText().toString());

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }

    @Override
    public void setEmailInvalid() {
        edt_email.setError(getString(R.string.invalid_email));
    }

    @Override
    public void setEmailError() {
        edt_email.setError(getString(R.string.email_empty));
    }

    @Override
    public void setValid() {
        getDialog_progress();
    }

    @Override
    public void ResultForgotPass(String response_message, ChangePassResponse changePassResponse) {
        getdialogerror("Your new password has been sent to your mail!");
    }

    @Override
    public void setElseError(String response_message) {
        getdialogerror(response_message);
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
