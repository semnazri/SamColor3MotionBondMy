package a3motion.com.colorbond.Fragment;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import a3motion.com.colorbond.Adapter.BuildingCatAdapter;
import a3motion.com.colorbond.Adapter.MaterialAdapter;
import a3motion.com.colorbond.Adapter.SizeCategotyAdapter;
import a3motion.com.colorbond.Adapter.SizeMaterialAdapter;
import a3motion.com.colorbond.MainActivity;
import a3motion.com.colorbond.MainActivity_owner;
import a3motion.com.colorbond.Model.Building_cats;
import a3motion.com.colorbond.Model.Material;
import a3motion.com.colorbond.Model.Size_category;
import a3motion.com.colorbond.Model.Size_material;
import a3motion.com.colorbond.Network.ConnectionDetector;
import a3motion.com.colorbond.POJO.SubmitResponse;
import a3motion.com.colorbond.Presenter.SubmitPresenter;
import a3motion.com.colorbond.Presenter.SubmitPresenterImp;
import a3motion.com.colorbond.R;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
import a3motion.com.colorbond.View.SubmitProjectView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 31/12/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class Fragment_Submit extends Fragment implements SubmitProjectView {

    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
    private static final int REQUEST_txt_delive_note = 0;
    private static final int REQUEST_txt_suporting_note = 1;
    private static final int PERMISSION_REQUEST_CODE = 1;
    String userid, point, user_from;
    private View view;
    private SharedPreferences prefsprivate;
    private TextView txt_title, txt_m2_sup, txt_point, txt_delive_note, txt_suporting_note, text_upload,txt_size,txt_supporting,txt_contractor;
    private ImageView img_tolbar;
    private List<Building_cats> building_cats;
    private List<Material> materials;
    private List<Size_material> Size_material;
    private List<Size_category> Size_category;
    private Spinner spinner_building_catgory, spinner_material_1, spinner_material_2, spinner_size_catgory;
    private BuildingCatAdapter adapter;
    private MaterialAdapter adapterM;
    private SizeMaterialAdapter adapterS;
    private SizeCategotyAdapter adapterSCat;
    private EditText submit_project_name, submit_date, submit_location, submit_size,submit_project_owner,submit_project_contractor,submit_project_color;
    private Button btn_submit;
    private Uri file;
    private Calendar myCalendar = Calendar.getInstance();
    private Calendar myCalendar1 = Calendar.getInstance();
    private File delivnote, suporting_note;
    private ImageView deliv_img, sup_img;

    private SubmitPresenter submitPresenter;
    private ConnectionDetector cd;
    private Boolean isInternetPresent = false;
    private MaterialDialog mDialog, dialog_muter;

    private String building_cat_txt, size_cat_txt, deliv_img_txt, sup_img_txt, material_1_txt, material_2_txt;

    private LinearLayout ll_build_cat, ll_size_cat,ll_project_owner,ll_project_contractor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cd = new ConnectionDetector(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_submit, container, false);
        prefsprivate = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        userid = prefsprivate.getString(BlueScoopPreferences.mem_type, "1");
        point = prefsprivate.getString(BlueScoopPreferences.poin, "1");
        user_from = prefsprivate.getString(BlueScoopPreferences.merchant_type, "1");

        img_tolbar = view.findViewById(R.id.img_tolbar);
        txt_title = view.findViewById(R.id.txt_title_page);
        txt_m2_sup = view.findViewById(R.id.txt_m2_sup);
        txt_point = view.findViewById(R.id.point);
        text_upload = view.findViewById(R.id.text_upload);
        txt_size = view.findViewById(R.id.txt_size);
        txt_supporting = view.findViewById(R.id.txt_supporting);
        txt_contractor = view.findViewById(R.id.txt_contractor);

        submit_project_name = view.findViewById(R.id.submit_project_name);
        submit_date = view.findViewById(R.id.submit_date);
        submit_location = view.findViewById(R.id.submit_location);
        submit_size = view.findViewById(R.id.submit_size);
        submit_project_owner = view.findViewById(R.id.submit_project_owner);
        submit_project_contractor = view.findViewById(R.id.submit_project_contractor);
        submit_project_color = view.findViewById(R.id.submit_project_color);
        spinner_building_catgory = view.findViewById(R.id.spinner_building_catgory);
        spinner_material_1 = view.findViewById(R.id.spinner_material_1);
        spinner_material_2 = view.findViewById(R.id.spinner_material_2);
        spinner_size_catgory = view.findViewById(R.id.spinner_size_catgory);
        txt_delive_note = view.findViewById(R.id.txt_delive_note);
        txt_suporting_note = view.findViewById(R.id.txt_suporting_note);
        btn_submit = view.findViewById(R.id.btn_submit);
        deliv_img = view.findViewById(R.id.deliv_img);
        sup_img = view.findViewById(R.id.sup_img);
        ll_build_cat = view.findViewById(R.id.ll_build_cat);
        ll_size_cat = view.findViewById(R.id.ll_size_cat);
        ll_project_owner = view.findViewById(R.id.ll_project_owner);
        ll_project_contractor = view.findViewById(R.id.ll_project_contractor);

        submitPresenter = new SubmitPresenterImp(this);
        txt_title.setText("SUBMIT PROJECT");
        building_cats = getTipe();
        materials = getMaterial();
        Size_material = getSize();
        Size_category = getSizeCat();

        Log.d("asuk",user_from);


        if (user_from.equals("0")) {
            ll_build_cat.setVisibility(View.GONE);
            ll_size_cat.setVisibility(View.VISIBLE);
            txt_supporting.setText("Upload Specification & Additional document");
            txt_m2_sup.setText(Html.fromHtml(getResources().getString(R.string.sup)));
            text_upload.setText(getResources().getString(R.string.cpy_deliv_note));

        } else if (user_from.equals("1")) {
            ll_build_cat.setVisibility(View.GONE);
            ll_size_cat.setVisibility(View.GONE);
            txt_m2_sup.setText("TON");
            building_cat_txt = "0";
            size_cat_txt = "0";
            txt_size.setText("Volume");
            text_upload.setText(getResources().getString(R.string.upload_po));
        } else if (user_from.equals("2")) {
            ll_build_cat.setVisibility(View.VISIBLE);
            ll_size_cat.setVisibility(View.GONE);
            txt_m2_sup.setText(Html.fromHtml(getResources().getString(R.string.sup)));
            text_upload.setText(getResources().getString(R.string.note_suplier));
            size_cat_txt = "0";
            txt_contractor.setText("Colorbond Supplier");
        }


        if (userid.equals("1")) {
            MainActivity.mToolbar.setVisibility(View.GONE);
            MainActivity.title_page.setText("SUBMIT PROJECT");
            MainActivity.img_title.setVisibility(View.GONE);
            MainActivity.title_page.setVisibility(View.VISIBLE);
            img_tolbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (MainActivity.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity.mDrawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            });

        } else {
            MainActivity_owner.mToolbar.setVisibility(View.GONE);
            MainActivity_owner.title_page.setText("SUBMIT PROJECT");
            MainActivity_owner.img_title.setVisibility(View.GONE);
            MainActivity_owner.title_page.setVisibility(View.VISIBLE);
            img_tolbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (MainActivity_owner.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        MainActivity_owner.mDrawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        MainActivity_owner.mDrawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            });
        }


        txt_point.setText(point);

        submit_date.setOnClickListener(new View.OnClickListener() {
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


        adapter = new BuildingCatAdapter(getActivity(), building_cats);
        spinner_building_catgory.setAdapter(adapter);

        adapterM = new MaterialAdapter(getActivity(), materials);
        spinner_material_1.setAdapter(adapterM);

        adapterS = new SizeMaterialAdapter(getActivity(), Size_material);
        spinner_material_2.setAdapter(adapterS);

        adapterSCat = new SizeCategotyAdapter(getActivity(), Size_category);
        spinner_size_catgory.setAdapter(adapterSCat);

        txt_delive_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, REQUEST_txt_delive_note);
                } else {
                    requestPermission();
                }
            }
        });

        txt_suporting_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, REQUEST_txt_suporting_note);
                } else {
                    requestPermission();
                }
            }
        });

        spinner_size_catgory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item_id = String.valueOf(((TextView) view.findViewById(R.id.province_id__)).getText().toString());
                String item_name = ((TextView) view.findViewById(R.id.province_name__)).getText().toString();
