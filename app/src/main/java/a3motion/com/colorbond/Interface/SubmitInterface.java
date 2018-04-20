package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 26/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface SubmitInterface {

//    @FormUrlEncoded
//    @POST("project/submit")
//    Call<ResponseBody> doSubmitProject(@Header("Authorization") String Authorization,
//                                       @Field("project_name") String project_name, @Field("project_type") String project_type,
//                                       @Field("date_project") String date_project, @Field("location") String location,
//                                       @Field("building_category") String building_category, @Field("quantity") String quantity,
//                                       @Field("size_category") String size_category, @Field("material_1") String material_1,
//                                       @Field("material_2") String material_2, @Field("delivery_img") String delivery_img,
//                                       @Field("suport_img") String suport_img);

    @FormUrlEncoded
    @POST("project/submit")
    Call<ResponseBody> doSubmitProject(@Header("Authorization") String Authorization,
                                       @Field("project_name") String project_name, @Field("project_type") String project_type,
                                       @Field("date_project") String date_project, @Field("location") String location,
                                       @Field("building_category") String building_category, @Field("quantity") String quantity,
                                       @Field("size_category") String size_category, @Field("material_1") String material_1,
                                       @Field("material_2") String material_2, @Field("delivery_img") String delivery_img,
                                       @Field("suport_img") String suport_img, @Field("project_owner") String project_owner,
                                       @Field("contractor") String contractor, @Field("color")String color);

}
