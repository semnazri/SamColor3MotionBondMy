package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.EditProfileResponse;
import a3motion.com.colorbond.POJO.EventResponse;
import a3motion.com.colorbond.View.EditProfileView;
import a3motion.com.colorbond.View.EventView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class EditProfilePresenterImp implements EditProfilePresenter, EditProfileInteractor.OnSuccessEditProfileListener {
    private EditProfileView editProfileView;
    private EditProfileInteractor editProfileInteractor;

    public EditProfilePresenterImp(EditProfileView editProfileView){
        this.editProfileView = editProfileView;
        this.editProfileInteractor = new EditProfileInteractorImp();
    }


    @Override
    public void validateCredentials(String token, String firstname, String lastname, String companny, String title, String dob, String gender, String email, String phone) {
        editProfileInteractor.doEdit(token,firstname,lastname,companny,title,dob,gender,email,phone,this);

    }

    @Override
    public void onDestroy() {
        editProfileView = null;
    }

    @Override
    public void onSuccess(String response_message, EditProfileResponse editProfileResponse) {
        if (editProfileView != null){
            editProfileView.ResultEditProfile(response_message,editProfileResponse);
        }
    }



    @Override
    public void onEmailError() {
        if (editProfileView != null){
            editProfileView.setEmailError();
        }
    }

    @Override
    public void onEmailInValid() {
        if (editProfileView != null){
            editProfileView.setEmailInvalid();
        }
    }

    @Override
    public void OnCompanynameError() {
        if (editProfileView != null){
            editProfileView.setCompanyError();
        }
    }

    @Override
    public void OnFirstnameError() {
        if (editProfileView != null){
            editProfileView.setfristNameError();
        }
    }

    @Override
    public void OnLastnameError() {
        if (editProfileView != null){
            editProfileView.setlastNameError();
        }
    }

    @Override
    public void onDOBError() {
        if (editProfileView != null){
            editProfileView.setDOBError();
        }
    }

    @Override
    public void onPoneError() {
        if (editProfileView != null){
            editProfileView.setPhoneError();
        }
    }

    @Override
    public void onValid() {
        if (editProfileView != null){
            editProfileView.setValid();
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (editProfileView != null){
            editProfileView.setelseEror(response_message);
        }
    }
}
