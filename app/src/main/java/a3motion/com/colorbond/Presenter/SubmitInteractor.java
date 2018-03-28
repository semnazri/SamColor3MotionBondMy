package a3motion.com.colorbond.Presenter;

import a3motion.com.colorbond.POJO.SubmitResponse;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface SubmitInteractor {

    void doSubmit(String token, String project_name, String project_type, String date_project, String location, String building_category, String quantity, String size_category, String material_1, String material_2, String delivery_img, String suport_img, SubmitInteractor.OnSuccessSubmitListener listener);

    interface OnSuccessSubmitListener {
        void onSuccess(String response_message, SubmitResponse submitResponse);

        void OnProject_nameError();

        void onDate_projectError();

        void onLocationError();

        void OnquantitiyError();

        void OnDeliveryNoteError();

        void onValid();

        void onelseError(String response_message);
    }

}
