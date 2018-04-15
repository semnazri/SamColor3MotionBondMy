package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.Auth;

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

        void onSuccess(String response_message, Auth auth);

        void onelseError(String response_message);

    }
}
