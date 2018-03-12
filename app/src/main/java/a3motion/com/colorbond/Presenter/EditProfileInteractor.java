package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.EditProfileResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface EditProfileInteractor {

    void doEdit(String token,String username, String fristname, String lastname, String DOB, String email, String company, String phone, String gender, EditProfileInteractor.OnSuccessEditProfileListener listener);

    interface OnSuccessEditProfileListener {
        void onSuccess(String response_message, EditProfileResponse editProfileResponse);

        void OnUsernameError();

        void onEmailError();

        void onEmailInValid();

        void OnCompanynameError();

        void OnFirstnameError();

        void OnLastnameError();

        void onDOBError();

        void onPoneError();

        void onGenderError();

        void onValid();

        void onelseError(String response_message);
    }

}
