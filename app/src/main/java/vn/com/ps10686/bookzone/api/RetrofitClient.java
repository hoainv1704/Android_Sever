package vn.com.ps10686.bookzone.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String ROOT_URL = "http://192.168.0.104:1996/";

    public static Retrofit retrofit = null;

    public static Retrofit getClien(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
