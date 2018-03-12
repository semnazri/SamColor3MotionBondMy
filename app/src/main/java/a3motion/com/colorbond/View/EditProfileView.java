package a3motion.com.colorbond.View;

import a3motion.com.colorbond.POJO.EditProfileResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 12/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface EditProfileView {

    void ResultEditProfile(String response_message, EditProfileResponse editProfileResponse);

    void setelseEror(String response_message);

    void setUsernameError();

    void setEmailError();

    void setEmailInvalid();

    void setCompanyError();

    void setFirstError();

    void setLastError();

    void setDOBError();

    void setPhoneError();

    void setGenderError();

    void setValid();
}
