package com.mrtro.mretrofittemplet.ws;


import com.mrtro.mretrofittemplet.util.AppConst;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*import okhttp3.logging.HttpLoggingInterceptor;*/


public class ServiceGenerator {


    static OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(AppConst.baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);

    }

}
