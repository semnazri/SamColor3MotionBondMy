package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ResponseNotifications;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface NotificationsInteractor {

    void getNotification(String token, OnSuccessgetNotifListener listener);

    interface OnSuccessgetNotifListener {

        void onSuccess(String response_message, ResponseNotifications responseNotifications);

        void onelseError(String response_message);

    }

}
