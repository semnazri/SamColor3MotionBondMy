package a3motion.com.colorbond.Presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.NotificationInterface;
import a3motion.com.colorbond.Interface.SubmitInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
import a3motion.com.colorbond.POJO.RegisterResponse;
import a3motion.com.colorbond.POJO.SubmitResponse;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Semmy
 * mr.shanky08@gmail.com on 17/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ApproveInteractorImp implements ApproveInteractor {
    String response_message;

    @Override
    public void doAPprove(String token, String id_notif, final OnSuccessApproveListener listener) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APICONSTANT.API_Parent)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        NotificationInterface service = retrofit.create(NotificationInterface.class);

        final Call<ResponseBody> call = service.APPROVE(token, id_notif);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    try {
                        RegisterResponse submitResponse = gson.fromJson(response.body().string(), RegisterResponse.class);
                        listener.onSuccess(response_message, submitResponse);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    switch (response.code()) {

                        //TODO ini tolong contextnya di benerin

                        case 401:
                            listener.onelseError("Oops! Account Expired, please Re-Login! 401");
                            break;
                        case 404:
                            listener.onelseError("Cannot find the right path! Response code 404");
                            break;
                        case 500:
                            listener.onelseError("Server is broken! Response code 500");
                            break;
                        default:
                            listener.onelseError("Oops! Something went Wrong");
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                android.util.Log.d("onFailure", t.toString());
            }
        });

    }

}
