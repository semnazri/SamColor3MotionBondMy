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
import a3motion.com.colorbond.POJO.EditProfileResponse;
import a3motion.com.colorbond.Presenter.EditProfilePresenter;
import a3motion.com.colorbond.Presenter.EditProfilePresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.EditProfileView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 25/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_Edit_profile extends Fragment implements EditProfileView {
    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    String userid;
    private ImageView img_nav;
    private TextView txt_title;
    private SharedPreferences prefsprivate;
    private View view;
    private EditText edt_usr_name, edt_email, edt_company, edt_firstname, edt_lastname, edt_dob, edt_phone, edt_gender;
    private Button btn_save;
    private EditProfilePresenter editProfilePresenter;
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

        view = inflater.inflate(R.layout.layout_edit_profile, container, false);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        txt_title = view.findViewById(R.id.txt_title_page);
        edt_usr_name = view.findViewById(R.id.edt_username);
        img_nav = view.findViewById(R.id.img_tolbar);
        edt_email = view.findViewById(R.id.edt_email);
        edt_company = view.findViewById(R.id.edt_company);
        edt_firstname = view.findViewById(R.id.edt_first_name);
        edt_lastname = view.findViewById(R.id.edt_last_name);
        edt_dob = view.findViewById(R.id.edt_dob);
        edt_phone = view.findViewById(R.id.edt_phone);
        edt_gender = view.findViewById(R.id.edt_gender);
        btn_save = view.findViewById(R.id.btn_do_edit);
        editProfilePresenter = new EditProfilePresenterImp(this);


        txt_title.setText("Edit Profile");
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("Edit Profile");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("Edit Profile");
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

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                checkconenctions(edt_usr_name.getText().toString(), edt_email.getText().toString(), edt_company.getText().toString(),edt_firstname.getText().toString(), edt_lastname.getText().toString(),edt_dob.getText().toString(), edt_phone.getText().toString(), edt_gender.getText().toString());

            }
        });
        return view;
    }



    private void checkconenctions(String usrname, String email, String company, String firstname, String lastname, String dob, String phone, String gender) {
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            String tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
            editProfilePresenter.validateCredentials(tokenz,usrname,email,company,firstname,lastname,dob,phone,gender);

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
        editProfilePresenter.onDestroy();
        super.onDestroy();
    }
    @Override
    public void ResultEditProfile(String response_message, EditProfileResponse editProfileResponse) {
        dialog_muter.dismiss();
        getdialogerror(editProfileResponse.getMessage());
    }

    @Override
    public void setelseEror(String response_message) {
        getdialogerror(response_message);
    }

    @Override
    public void setUsernameError() {
        edt_usr_name.setError(getString(R.string.canot_empty));
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
    public void setCompanyError() {
        edt_company.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setFirstError() {
        edt_firstname.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setLastError() {
        edt_lastname.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setDOBError() {
        edt_dob.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setPhoneError() {
        edt_phone.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setGenderError() {
        edt_gender.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setValid() {
        getDialog_progress();
    }
}
