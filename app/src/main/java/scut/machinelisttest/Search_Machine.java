package scut.machinelisttest;

import java.util.List;

/**
 用来装POST搜索请求后返回的json数据的JavaBean
 */
public class Search_Machine {
    private List<Data> data ;

    private int total;

    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }

 static class Data {
        private String picture;

        private int price;

        private String address;

        private String name;

        private int lowerestWholesale;

        public void setPicture(String picture){
            this.picture = picture;
        }
        public String getPicture(){
            return this.picture;
        }
        public void setPrice(int price){
            this.price = price;
        }
        public int getPrice(){
            return this.price;
        }
        public void setAddress(String address){
            this.address = address;
        }
        public String getAddress(){
            return this.address;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setLowerestWholesale(int lowerestWholesale){
            this.lowerestWholesale = lowerestWholesale;
        }
        public int getLowerestWholesale(){
            return this.lowerestWholesale;
        }

    }
}
