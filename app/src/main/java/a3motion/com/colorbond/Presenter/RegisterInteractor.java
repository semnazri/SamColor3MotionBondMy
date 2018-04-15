package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.RegisterResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RegisterInteractor {

    void doRegister(String firstname, String lastname, String company, String title, String date, String gender, String email,
                    String phone, String image, String password, String repassword, String type, String type_user,
                    RegisterInteractor.OnSuccessgetRegisterListener listener);

    interface OnSuccessgetRegisterListener {
        void onSuccess(String response_message, RegisterResponse registerResponse);

        void onFirstnameError();

        void onLastnameError();

        void onCompanyError();

        void onDateError();

        void onEmailError();

        void onEmailInValid();

        void onPhoneError();

        void onPasswordError();

        void onPasswordInValid();

        void onRePassError();

        void onRePassInvalid();

        void onValid();

        void onelseError(String response_message);
    }

}
