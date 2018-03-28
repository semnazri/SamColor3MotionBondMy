package a3motion.com.colorbond.Presenter;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface SubmitPresenter {
    void validateCredentials(String token, String project_name, String project_type, String date_project, String location, String building_category, String quantity, String size_category, String material_1, String material_2, String delivery_img, String suport_img);
    void onDestroy();

}
