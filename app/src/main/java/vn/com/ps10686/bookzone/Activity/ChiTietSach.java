package vn.com.ps10686.bookzone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import vn.com.ps10686.bookzone.Adapter.BinhLuanAdapter;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.SachFragment;

public class ChiTietSach extends AppCompatActivity {

   public ImageView imvHinh;
   public TextView tvTenSach,tvTenLoai,tvNhaXB,tvNamXB,tvTaiBan,tvTacGia;
   BinhLuanAdapter binhLuanAdapter;
   public RecyclerView rcvBL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sach);

        Map();



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
    }
}
