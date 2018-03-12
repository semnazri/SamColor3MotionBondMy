package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.ResponseNotifications;
import a3motion.com.colorbond.View.NotificationView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class NotificationsPresenterImp implements NotificationsPresenter, NotificationsInteractor.OnSuccessgetNotifListener {
    private NotificationView notificationView;
    private NotificationsInteractor notificationsInteractor;

    public NotificationsPresenterImp(NotificationView notificationView) {
        this.notificationView = notificationView;
        this.notificationsInteractor = new NotificationsInteractorImp();
    }

    @Override
    public void getListNotifications(String token) {
        notificationsInteractor.getNotification(token, this);

    }

    @Override
    public void onDestroy() {
        notificationView = null;
    }


    @Override
    public void onSuccess(String response_message, ResponseNotifications responseNotifications) {
        if (notificationView != null) {
            notificationView.ResultNotif(response_message, responseNotifications);
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (notificationView != null) {
            notificationView.setelseEror(response_message);
        }
    }
}
