package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.RegisterResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 08/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RegisterView {

    void setfristNameError();

    void setlastNameError();

    void setCompanyError();

    void setTitleError();

    void setDOBError();

    void setGenderError();

    void setEmailError();

    void setEmailInvalid();

    void setPhoneError();

    void setimageError();

    void setPasswordError();

    void setPasswordInvalid();

    void setRePassError();

    void setRePassInvalid();

    void setvalid();

    void ResultRegister(String response_message, RegisterResponse registerResponse);

    void setelseEror(String response_message);
}
