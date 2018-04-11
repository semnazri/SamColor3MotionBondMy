package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 07/01/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface LoginInteractor {

    void login(String email, String password,String img, OnLoginFinishedListener listener);

    interface OnLoginFinishedListener {
        void onEmailError();

        void onEmailInValid();

        void onPasswordError();

        void onPasswordInValid();

        void onValid();

        void onSuccess(String response_message, String type, String token, String firstname,String Lastname, String username, String email, String phone, String companny, String title, String point);

        void onelseError(String response_message);

    }
}
