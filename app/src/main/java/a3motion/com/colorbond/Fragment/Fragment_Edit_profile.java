package a3motion.com.colorbond.Fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import a3motion.com.colorbond.Adapter.SpinnerGenderAdapter;
import a3motion.com.colorbond.Adapter.SpinnerPorfesiAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Gender;
import a3motion.com.colorbond.Model.Profesi;
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
    String userid, point, user_from;
    private ImageView img_nav;
    private List<Profesi> profsi;
    private List<Gender> gender;
    private TextView txt_title;
    private SharedPreferences prefsprivate;
    private View view;
    private SpinnerPorfesiAdapter adapter;
    private SpinnerGenderAdapter adaptergenders;
    private Spinner spinner_gender, spiner_title;
    private EditText edt_firstname, edt_lastname, edt_company, edt_dob, edt_email, edt_phone;
    private Button btn_save;
    private EditProfilePresenter editProfilePresenter;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;
    private String GEnder, title, email, company, first_name, last_name, DOB, Phone;
    private Calendar myCalendar1 = Calendar.getInstance();

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
//        username = prefsprivate.getString(BlueScoopPreferences.nama, "");
        email = prefsprivate.getString(BlueScoopPreferences.email, "email");
        userid = prefsprivate.getString(BlueScoopPreferences.user_id, "");
        company = prefsprivate.getString(BlueScoopPreferences.company, "");
        first_name = prefsprivate.getString(BlueScoopPreferences.firstname, "");
        last_name = prefsprivate.getString(BlueScoopPreferences.lastname, "");
        DOB = prefsprivate.getString(BlueScoopPreferences.DOB, "");
        Phone = prefsprivate.getString(BlueScoopPreferences.Phone, "");

        txt_title = view.findViewById(R.id.txt_title_page);
//        edt_usr_name = view.findViewById(R.id.edt_username);
        img_nav = view.findViewById(R.id.img_tolbar);
        edt_email = view.findViewById(R.id.edt_email_register);
        edt_company = view.findViewById(R.id.edt_company_register);
        edt_firstname = view.findViewById(R.id.edt_firstname_register);
        edt_lastname = view.findViewById(R.id.edt_lastname_register);
        edt_dob = view.findViewById(R.id.edt_dob);
        edt_phone = view.findViewById(R.id.edt_phone);
        spiner_title = view.findViewById(R.id.spinner_title);
        spinner_gender = view.findViewById(R.id.spinner_gender);
        btn_save = view.findViewById(R.id.btn_do_edit);
        editProfilePresenter = new EditProfilePresenterImp(this);

//        edt_usr_name.setText(username);
        edt_email.setText(email);
        edt_company.setText(company);
        edt_firstname.setText(first_name);
        edt_lastname.setText(last_name);
        edt_phone.setText(Phone);
        edt_dob.setText(DOB);

        edt_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar1.set(Calendar.YEAR, year);
                        myCalendar1.set(Calendar.MONTH, monthOfYear);
                        myCalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel();
                    }

                };

                new DatePickerDialog(getActivity(), date, myCalendar1
                        .get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH),
                        myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txt_title.setText("EDIT PROFILE");
        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("EDIT PROFILE");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("EDIT PROFILE");
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
                checkconenctions(edt_firstname.getText().toString(), edt_lastname.getText().toString(), edt_company.getText().toString(),
                        title, edt_dob.getText().toString(), GEnder, edt_email.getText().toString(), edt_phone.getText().toString());

            }
        });

        profsi = getTipe();
        gender = getGender();

        adapter = new SpinnerPorfesiAdapter(getActivity(), profsi);
        adaptergenders = new SpinnerGenderAdapter(getActivity(), gender);

        spinner_gender.setAdapter(adaptergenders);
        spiner_title.setAdapter(adapter);

        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item_id = String.valueOf(((TextView) view.findViewById(R.id.province_id__)).getText().toString());
                String item_name = ((TextView) view.findViewById(R.id.province_name__)).getText().toString();
//                size_cat_txt = item_id;
                GEnder = item_name;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spiner_title.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item_id = String.valueOf(((TextView) view.findViewById(R.id.province_id__)).getText().toString());
                String item_name = ((TextView) view.findViewById(R.id.province_name__)).getText().toString();
//                size_cat_txt = item_id;
                title = item_name;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    private void checkconenctions(String first_name, String last_name, String company, String title, String dob, String gEnder, String email, String phone) {

        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            String tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");

            editProfilePresenter.validateCredentials(tokenz,first_name,last_name,company,title,dob,gEnder,email,phone);

        } else if (isInternetPresent.equals(false)) {
            getdialogerror("Tidak ada koneksi Internet");
        }
    }

    private void updateLabel() {

    }

    private List<Profesi> getTipe() {

        List<Profesi> tp = new ArrayList<>();
        tp.add(new Profesi("MR.", "0"));
        tp.add(new Profesi("MRS", "1"));

        return tp;
    }

    private List<Gender> getGender() {
        List<Gender> tp = new ArrayList<>();
        tp.add(new Gender("Male", "0"));
        tp.add(new Gender("Female", "1"));


        return tp;
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
    public void setfristNameError() {
        edt_firstname.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setlastNameError() {
        edt_lastname.setError(getString(R.string.canot_empty));
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
    public void setTitleError() {

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
    public void setimageError() {

    }

    @Override
    public void setGenderError() {
    }

    @Override
    public void setValid() {
        getDialog_progress();
    }
}
