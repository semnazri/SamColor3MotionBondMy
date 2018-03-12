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
                                      @Field("username") String username, @Field("address") String address,
                                      @Field("email") String email, @Field("password") String password,
                                      @Field("phone") String phone, @Field("date") String DOB,
                                      @Field("gender") String gender, @Field("company") String company,
                                      @Field("type") String type, @Field("type_user") String type_user,
                                      @Field("image") String image);
}
