package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ChangePassResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ForgotPassInteractor {
    void doChangePassword(String email, ForgotPassInteractor.onSuccessForgotPassListener listener);

    interface onSuccessForgotPassListener {
        void onSuccess(String response_message, ChangePassResponse changePassResponse);

        void onEmailError();

        void onEmailinvalid();

        void onValid();

        void onElseError(String response_message);
    }
}
