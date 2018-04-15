package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 08/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RegisterPresenter {

    void validateCredentials(String fristname, String lastname, String company,String title,
                             String DOB,String Gender,String email,String phone,
                             String image,String password,String repassword,String Type, String Typeuser);
    void onDestroy();
}
