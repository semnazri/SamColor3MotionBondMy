package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface NotificationInterface {

    @FormUrlEncoded
    @POST("notif/approved")
    Call<ResponseBody> APPROVE(@Header("Authorization") String Authorization, @Field("id_notif") String id_notif);

    @FormUrlEncoded
    @POST("notif/disapproved")
    Call<ResponseBody> Dissapproce(@Header("Authorization") String Authorization, @Field("id_notif") String id_notif);
}
