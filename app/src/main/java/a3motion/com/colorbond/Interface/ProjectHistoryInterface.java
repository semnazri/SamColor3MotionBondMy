package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 24/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface ProjectHistoryInterface {

    @POST("project/history")
    Call<ResponseBody> getProjectHistory(@Header("Authorization") String Authorization);

    @POST("myachievment/get_achievment")
    Call<ResponseBody> getAchievement(@Header("Authorization") String Authorization);
}
