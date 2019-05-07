package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //使用Retrofit 封装的方法
        request();

    }


    private void request() {

//http://fy.iciba.com/ajax.php?a=fy&f=auto&t=auto&w=hello%20world
        //创建Retrofit 对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")  //设置网络请求url
        .addConverterFactory(GsonConverterFactory.create())  // 设置使用Gson 解析
        .build();

        //步骤5：创建网络请求接口实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //对发送请求进行封装
      //  Call<Translation> call = request.getCall();

        request.getCall().enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                response.body().show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.println("连接失败");

                System.out.println(t.getMessage());
            }
        });

        //步骤6 发送网络请求(异步)
//        call.enqueue(new Callback<Translation>() {
//            //请求成功时回调
//            @Override
//            public void onResponse(Call<Translation> call, Response<Translation> response) {
//              //步骤7：处理返回的数据结果
//                response.body().show();
//
//            }
//
//            //请求失败时 回调
//            @Override
//            public void onFailure(Call<Translation> call, Throwable t) {
//                System.out.println("连接失败");
//
//                System.out.println(t.getMessage());
//
//            }
//        });

 }
}
