package a3motion.com.colorbond;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import a3motion.com.colorbond.Adapter.SpinnerPorfesiAdapter;
import a3motion.com.colorbond.Model.Profesi;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 11/19/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RegisterActivity extends AppCompatActivity {

    private Spinner spinner_profesi;
    private List<Profesi> profsi;
    private MaterialDialog mDialog;
    private SpinnerPorfesiAdapter adapter;
    private TextView txt_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.register_activity);

//        spinner_profesi = (Spinner) findViewById(R.id.spinner_register_proffesion);
//        txt_title = (TextView) findViewById(R.id.txt_title_page);
//
//        txt_title.setText("REGISTER ACCOUNT");



//        profsi = getTipe();
//        adapter = new SpinnerPorfesiAdapter(this, profsi);
//        spinner_profesi.setAdapter(adapter);
    }

    private List<Profesi> getTipe() {

        List<Profesi> tp = new ArrayList<>();
        tp.add(new Profesi("Pilih", "0"));
        tp.add(new Profesi("Architect", "1"));
        tp.add(new Profesi("Structural Consultant", "2"));
        tp.add(new Profesi("Quantity Surveyor", "3"));

        return tp;
    }
}
