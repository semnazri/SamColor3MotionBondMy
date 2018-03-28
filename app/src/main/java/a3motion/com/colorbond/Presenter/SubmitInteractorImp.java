package a3motion.com.colorbond.Presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a3motion.com.colorbond.Interface.SubmitInterface;
import a3motion.com.colorbond.Network.APICONSTANT;
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

public class SubmitInteractorImp implements SubmitInteractor {
    String response_message;

    @Override
    public void doSubmit(String token, String project_name, String project_type, String date_project, String location, String building_category, String quantity, String size_category, String material_1, String material_2, String delivery_img, String suport_img, final OnSuccessSubmitListener listener) {
        boolean error = false;

        if (TextUtils.isEmpty(project_name)) {
            listener.OnProject_nameError();
            error = true;
        }
        if (TextUtils.isEmpty(date_project)) {
            listener.onDate_projectError();
            error = true;
        }
        if (TextUtils.isEmpty(location)) {
            listener.onLocationError();
            error = true;
        }
        if (TextUtils.isEmpty(quantity)) {
            listener.OnquantitiyError();
            error = true;
        }

        if (TextUtils.isEmpty(delivery_img)) {
            listener.OnDeliveryNoteError();
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


            SubmitInterface service = retrofit.create(SubmitInterface.class);

            final Call<ResponseBody> call = service.doSubmitProject(token, project_name, project_type, date_project, location, building_category, quantity, size_category, material_1, material_2, delivery_img, suport_img);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        try {
                            SubmitResponse submitResponse = gson.fromJson(response.body().string(), SubmitResponse.class);
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
}
