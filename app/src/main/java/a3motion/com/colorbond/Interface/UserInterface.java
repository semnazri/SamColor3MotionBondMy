package a3motion.com.colorbond.Interface;

import a3motion.com.colorbond.POJO.Auth;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 5/15/17.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface UserInterface {
    @FormUrlEncoded
    @POST("token")
    Call<ResponseBody> getTasks(@Header("Authorization") String Authorization, @Field("tipe") String type);

    @POST("notif/get_notif")
    Call<ResponseBody> getNotif(@Header("Authorization") String Authorization);

    @FormUrlEncoded
    @POST("forgot/change")
    Call<ResponseBody> doChange(@Header("Authorization")String Authorization, @Field("old_pass")String old_pass,@Field("new_pass")String new_pass);

    @FormUrlEncoded
    @POST("forgot/send")
    Call<ResponseBody> doForgot(@Field("email")String email);
}
