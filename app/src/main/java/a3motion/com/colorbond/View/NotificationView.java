package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.ResponseNotifications;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 13/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface NotificationView {

    void ResultNotif(String response_message, ResponseNotifications responseNotifications);

    void setelseEror(String response_message);
}
