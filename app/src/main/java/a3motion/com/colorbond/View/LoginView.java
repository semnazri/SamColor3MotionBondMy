package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.Auth;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 07/01/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface LoginView {

    void setEmailError();

    void setEmailInvalid();

    void setPasswordError();

    void setPasswordInvalid();

    void setvalid();

    void ResultLogin(String response_message, Auth auth);

    void setelseEror(String response_message);
}
