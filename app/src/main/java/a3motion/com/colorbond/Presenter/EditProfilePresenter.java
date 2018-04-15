package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface EditProfilePresenter {
    void validateCredentials(String token, String firstname, String lastname, String companny, String title, String dob,
                             String gender,String email, String phone);
    void onDestroy();

}
