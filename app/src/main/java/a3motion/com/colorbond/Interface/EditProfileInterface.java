package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface EditProfileInterface {
    @FormUrlEncoded
    @POST("myaccount/edit")
    Call<ResponseBody> getTasks(@Header("Authorization") String Authorization, @Field("first_name") String first_name,
                                @Field("last_name") String last_name, @Field("company") String companny,
                                @Field("title") String title,@Field("date_of_birth") String date_of_birth,
                                @Field("gender") String gender,@Field("email") String email,
                                @Field("phone") String phone);
}