//                size_cat_txt = item_id;
                size_cat_txt = item_name;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_building_catgory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item_id = String.valueOf(((TextView) view.findViewById(R.id.province_id__)).getText().toString());
                String item_name = ((TextView) view.findViewById(R.id.province_name__)).getText().toString();
//                size_cat_txt = item_id;

                building_cat_txt = item_name;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_material_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item_id = String.valueOf(((TextView) view.findViewById(R.id.province_id__)).getText().toString());
                String item_name = ((TextView) view.findViewById(R.id.province_name__)).getText().toString();
//                size_cat_txt = item_id;
                material_1_txt = item_name;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_material_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item_id = String.valueOf(((TextView) view.findViewById(R.id.province_id__)).getText().toString());
                String item_name = ((TextView) view.findViewById(R.id.province_name__)).getText().toString();
//                size_cat_txt = item_id;
                material_2_txt = item_name;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tokenz = prefsprivate.getString(BlueScoopPreferences.token, "null");
                String mem_type = prefsprivate.getString(BlueScoopPreferences.merchant_type, "null");

                sup_img_txt = txt_suporting_note.getText().toString();

                if (sup_img_txt.equals("")) {
                    sup_img_txt = "0";
                }

                if (user_from.equals("0")) {
                    building_cat_txt = "0";

                } else if (user_from.equals("1")) {

                    building_cat_txt = "0";
                    size_cat_txt = "0";
                } else if (equals("2")) {
                    size_cat_txt = "0";
                }

                checkconenctions(tokenz, submit_project_name.getText().toString(), mem_type, submit_date.getText().toString(),
                        submit_location.getText().toString(), building_cat_txt, submit_size.getText().toString(),
                        size_cat_txt, material_1_txt, material_2_txt, deliv_img_txt, sup_img_txt);
            }
        });


        return view;
    }

    private void updateLabel() {

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        submit_date.setText(sdf.format(myCalendar1.getTime()));


    }

    private void checkconenctions(String tokenz, String submit_project_name, String mem_type, String submit_date, String submit_location, String building_cat_txt, String submit_size, String size_cat_txt, String material_1_txt, String material_2_txt, String deliv_img_txt, String sup_img_txt) {

        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent) {
            submitPresenter.validateCredentials(tokenz, submit_project_name, mem_type, submit_date, submit_location, building_cat_txt, submit_size, size_cat_txt, material_1_txt, material_2_txt, deliv_img_txt, sup_img_txt);

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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            switch (requestCode) {
                case 0:
                    Bitmap delivery = (Bitmap) data.getExtras().get("data");
                    deliv_img.setImageBitmap(delivery);
                    file = Uri.fromFile(getFiledeliv());

                    txt_delive_note.setText(getFiledeliv().getName());


                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    delivery.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                    byte[] byteArrayImage = baos.toByteArray();

                    String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
                    Log.d("encoded", String.valueOf(encodedImage));

                    deliv_img_txt = encodedImage;

                    break;
                case 1:
                    Bitmap suporting = (Bitmap) data.getExtras().get("data");
                    file = Uri.fromFile(getFilesuport());
                    sup_img.setImageBitmap(suporting);

                    txt_suporting_note.setText(getFilesuport().getName());

                    ByteArrayOutputStream baos1 = new ByteArrayOutputStream();

                    suporting.compress(Bitmap.CompressFormat.JPEG, 100, baos1);

                    byte[] byteArraySupImage = baos1.toByteArray();

                    String encodedImageSup = Base64.encodeToString(byteArraySupImage, Base64.DEFAULT);
                    Log.d("encoded", String.valueOf(encodedImageSup));

                    sup_img_txt = encodedImageSup;
                    break;
            }
        }
    }

    private File getFiledeliv() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Camera");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(myCalendar.getTime());

        return new File(mediaStorageDir.getPath() + File.separator +
                "COLORBOND_DeliveryNote" + timeStamp + ".jpg");
    }

    private File getFilesuport() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Camera");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(myCalendar.getTime());

        return new File(mediaStorageDir.getPath() + File.separator +
                "COLORBOND_Suporting" + timeStamp + ".jpg");
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);

    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED) {

            return true;

        } else {

            return false;
        }
    }

    private List<Building_cats> getTipe() {
        List<Building_cats> tp = new ArrayList<>();
        tp.add(new Building_cats("Industrial", "0"));
        tp.add(new Building_cats("Comercial", "1"));
        return tp;
    }

    private List<Material> getMaterial() {
        List<Material> tp = new ArrayList<>();
        tp.add(new Material("XPD", "0"));
        tp.add(new Material("XRW", "1"));
        tp.add(new Material("XAL", "2"));
        tp.add(new Material("Ultra", "3"));
        return tp;
    }

    private List<Size_material> getSize() {
        List<Size_material> tp = new ArrayList<>();
        tp.add(new Size_material("0.30 BMT", "0"));
        tp.add(new Size_material("0.35 BMT", "1"));
        tp.add(new Size_material("0.40 BMT", "2"));
        tp.add(new Size_material("0.45 BMT", "3"));
        tp.add(new Size_material("0.50 BMT", "4"));
        tp.add(new Size_material("0.55 BMT", "5"));
        tp.add(new Size_material("0.60 BMT", "6"));
        tp.add(new Size_material("0.65 BMT", "7"));
        tp.add(new Size_material("0.70 BMT", "8"));

        return tp;
    }

    private List<Size_category> getSizeCat() {
        List<Size_category> sc = new ArrayList<>();

        sc.add(new Size_category("SPECIFIED", "0"));
        sc.add(new Size_category("WIN", "1"));
        sc.add(new Size_category("WIN COLORBOND+LYSAGHT", "2"));
        return sc;
    }


    @Override
    public void ResultSubmit(String response_message, SubmitResponse submitResponse) {
        dialog_muter.dismiss();
        getdialogerror(submitResponse.getMessage());
    }

    @Override
    public void setelseEror(String response_message) {
        getdialogerror(response_message);
    }

    @Override
    public void setProjectNameError() {
        submit_project_name.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setProjectDateError() {
        submit_date.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setLocationError() {
        submit_location.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setquantitiyError() {
        submit_size.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setDeliveryNoteError() {
        txt_delive_note.setError(getString(R.string.canot_empty));
    }

    @Override
    public void setValid() {
        getDialog_progress();
    }
}
