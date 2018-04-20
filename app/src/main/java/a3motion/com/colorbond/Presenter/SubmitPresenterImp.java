package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.EditProfileResponse;
import a3motion.com.colorbond.POJO.SubmitResponse;
import a3motion.com.colorbond.View.SubmitProjectView;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class SubmitPresenterImp implements SubmitPresenter, SubmitInteractor.OnSuccessSubmitListener {
    private SubmitProjectView submitProjectView;
    private SubmitInteractor submitInteractor;

    public SubmitPresenterImp(SubmitProjectView submitProjectView) {
        this.submitProjectView = submitProjectView;
        this.submitInteractor = new SubmitInteractorImp();
    }


    @Override
    public void validateCredentials(String token, String project_name, String project_type, String date_project, String location, String building_category, String quantity, String size_category, String material_1, String material_2, String delivery_img, String suport_img, String project_owner, String contractor, String color) {
        submitInteractor.doSubmit(token, project_name, project_type, date_project, location, building_category, quantity, size_category, material_1, material_2, delivery_img, suport_img,project_owner,contractor,color, this);

    }

    @Override
    public void onDestroy() {
        submitProjectView = null;
    }

    @Override
    public void onSuccess(String response_message, SubmitResponse submitResponse) {
        if (submitProjectView != null) {
            submitProjectView.ResultSubmit(response_message, submitResponse);
        }
    }


    @Override
    public void OnProject_nameError() {

        if (submitProjectView != null) {
            submitProjectView.setProjectNameError();
        }

    }

    @Override
    public void onDate_projectError() {
        if (submitProjectView != null) {
            submitProjectView.setProjectDateError();
        }
    }

    @Override
    public void onLocationError() {
        if (submitProjectView != null) {
            submitProjectView.setLocationError();
        }
    }

    @Override
    public void OnquantitiyError() {
        if (submitProjectView != null) {
            submitProjectView.setquantitiyError();
        }
    }

    @Override
    public void OnDeliveryNoteError() {
        if (submitProjectView != null) {
            submitProjectView.setDeliveryNoteError();
        }
    }

    @Override
    public void onValid() {
        if (submitProjectView != null) {
            submitProjectView.setValid();
        }
    }

    @Override
    public void onelseError(String response_message) {
        if (submitProjectView != null) {
            submitProjectView.setelseEror(response_message);

        }
    }
}
