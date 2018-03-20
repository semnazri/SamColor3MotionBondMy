package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ChangePassResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 15/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ChangePasswordInteractor {
    void doChangePassword(String token, String OldPass, String newPass_1, String newPass_2, ChangePasswordInteractor.onSuccessChangePassListener listener);

    interface onSuccessChangePassListener {
        void onSuccess(String response_message, ChangePassResponse changePassResponse);

        void onOldPassError();

        void onNewPassError();

        void onNewRePassError();

        void onNewRePassinvalid();

        void onValid();

        void onElseError(String response_message);
    }
}
