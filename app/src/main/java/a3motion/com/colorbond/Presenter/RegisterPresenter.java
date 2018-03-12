package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 08/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RegisterPresenter {

    void validateCredentials(String email,String fristname, String lastname, String Username, String address, String proffesion, String phone, String DOB, String Gender, String company, String Type, String Typeuser, String image, String password,String title,String repassword);
    void onDestroy();
}
