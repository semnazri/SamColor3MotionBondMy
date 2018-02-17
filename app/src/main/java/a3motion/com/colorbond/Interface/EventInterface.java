package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public interface EventInterface {

    @POST("event/get_event")
    Call<ResponseBody> getTasks(@Header("Authorization") String Authorization);
}
