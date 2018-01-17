package com.mrtro.mretrofittemplet;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mrtro.mretrofittemplet.databinding.ActivityMainBinding;
import com.mrtro.mretrofittemplet.model.login.GetAccount;
import com.mrtro.mretrofittemplet.model.login.Login;
import com.mrtro.mretrofittemplet.model.login.Signup;
import com.mrtro.mretrofittemplet.model.login.UserInfo;
import com.mrtro.mretrofittemplet.util.CommonUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mrtro.mretrofittemplet.AppBase.service;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.executePendingBindings();





        binding.loginId.setOnClickListener(this);
        binding.signupId.setOnClickListener(this);
        binding.finincialTrackingId.setOnClickListener(this);








        Map<String,String> map=new HashMap<>();
        map.put("U_Email","salman@gmail.com");
        map.put("U_Password","123456");


        /*
        Call<LoginModel> call=service.loginUser(map);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                try{
                   LoginModel loginModel=response.body();
                    if(loginModel!=null){
                        Gson gson0=new Gson();
                        String userJson0=gson0.toJson(loginModel.getAppUser());
                        Toast.makeText(getApplicationContext()," "+userJson0,Toast.LENGTH_LONG).show();

                        binding.setUser(userJson0);
                        if(loginModel.getSuccess()){
                            Gson gson=new Gson();
                            String userJson=gson.toJson(loginModel.getAppUser());
                            Toast.makeText(getApplicationContext(),"response : "+userJson,Toast.LENGTH_LONG).show();
                            binding.setUser(userJson);
                        }else {
                            Toast.makeText(getApplicationContext(),"invalid pass or user",Toast.LENGTH_LONG).show();
                            binding.setUser("invalid pass or user");
                        }
                    }else {

                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                        binding.setUser("invalid pass or user");
                    }


                }catch (Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });



*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==binding.loginId.getId()){
            if(CommonUtils.isNetworkAvailable(getApplicationContext())){
                logInUser();
            }else {
                Toast.makeText(getApplicationContext(),"No internet",Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==binding.signupId.getId()){
            if(CommonUtils.isNetworkAvailable(getApplicationContext())){
                signUpUser();
            }else {
                Toast.makeText(getApplicationContext(),"No internet",Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==binding.finincialTrackingId.getId()){
            if(CommonUtils.isNetworkAvailable(getApplicationContext())){
                getAccountList();
            }else {
                Toast.makeText(getApplicationContext(),"No internet",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void logInUser(){
        JsonObject jsonObjectLoginParam=new JsonObject()
                ;
        jsonObjectLoginParam.addProperty("api_key","SI1UJ2MA4IZ0YA");
        jsonObjectLoginParam.addProperty("email","ijaz@geniteam1.com");
        jsonObjectLoginParam.addProperty("password","123");
        jsonObjectLoginParam.addProperty("langauge","ar/en");

        Call<Login> call=service.loginUser(jsonObjectLoginParam);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Login login=response.body();

                if(login!=null){

                   // Toast.makeText(getApplicationContext()," "+s,Toast.LENGTH_LONG).show();
                    if(login.getStatusMessage().equals("200")){
                        Toast.makeText(getApplicationContext(),login.getStatusMessage(),Toast.LENGTH_LONG).show();
                        UserInfo userInfo=login.getUserInfo();
                        Gson gsonUser=new Gson();
                        String user=gsonUser.toJson(userInfo);
                        binding.setUser(user);
                        binding.executePendingBindings();

                    }else {
                        Toast.makeText(getApplicationContext(),login.getStatusMessage(),Toast.LENGTH_LONG).show();
                    }

                    Toast.makeText(getApplicationContext(),login.getStatusMessage(),Toast.LENGTH_LONG).show();

                    Gson gsonUser=new Gson();
                    String user=gsonUser.toJson(login);
                    Toast.makeText(getApplicationContext()," "+user,Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
/*{
"api_key": "SI1UJ2MA4IZ0YA",
"langauge" :"ar/en",
"user_id":"0",
"f_name": "james",
"password":"123",
 "l_name": "Bond",
 "email": "ijaz@geniteam.com",
 "phone_no":"+923444404160",
 "image_url":"base64image",
}
*/
    private void signUpUser(){
        JsonObject jsonObjectSignupParams=new JsonObject();
        jsonObjectSignupParams.addProperty("api_key","SI1UJ2MA4IZ0YA");
        jsonObjectSignupParams.addProperty("langauge","ar/en");
        jsonObjectSignupParams.addProperty("user_id","N");
        jsonObjectSignupParams.addProperty("f_name","james");

        jsonObjectSignupParams.addProperty("password","123");
        jsonObjectSignupParams.addProperty("l_name","Bondn");
        jsonObjectSignupParams.addProperty("email","ijaz@geniteam2.com");
        jsonObjectSignupParams.addProperty("phone_no","+923444404160");
        jsonObjectSignupParams.addProperty("image_url","base64image");


       Call<Signup> call=service.singnUpUser(jsonObjectSignupParams);
       // Call<Signup> call=service.signUpFormUrlEncoded("SI1UJ2MA4IZ0YA","ar/en","0","123","Bond", "ijaz@geniteam.com","+923444404160","base64image","jj");


        call.enqueue(new Callback<Signup>() {
            @Override
            public void onResponse(Call<Signup> call, Response<Signup> response) {
                try{
                    Signup signup=response.body();
                    if (signup!=null){
                   if(signup.getStatusCode().equals("200")){
    Toast.makeText(getApplicationContext()," "+signup.getStatusMessage(),Toast.LENGTH_LONG).show();
                       UserInfo userInfo=signup.getUserInfo();
                       Gson gsonUser=new Gson();
                       String user=gsonUser.toJson(userInfo);
                       binding.setUser(user);
                       binding.executePendingBindings();
                       }else {
                       Toast.makeText(getApplicationContext()," "+signup.getStatusMessage(),Toast.LENGTH_LONG).show();

                   }

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Signup> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fail ",Toast.LENGTH_LONG).show();

            }
        });

    }


    private void getAccountList(){
        /*{
"api_key": "SI1UJ2MA4IZ0YA",
"user_id": "1",
"langauge" :"ar/en",
}
*/
        JsonObject jsonObjectAccountParams=new JsonObject();
        jsonObjectAccountParams.addProperty("api_key","SI1UJ2MA4IZ0YA");
        jsonObjectAccountParams.addProperty("user_id","1");
        jsonObjectAccountParams.addProperty("langauge","ar/en");

        Call<GetAccount> call=service.GET_ACCOUNT_CALL(jsonObjectAccountParams);

        call.enqueue(new Callback<GetAccount>() {
            @Override
            public void onResponse(Call<GetAccount> call, Response<GetAccount> response) {
                try{
                    GetAccount getAccount=response.body();
                    if(getAccount!=null){
                        Gson gson=new Gson();
                        String accountJsonStr=gson.toJson(getAccount);
                        Toast.makeText(getApplicationContext(),accountJsonStr,Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();

                    }


                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GetAccount> call, Throwable t) {

            }
        });
    }
}
