package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request();
    }

    //http://fanyi.youdao.com/translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=

    private void request() {
        // 步骤4： 创建Retrofit 对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")  //设置网络请求 url
                .addConverterFactory(GsonConverterFactory.create())  //设置使用Gson 解析
                .build();

        //步骤5： 创建网络请求接口的实例
        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);


        //对发送请求 进行封装（需要设置翻译内容）
        Call<Translation1>  call = request.getCall("I Love You");

        //步骤6：
         call.enqueue(new Callback<Translation1>() {

             //请求成功时回调
             @Override
             public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                 //请求处理， 输出结果
                 //输出翻译的内容
                 System.out.println("翻译是：" + response.body().getTranslateResult().get(0).get(0).getTgt());

             }

             //请求回调失败
             @Override
             public void onFailure(Call<Translation1> call, Throwable t) {

                 System.out.println("请求失败");
                 System.out.println(t.getMessage());
             }
         });


    }


}
