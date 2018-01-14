package com.mrtro.mretrofittemplet.ws;

import com.mrtro.mretrofittemplet.model.login.LoginModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WebService {


    @GET("Login")
    Call<LoginModel> loginUser(@QueryMap Map<String, String> options);


/**
    @POST(AppConst.Update_Profile)
    Call<LoginModel>postUpdateprofile(@Field(AppConst.U_FullName) String name,
                                      @Field(AppConst.U_Email) String email,
                                      @Field(AppConst.U_Password) String password,
                                      @Field(AppConst.U_DeviceToken) String token,
                                      @Field(AppConst.U_DeviceType) String devictype,
                                      @Field(AppConst.U_Image) String image);

    @FormUrlEncoded
    @POST(AppConst.KeySignup)
    Call<SignUpModel>postSignupUser(@Field(AppConst.U_FullName) String name,
                                    @Field(AppConst.U_Email) String email,
                                    @Field(AppConst.U_Password) String password,
                                    @Field(AppConst.U_DeviceToken) String token,
                                    @Field(AppConst.U_DeviceType) String devictype,


                                    @Field(AppConst.U_Image) String image);

                                    */
}
