package com.mrtro.mretrofittemplet;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mrtro.mretrofittemplet.databinding.ActivityMainBinding;
import com.mrtro.mretrofittemplet.ws.ServiceGenerator;
import com.mrtro.mretrofittemplet.model.login.LoginModel;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mrtro.mretrofittemplet.AppBase.service;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.executePendingBindings();
        Map<String,String> map=new HashMap<>();
        map.put("U_Email","salman@gmail.com");
        map.put("U_Password","123456");

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

    }
}
