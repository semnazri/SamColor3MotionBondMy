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

    void doEdit(String token,String fristname, String lastname, String company, String title, String DOB, String gender,
                String email, String phone, EditProfileInteractor.OnSuccessEditProfileListener listener);

    interface OnSuccessEditProfileListener {
        void onSuccess(String response_message, EditProfileResponse editProfileResponse);

        void OnFirstnameError();

        void OnLastnameError();

        void OnCompanynameError();

        void onDOBError();

        void onEmailError();

        void onEmailInValid();

        void onPoneError();

        void onValid();

        void onelseError(String response_message);
    }

}
