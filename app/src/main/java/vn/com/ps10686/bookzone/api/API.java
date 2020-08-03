package vn.com.ps10686.bookzone.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.com.ps10686.bookzone.Model.Sach1;

public interface API {
    @GET ("/sach")
    Call<List<Sach1>> getSach();
}
