package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ReadNotifInteractor {

    void doRead(String token, String id_notif, ReadNotifInteractor.OnSuccessReadListener listener);

    interface OnSuccessReadListener {
        void onSuccess(String response_message, RegisterResponse registerResponse);

        void onelseError(String response_message);
    }

}
