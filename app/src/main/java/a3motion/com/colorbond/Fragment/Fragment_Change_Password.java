package a3motion.com.colorbond.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.ChangePassResponse;
import a3motion.com.colorbond.Presenter.ChangePasswordPresenter;
import a3motion.com.colorbond.Presenter.ChangePasswordPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.ChangePassView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_Change_Password extends Fragment implements ChangePassView{
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    private ImageView img_nav;
    private TextView txt_title,txt_forgot;
    private EditText edt_old_pass,edt_new_pass,edt_re_pass;
    private SharedPreferences prefsprivate;
    private View view;
    private Button btn_changePass;
    private ChangePasswordPresenter changePasswordPresenter;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_change_password,container,false);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        txt_title = view.findViewById(R.id.txt_title_page);
        img_nav = view.findViewById(R.id.img_tolbar);
        txt_forgot = view.findViewById(R.id.txt_forgot);
        edt_old_pass = view.findViewById(R.id.edt_old_pass);
        edt_new_pass = view.findViewById(R.id.edt_new_pass);
        edt_re_pass = view.findViewById(R.id.edt_re_pass);
        btn_changePass = view.findViewById(R.id.btn_changePass);
        changePasswordPresenter = new ChangePasswordPresenterImp(this);

        txt_title.setText("CHANGE PASSWORD");
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("CHANGE PASSWORD");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("CHANGE PASSWORD");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
        }
        img_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userid.equals("1")) {
                    getFragmentManager().popBackStack();

                } else {
                    getFragmentManager().popBackStack();

                }
            }
        });

        btn_changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkconenctions(edt_old_pass.getText().toString(), edt_new_pass.getText().toString(), edt_re_pass.getText().toString());
            }
        });


        return view;
    }

    private void checkconenctions(String oldpass, String newpass, String renewpass) {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            String tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            changePasswordPresenter.validateCredentials(tokenz,oldpass,newpass,renewpass);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }

    public void getDialog_progress() {

        dialog_muter = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .content(R.string.please_wait)
                .progress(true, 0)
                .show();
    }

    private void getdialogerror(String response_message) {
        dialog_muter.dismiss();
        mDialog = new MaterialDialog.Builder(getActivity())
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
    @Override
    public void onDestroy() {
        changePasswordPresenter.onDestroy();
        super.onDestroy();
    }
    @Override
    public void setOldPassError() {
        edt_old_pass.setError(getString(R.string.password_error));
    }

    @Override
    public void setNewPassError() {
        edt_new_pass.setError(getString(R.string.password_error));

    }

    @Override
    public void setNewPassInvalid() {
        edt_old_pass.setError(getString(R.string.password_miss_match));

    }

    @Override
    public void setNewREPassError() {
        edt_re_pass.setError(getString(R.string.password_error));

    }

    @Override
    public void setValid() {
        getDialog_progress();
    }

    @Override
    public void ResultChangePass(String response_message, ChangePassResponse changePassResponse) {
        dialog_muter.dismiss();
        getdialogerror(changePassResponse.getMessage());
    }

    @Override
    public void setElseError(String response_message) {
        getdialogerror(response_message);
    }
}
