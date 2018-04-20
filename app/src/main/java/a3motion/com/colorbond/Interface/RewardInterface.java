package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RewardInterface {
    @FormUrlEncoded
    @POST("reward/get_slider")
    Call<ResponseBody> getSlider(@Header("Authorization") String Authorization, @Field("type") String merchat_type);

    @FormUrlEncoded
    @POST("reward/redeem")
    Call<ResponseBody> doReedem(@Header("Authorization") String Authorization, @Field("id_master_reward") String id_master_reward,
                                @Field("status") String status, @Field("poin_redeem") String poin_redeem);

    @FormUrlEncoded
    @POST("reward/get_reward")
    Call<ResponseBody> getList(@Header("Authorization") String Authorization, @Field("type_user") String type_user, @Field("type_reward") String type_reward);
}
