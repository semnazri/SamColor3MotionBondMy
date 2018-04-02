package a3motion.com.colorbond.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InspirasiInterface {


    @POST("inspirasi/get_inspirasi")
    Call<ResponseBody> getInspirasi(@Header("Authorization") String Authorization);
}
