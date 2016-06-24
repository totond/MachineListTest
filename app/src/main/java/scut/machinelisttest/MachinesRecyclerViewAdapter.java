package scut.machinelisttest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yany on 2016/5/6.
 */
public class MachinesRecyclerViewAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private ArrayList<HashMap<String, Object>> listItem;
    private MyItemClickListener myItemClickListener;

    public MachinesRecyclerViewAdapter(Context context, ArrayList<HashMap<String, Object>> listItem) {
        inflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }//构造函数，传入数据


    //定义Viewholder
    class Viewholder extends RecyclerView.ViewHolder {
        //        private View root;
        private TextView name, address, lowerest_wholesale_number, price;
        private ImageView picture;

        public Viewholder(View root) {
            super(root);
            name = (TextView) root.findViewById(R.id.Machines_Recyclerview_Item_name);
            address = (TextView) root.findViewById(R.id.Machines_Recyclerview_Item_address);
            lowerest_wholesale_number = (TextView) root.findViewById(R.id.Machines_Recyclerview_Item_lowerest_wholesale_number);
            price = (TextView) root.findViewById(R.id.Machines_Recyclerview_Item_price);
            picture = (ImageView) root.findViewById(R.id.Machines_Recyclerview_Item_picture);
                root.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View v) {
                                            if (myItemClickListener != null)
                                                myItemClickListener.onItemClick(v, getPosition());
                                        }

                                    }
            );

        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(inflater.inflate(R.layout.machines_recyclerview_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //设置数据显示
        Viewholder vh = (Viewholder) holder;
        vh.name.setText((String) listItem.get(position).get("ItemMachinceName"));
        vh.address.setText((String) listItem.get(position).get("ItemMachinceAddress"));
        vh.lowerest_wholesale_number.setText(listItem.get(position).get("ItemMachinceLowerest_wholesale_number").toString());
        vh.price.setText("￥" + listItem.get(position).get("ItemMachincePrice").toString());

//        vh.picture.setImageResource((Integer) listItem.get(position).get("ItemImage"));
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void setOnItemClickListener(MyItemClickListener listener) {
        myItemClickListener = listener;
    }
}

