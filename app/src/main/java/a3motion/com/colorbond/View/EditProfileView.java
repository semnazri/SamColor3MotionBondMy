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

    void setValid();
}
