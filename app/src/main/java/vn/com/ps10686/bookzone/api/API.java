package vn.com.ps10686.bookzone.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.com.ps10686.bookzone.Model.NguoiDung;
import vn.com.ps10686.bookzone.Model.Sach1;

public interface API {
    @GET ("/allSach")
    Call<List<Sach1>> getSach();
     @FormUrlEncoded
    @POST ("/dangKy")
    Call<Void>dangKy(@Field("tenNguoiDung") String userName, @Field("email") String email,  @Field("matKhau")String userPass);
     @FormUrlEncoded
     @POST ("/dangNhap")
    Call<NguoiDung>dangNhap(@Field("tenNguoiDung") String userName, @Field("matKhau")String userPass);
}
