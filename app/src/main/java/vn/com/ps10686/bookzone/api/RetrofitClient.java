package vn.com.ps10686.bookzone.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

//    public static final String ROOT_URL = "http://192.168.0.118:1996/";


    public static final String ROOT_URL = "http://172.20.10.4:1996/";

    public static final String ROOT_URL2 = "http://192.168.0.104:1996/";

    //Khoa IP
    public static final String ROOT_URL3 = "http://192.168.0.106:1996/";
    //IP nhà Khoa
    public static final String ROOT_URL4 = "http://192.168.1.8:1996/";


    public static Retrofit retrofit = null;

    public static Retrofit getClien(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(ROOT_URL4)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
