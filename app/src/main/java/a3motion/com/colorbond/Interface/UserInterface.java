package a3motion.com.colorbond.Interface;

import a3motion.com.colorbond.POJO.Auth;
import retrofit2.Call;
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

    @POST("token")
    Call<Auth> getTasks(@Header("Authorization") String Authorization);

}
