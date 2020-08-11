package vn.com.ps10686.bookzone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Adapter.BinhLuanAdapter;
import vn.com.ps10686.bookzone.Adapter.CauHoiAdapter;
import vn.com.ps10686.bookzone.Model.BinhLuan;
import vn.com.ps10686.bookzone.Model.NguoiDung;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.SachFragment;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

import static vn.com.ps10686.bookzone.Activity.MainActivity.saved_user;
import static vn.com.ps10686.bookzone.Activity.MainActivity.username;
import static vn.com.ps10686.bookzone.SachFragment.bls;
import static vn.com.ps10686.bookzone.SachFragment.chs;
import static vn.com.ps10686.bookzone.api.RetrofitClient.ROOT_URL;
import static vn.com.ps10686.bookzone.api.RetrofitClient.ROOT_URL4;

public class ChiTietSach extends AppCompatActivity {

   public ImageView imvHinh;
   public TextView tvTenSach,tvTenLoai,tvNhaXB,tvNamXB,tvTaiBan,tvTacGia;
   ListView lvCauHoi;
   Button btnBL;
   EditText edtBL;
   BinhLuanAdapter binhLuanAdapter;
   CauHoiAdapter cauHoiAdapter;
   LinearLayoutManager linearLayoutManager;
   public RecyclerView rcvBL;
   RetrofitClient retrofitClient;
   String tenSach, tenLoai, tacGia, nhaXB, namXB, taiBan, hinh, _id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sach);

        Map();
        linearLayoutManager = new LinearLayoutManager(this);
        rcvBL.setLayoutManager(linearLayoutManager);

        cauHoiAdapter = new CauHoiAdapter(chs,this , R.layout.row_cauhoi);
        lvCauHoi.setAdapter(cauHoiAdapter);

        binhLuanAdapter = new BinhLuanAdapter(ChiTietSach.this, bls);
        rcvBL.setAdapter(binhLuanAdapter);

        binhLuanAdapter.notifyDataSetChanged();

        Bundle bundle = getIntent().getBundleExtra("chitietsach");
        tenSach = bundle.getString("tenSach");
        tenLoai = bundle.getString("tenLoai");
        tacGia = bundle.getString("tacGia");
        nhaXB = bundle.getString("nhaXB");
        namXB = bundle.getString("namXB");
        taiBan = bundle.getString("taiBan");
        hinh = bundle.getString("hinh");
        _id = bundle.getString("_id");

        tvTenSach.setText("Tên sách: "+tenSach);
        tvTacGia.setText("Tác giả: "+tacGia);
        tvTenLoai.setText("Loại sách: " +tenLoai);
        tvNhaXB.setText("Nhà xuất bản: "+nhaXB);
        tvNamXB.setText("Năm xuất bản: "+ namXB);
        tvTaiBan.setText("Tái bản: " +taiBan);
        Picasso.with(this)
                .load(ROOT_URL4 + hinh.substring(7))
                .into(imvHinh);

        btnBL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBL();
            }
        });
    }

    public void Map(){
        imvHinh = findViewById(R.id.imv_hinh);
        tvTenSach = findViewById(R.id.cts_ten_sach);
        tvTenLoai = findViewById(R.id.cts_loai_sach);
        tvNhaXB = findViewById(R.id.cts_nxb);
        tvNamXB = findViewById(R.id.cts_namxb);
        tvTaiBan = findViewById(R.id.cts_taiban);
        tvTacGia = findViewById(R.id.cts_tacgia);
        rcvBL = findViewById(R.id.rcvBL);
        btnBL = findViewById(R.id.btnBL);
        edtBL = findViewById(R.id.edtNewBL);
        lvCauHoi = findViewById(R.id.lvCauHoi);
    }

    public void addBL (){
        API api = retrofitClient.getClien().create(API.class);
        api.addBL(edtBL.getText().toString(), saved_user, _id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200){

                    Toast.makeText(ChiTietSach.this, "Đã thêm bl", Toast.LENGTH_SHORT).show();
                    edtBL.setText("");
                }
                else if (response.code() == 404){
                    Toast.makeText(ChiTietSach.this, "Lỗi thêm bl r", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.i("Sach", t.getMessage());
            }
        });
    }
}
