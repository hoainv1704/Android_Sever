package vn.com.ps10686.bookzone.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.com.ps10686.bookzone.Model.BinhLuan;
import vn.com.ps10686.bookzone.Model.CauHoi;
import vn.com.ps10686.bookzone.Model.HDFTraVe;
import vn.com.ps10686.bookzone.Model.HoaDon;
import vn.com.ps10686.bookzone.Model.HoaDonFinal;
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
     //Cập nhât sở thích trong survey
    @FormUrlEncoded
    @POST ("/capNhatSoThich")
    Call<Void>capNhatSoThich(@Field("tenNguoiDung") String userName, @Field("tag1") String tag1, @Field("tag2") String tag2);
    //Đổi mật khẩu qua Dialog
    @FormUrlEncoded
    @POST ("/doiMatKhau")
    Call<Void>doiMatKhau(@Field("tenNguoiDung") String userName, @Field("matKhau")String userPass, @Field("matKhauMoi")String matKhauMoi);

     @FormUrlEncoded
     @POST ("/chitietsach")
    Call<Sach1>chitietsach(@Field("_id")String _id);

     @FormUrlEncoded
    @POST ("/addBL")
    Call<Void>addBL(@Field("ndBL") String ndBL, @Field("tenNguoiDung") String _idND, @Field("maSach") String _id);

    @FormUrlEncoded
    @POST ("/bl")
    Call<List<BinhLuan>> getBL(@Field("maSach")String _id);

    @FormUrlEncoded
    @POST ("/cauhois")
    Call<List<CauHoi>> getCH(@Field("maSach")String _id);

    @FormUrlEncoded
    @POST ("/hoadonfinal")
    Call<Void>themHD(@Field("tenNguoiDung") String tenNguoiDung, @Field("hoaDon")List<HoaDonFinal> hoaDonFinals,@Field("giaTien")Float giaTien );

    @FormUrlEncoded
    @POST ("/getCTL")
    Call<CauHoi>getCTL(@Field("maSach")String maSach,@Field("cauHoi")String cauHoi);

    @FormUrlEncoded
    @POST ("/getAllHD")
    Call<List<String>>getAllHD(@Field("tenNguoiDung")String tenNguoiDung);

}

