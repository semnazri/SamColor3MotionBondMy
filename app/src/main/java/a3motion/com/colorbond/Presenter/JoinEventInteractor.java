package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface JoinEventInteractor {

    void doJoinEvent(String token, String id_event, String status, OnSuccessJoinEventListener listener);

    interface OnSuccessJoinEventListener {

        void onSuccess(String response_message, RegisterResponse registerResponse);

        void onelseError(String response_message);

    }

}
