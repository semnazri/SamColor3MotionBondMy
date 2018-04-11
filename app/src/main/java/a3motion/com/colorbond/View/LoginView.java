package a3motion.com.colorbond.View;

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

    void ResultLogin(String response_message, String type, String token, String firstname,String lastname,String username, String email, String phone, String companny, String title, String point);

    void setelseEror(String response_message);
}
