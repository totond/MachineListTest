package scut.machinelisttest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface SearchService {
    @POST("http://218.192.170.132:8000/commodity/search")
    Call<Search_Machine> getCall(@Body RequestBody body);
}