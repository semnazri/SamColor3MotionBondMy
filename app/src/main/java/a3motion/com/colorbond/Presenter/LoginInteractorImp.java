package a3motion.com.colorbond.Presenter;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.UserInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
import a3motion.com.colorbond.POJO.Auth;
import a3motion.com.colorbond.POJO.EditProfileResponse;
import a3motion.com.colorbond.POJO.PayloadJSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
 * mr.shanky08@gmail.com on 07/01/18.
 *
 * @copyright 2016
 * PT.Bisnis Indonesia Sibertama
 */

public class LoginInteractorImp implements LoginInteractor {
    String response_message, type, token, fristname, lastname, emailz, phone, company, title, point, username;

    @Override
    public void login(String email, String password, String img, final OnLoginFinishedListener listener) {
        boolean error = false;
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
                    .baseUrl(APICONSTANT.API_Auth)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            Gson g2 = new Gson();
            String payloadsx = g2.toJson(new PayloadJSON(email, password));
            String headerZ = "S1Bi28DLuGeD1R14YY7cYckS2yul4lc3";
            final String header = Base64.encodeToString(headerZ.getBytes(), Base64.NO_WRAP).replace("\n", "");
            UserInterface service = retrofit.create(UserInterface.class);
            String compactJws = Jwts.builder()
                    .setHeaderParam("typ", "JWT")
                    .setPayload(payloadsx)
                    .signWith(SignatureAlgorithm.HS512, header)
                    .compact();

            Call<ResponseBody> call = service.getTasks(compactJws, img);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {

                        Gson gson = new Gson();
                        try {
                            Auth auth = gson.fromJson(response.body().string(), Auth.class);
                            listener.onSuccess(response_message, auth);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {

                        switch (response.code()) {

                            //TODO ini tolong contextnya di benerin

                            case 401:
                                listener.onelseError("OOPS! Wrong Email or Password! or Maybe your account Not Approved yet! ");
                                break;
                            case 404:
                                listener.onelseError("Cannot find the right path! Response code 404");
                                break;
                            case 500:
                                listener.onelseError("Internal Server Error");
                                break;
                            default:
                                listener.onelseError("OOPS! Wrong Email or Password! or Maybe your account Not Approved yet! ");
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
