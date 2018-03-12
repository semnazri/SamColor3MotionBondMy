package a3motion.com.colorbond.Presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.EditProfileInterface;
import a3motion.com.colorbond.Interface.EventInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
import a3motion.com.colorbond.POJO.EditProfileResponse;
import a3motion.com.colorbond.Utility.BlueScoopPreferences;
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

public class EditProfileInteractorImp implements EditProfileInteractor {
    String response_message;
    private SharedPreferences prefsprivate;
    @Override
    public void doEdit(String token,String username, String fristname, String lastname, String DOB, String email, String company, String phone, String gender, final OnSuccessEditProfileListener listener) {

        boolean error = false;

        if (TextUtils.isEmpty(username)) {
            listener.OnUsernameError();
            error = true;
        }
        if (TextUtils.isEmpty(fristname)) {
            listener.OnFirstnameError();
            error = true;
        }
        if (TextUtils.isEmpty(lastname)) {
            listener.OnLastnameError();
            error = true;
        }

        if (TextUtils.isEmpty(DOB)) {
            listener.onDOBError();
            error = true;
        }

        if (TextUtils.isEmpty(email)) {
            listener.onEmailError();
            error = true;
        } else if (!email.contains("@")) {
            listener.onEmailInValid();
            error = true;

        }

        if (TextUtils.isEmpty(company)) {
            listener.OnCompanynameError();
            error = true;
        }

        if (TextUtils.isEmpty(company)) {
            listener.onPoneError();
            error = true;
        }

        if (TextUtils.isEmpty(gender)) {
            listener.onGenderError();
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


            EditProfileInterface service = retrofit.create(EditProfileInterface.class);

            final Call<ResponseBody> call = service.getTasks(token,username,fristname,lastname,DOB,email,company,phone,gender);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        try {
                            EditProfileResponse eventResponse = gson.fromJson(response.body().string(), EditProfileResponse.class);
                            listener.onSuccess(response_message, eventResponse);

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
}
