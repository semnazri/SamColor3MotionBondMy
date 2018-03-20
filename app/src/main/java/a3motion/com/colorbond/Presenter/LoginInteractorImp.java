package a3motion.com.colorbond.Presenter;

import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.UserInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
import a3motion.com.colorbond.POJO.Auth;
import a3motion.com.colorbond.POJO.PayloadJSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import okhttp3.OkHttpClient;
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

public class LoginInteractorImp implements LoginInteractor{
    String response_message,type,token, fristname, lastname, emailz, phone, company, title, point;

    @Override
    public void login(String email, String password,String img, final OnLoginFinishedListener listener) {

        boolean error = false;


        if (TextUtils.isEmpty(email)) {
            listener.onEmailError();
            error = true;

        } else if (!email.contains("@")) {
            listener.onEmailInValid();
            error = true;

        }

        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            error = true;

        } else if (password.length() < 6) {
            listener.onPasswordInValid();
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

            Call<Auth> call = service.getTasks(compactJws,img);
            call.enqueue(new Callback<Auth>() {
                @Override
                public void onResponse(Call<Auth> call, Response<Auth> response) {

                    if (response.isSuccessful()) {
                        response_message = response.body().getResponse();
                        type = response.body().getType();
                        token = response.body().getToken();
                        fristname = response.body().getUsername();
//                        lastname = response.body().getName();//TODO nanti di join aja
                        emailz = response.body().getEmail();
                        phone = response.body().getPhone();
                        company = response.body().getCompany();
//                        title = response.body().getTitle();
                        point = response.body().getPoin();

                        listener.onSuccess(response_message,type,token,fristname,emailz,phone,company,title,point);

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
                public void onFailure(Call<Auth> call, Throwable t) {
                    android.util.Log.d("onFailure", t.toString());
                }
            });


        }

    }
}
