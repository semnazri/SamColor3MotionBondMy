package a3motion.com.colorbond.Presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.RegisterInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
import a3motion.com.colorbond.POJO.RegisterResponse;
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
 * mr.shanky08@gmail.com on 09/03/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class RegisterInteractorImp implements RegisterInteractor {
    String response_message;

    @Override
    public void doRegister(String email, String fristname, String lastname, String Username, String address, String proffesion, String phone, String DOB, String Gender, String company, String Type, String Typeuser, String image, String password, String title, String repass, final OnSuccessgetRegisterListener listener) {

        boolean error = false;

        if (TextUtils.isEmpty(email)) {
            listener.onEmailError();
            error = true;
        } else if (!email.contains("@")) {
            listener.onEmailInValid();
            error = true;

        }

        if (TextUtils.isEmpty(Username)) {
            listener.OnUsernameError();
            error = true;
        }

        if (TextUtils.isEmpty(proffesion)) {
            listener.onProffesionError();
            error = true;
        }

        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            error = true;

        } else if (password.length() < 6) {
            listener.onPasswordInValid();
            error = true;

        }

        if (TextUtils.isEmpty(repass)) {
            listener.onRePassError();
            error = true;

        }

        if (!repass.equals(password)) {
            listener.onRePassInvalid();
            error = true;

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
                    .baseUrl(APICONSTANT.API_Parent)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


            RegisterInterface service = retrofit.create(RegisterInterface.class);


            final Call<ResponseBody> call = service.doRegisterUser(fristname, lastname, Username, address, email, password, phone, DOB, Gender, company, Type, Typeuser, image);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        try {
                            RegisterResponse registerResponse = gson.fromJson(response.body().string(), RegisterResponse.class);
                            listener.onSuccess(response_message, registerResponse);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {

                        switch (response.code()) {

                            //TODO ini tolong contextnya di benerin
                            case 400:
                                listener.onelseError(response.message());
                            case 401:
                                listener.onelseError(response.message() + " 401");
                                break;
                            case 404:
                                listener.onelseError(response.message() + " Cannot find the right path! Response code 404");
                                break;
                            case 500:
                                listener.onelseError(response.message() + " Server is broken! Response code 500");
                                break;
                            default:
                                listener.onelseError(response.message());
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
