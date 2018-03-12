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

    void doRegister(String email, String fristname, String lastname, String Username, String address, String proffesion, String phone, String DOB, String Gender, String company, String Type, String Typeuser, String image, String password, String title,String repassword, RegisterInteractor.OnSuccessgetRegisterListener listener);

    interface OnSuccessgetRegisterListener {
        void onSuccess(String response_message, RegisterResponse registerResponse);

        void onEmailError();

        void onEmailInValid();

        void onPasswordError();

        void onPasswordInValid();

        void onRePassError();
        void onRePassInvalid();

        void onProffesionError();

        void OnUsernameError();

        void onValid();

        void onelseError(String response_message);
    }

}
