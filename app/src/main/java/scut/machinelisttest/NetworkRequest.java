package scut.machinelisttest;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 封装网络请求的类，目前是使用Retrofit框架配合Gson解析
 */
public class NetworkRequest {
    public static final String API_URL_Search = "http://218.192.170.132:8000";
    private Gson gson = new Gson();
    private Search_Machine search_Machine_Result;

    //将json数据解析为MachinePostData类
    public MachinePostData StringToMachinePostData(String str){
        MachinePostData MD = gson.fromJson(str,MachinePostData.class);
        System.out.println(MD.getProductType()+MD.getFireproofing());
        return MD;
    }

    //将MachinePostData类包装为一个Okhttp的POST请求
    public RequestBody MachinePostDataToBody(MachinePostData machinePostData){
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        String jsonStr = gson.toJson(machinePostData);
        System.out.println(jsonStr);
        RequestBody Body=RequestBody.create(JSON,jsonStr);
        return Body;
    }

    //将输入的POST请求进行处理发送后返回一个装着数据的Search_Machine类，注意这个是异步的返回，有延时的，所以我没有在主线程使用它，放这里备用。
    public Search_Machine requestSearch_Machine(RequestBody body){

        System.out.println("成功Body"+(body != null));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL_Search)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchService searchService = retrofit.create(SearchService.class);
        Call<Search_Machine> call = searchService.getCall(body);
        call.enqueue(new Callback<Search_Machine>() {
            @Override
            public void onResponse(Call<Search_Machine> call, Response<Search_Machine> response) {
                if (response.isSuccessful()) {
                    System.out.println("返回成功回应");
                    System.out.println(response.body().getData().get(0).getAddress());
                }else {
                    System.out.println("返回失败回应");
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                search_Machine_Result = response.body();
            }

            @Override
            public void onFailure(Call<Search_Machine> call, Throwable t) {
                System.out.println("请求失败");
                search_Machine_Result = null;
            }
        });

        return search_Machine_Result;
    }

    //将输入的POST请求进行处理发送后返回一个Callback对象，这个Callback对象可以把根据异步返回结果回调到主线程，所以使用这个方法。
    public Callback<Search_Machine> requestSearch_MachineCallback(RequestBody body,Callback<Search_Machine> callback){
        System.out.println("成功Body"+(body != null));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL_Search)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchService searchService = retrofit.create(SearchService.class);
        Call<Search_Machine> call = searchService.getCall(body);
        call.enqueue(callback);
        return callback;
    }
}
