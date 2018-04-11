package a3motion.com.colorbond.Presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.UserInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
import a3motion.com.colorbond.POJO.ChangePassResponse;
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
 * mr.shanky08@gmail.com on 15/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class ForgotPassInteractorImp implements ForgotPassInteractor {
    String response_message;


    @Override
    public void doChangePassword(String email, final onSuccessForgotPassListener listener) {

        boolean error = false;

        if (TextUtils.isEmpty(email)) {
            listener.onEmailError();
        }

        if (!email.contains("@")) {
            listener.onEmailinvalid();
        }

        if (!error) {
            listener.onValid();

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
                    .baseUrl(APICONSTANT.API_Parent_forgot)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


            UserInterface service = retrofit.create(UserInterface.class);


            final Call<ResponseBody> call = service.doForgot(email);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        try {
                            ChangePassResponse changePassResponse = gson.fromJson(response.body().string(), ChangePassResponse.class);
                            listener.onSuccess(response_message, changePassResponse);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {

                        switch (response.code()) {

                            //TODO ini tolong contextnya di benerin

                            case 401:
                                listener.onElseError(response.message() + " 401");
                                break;
                            case 404:
                                listener.onElseError(response.message() + " Cannot find the right path! Response code 404");
                                break;
                            case 500:
                                listener.onElseError(response.message() + " Server is broken! Response code 500");
                                break;
                            default:
                                listener.onElseError(response.message());
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
}
