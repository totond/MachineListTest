package scut.machinelisttest;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements MyItemClickListener{
    private RecyclerView Rv;
    private ArrayList<HashMap<String,Object>> listItem;
    private MachinesRecyclerViewAdapter mGSRVadapter;

    private String jsonData = null;
    private NetworkRequest mNetworkRequest;
    private Search_Machine search_Machine_Result;
    private MachinePostData machinePostData;
    private Callback<Search_Machine> mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machines_list);
        initRequest();      //初始化请求
//        search_Machine_Result = mNetworkRequest.requestSearch_Machine(mNetworkRequest.MachinePostDataToBody(machinePostData));

    }

    public void initMachinesData(){
        listItem = new ArrayList<HashMap<String, Object>>();//把请求返回的search_Machine_Result里面的数据放入数组
        for (int i = 0; i < search_Machine_Result.getData().size(); i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemMachinceName", search_Machine_Result.getData().get(i).getName() );
            map.put("ItemMachinceAddress",search_Machine_Result.getData().get(i).getAddress());
            map.put("ItemMachinceLowerest_wholesale_number",search_Machine_Result.getData().get(i).getLowerestWholesale());
            map.put("ItemMachincePrice",search_Machine_Result.getData().get(i).getPrice());
            map.put("ItemMachincePicture",search_Machine_Result.getData().get(i).getPicture());

            listItem.add(map);
        }
    }

    public void initMachinesView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        Rv = (RecyclerView) findViewById(R.id.Goodslist_RecyclerView);      //绑定
        mGSRVadapter = new MachinesRecyclerViewAdapter(this,listItem);
        mGSRVadapter.setOnItemClickListener(this);
        Rv.setLayoutManager(layoutManager);
        Rv.setHasFixedSize(true);
        Rv.setAdapter(mGSRVadapter);

    }

    public void initRequest(){
        //用于测试的json数据
        jsonData = "{\n" +
                "  \"requestType\": \"Search\",\n" +
                "  \"productType\": \"电子电器零件\",\n" +
                "  \"material\": \"ABS\",\n" +
                "  \"crumble\": \"不添加\",\n" +
                "  \"CaCo3\": \"不添加\",\n" +
                "  \"fiberglass\": \"15%以下\",\n" +
                "  \"fireproofing\": \"一般防火\",\n" +
                "  \"color\": \"色粉\",\n" +
                "  \"productWeight\": 23.4,\n" +
                "  \"productLength\": 12.2,\n" +
                "  \"productWidth\": 11.2,\n" +
                "  \"productHeight\": 23.2,\n" +
                "  \"wallThickness\": 3.2,\n" +
                "  \"moduleLength\": 1.1,\n" +
                "  \"moduleWidth\": 2.2,\n" +
                "  \"moduleHeight\": 3.3,\n" +
                "  \"ejector\": \"拉伸\",\n" +
                "  \"locatingRing\": 4.4,\n" +
                "  \"screw\": \"A\",\n" +
                "  \"power\": \"油压\"\n" +
                "}\n";

        mNetworkRequest = new NetworkRequest();
        machinePostData = mNetworkRequest.StringToMachinePostData(jsonData);
        mCallback = new Callback<Search_Machine>() {
            @Override
            public void onResponse(Call<Search_Machine> call, Response<Search_Machine> response) {
                if (response.isSuccessful()) {
                    System.out.println("返回成功回应");
                    System.out.println(response.body().getData().get(0).getAddress());
                    search_Machine_Result = response.body();
                    initMachinesData();
                    initMachinesView();
                }else {
                    System.out.println("返回失败回应");
                    try {
                        System.out.println(response.errorBody().string());
                        dialogMachineNotFound();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Search_Machine> call, Throwable t) {
                System.out.println("请求失败");
                search_Machine_Result = null;
                dialogNetworkWarning();
            }
        };
        mCallback = mNetworkRequest.requestSearch_MachineCallback(mNetworkRequest.MachinePostDataToBody(machinePostData),mCallback);
    }

    @Override
    public void onItemClick(View view, int postion) {

    }

    protected void dialogNetworkWarning() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("网络异常，请检查你的网络连接");

        builder.setTitle("提示");

        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();


            }
        });

        builder.setNegativeButton("重试", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    protected void dialogMachineNotFound() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("暂时找不到你需求的注塑机，若需个性化制定请致电：020-88888888");

        builder.setTitle("提示");

        builder.setPositiveButton("返回", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        builder.create().show();
    }
}
