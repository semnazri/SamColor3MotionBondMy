package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface RegisterInterface {
    @FormUrlEncoded
    @POST("daftar/submit")
    Call<ResponseBody> doRegisterUser(@Field("first_name") String frist_name, @Field("last_name") String last_name,
                                      @Field("company") String company, @Field("title") String title,
                                      @Field("date") String DOB, @Field("gender") String gender,
                                      @Field("email") String email, @Field("phone") String phone,@Field("image") String image,
                                      @Field("password")String password, @Field("type")String type, @Field("type_user")String type_user);
}
