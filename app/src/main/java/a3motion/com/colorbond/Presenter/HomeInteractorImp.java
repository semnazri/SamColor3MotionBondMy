package a3motion.com.colorbond.Presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.HomeInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
import a3motion.com.colorbond.POJO.HomeResponse;
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
 * mr.shanky08@gmail.com on 18/02/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class HomeInteractorImp implements HomeInteractor {
    String response_message;

    @Override
    public void getHome(String token, final OnSuccessgetHomeListener listener) {
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


        HomeInterface service = retrofit.create(HomeInterface.class);


        final Call<ResponseBody> call = service.getTasks(token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    try {
                        HomeResponse homeResponse = gson.fromJson(response.body().string(), HomeResponse.class);
                        listener.onSuccess(response_message, homeResponse);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    switch (response.code()) {

                        //TODO ini tolong contextnya di benerin

                        case 401:
                            listener.onelseError("Wrong Email or Password!");
                            break;
                        case 404:
                            listener.onelseError("Cannot find the right path! Response code 404");
                            break;
                        case 500:
                            listener.onelseError("Server is broken! Response code 500");
                            break;
                        default:
                            listener.onelseError("Wrong Email or Password!");
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
