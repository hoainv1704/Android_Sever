package vn.com.ps10686.bookzone;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Activity.ChiTietSach;
import vn.com.ps10686.bookzone.Adapter.GioHangAdapter;
import vn.com.ps10686.bookzone.Model.CauHoi;
import vn.com.ps10686.bookzone.Model.HoaDonFinal;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

import static vn.com.ps10686.bookzone.Activity.MainActivity.sach3s;
import static vn.com.ps10686.bookzone.Activity.MainActivity.saved_user;
import static vn.com.ps10686.bookzone.Adapter.CauHoiAdapter.cauhoimuonmua;

public class GioHangFragment extends Fragment {

    View view;
    RecyclerView recycler_itemlist;
    public static TextView tv_total;
    public static int total = 0;
    String jsonCartList;
    ListView lv_giohang;

    Button btn_placeorder;

    GioHangAdapter gioHangAdapter;
    RetrofitClient retrofitClient;

float giatien;
    public GioHangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_cart, container, false);
        lv_giohang = view.findViewById(R.id.lv_giohang);
        tv_total =view.findViewById(R.id.tv_total);
        tinhtien();
        btn_placeorder = view.findViewById(R.id.btn_placeorder);

        gioHangAdapter = new GioHangAdapter(getContext(), R.layout.one_item_cart, cauhoimuonmua);

        lv_giohang.setAdapter(gioHangAdapter);

        btn_placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Xac nhan mua tat ca?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        themHoaDon();
                    }
                }).setNegativeButton("Huy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });

        return view;
    }

    public ArrayList<HoaDonFinal> hoaDonFinals;


    void themHoaDon() {

        tongketHD();
        API api = retrofitClient.getClien().create(API.class);
        api.themHD(saved_user,hoaDonFinals, giatien).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200){
                    cauhoimuonmua.clear();
                    giatien=0;
                    tv_total.setText(giatien+"");
                    gioHangAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    void tongketHD() {

        hoaDonFinals = new ArrayList<>();

        for (int i = 0; i < cauhoimuonmua.size(); i++) {
            HoaDonFinal hoaDonFinal = new HoaDonFinal();
            CauHoi cauHoi = cauhoimuonmua.get(i);
            hoaDonFinal.setCauHoi(cauHoi.getCauHoi());
            hoaDonFinal.setGia(Float.valueOf(cauHoi.getGia()));
            hoaDonFinal.setMaSach(cauHoi.getMaSach());
            hoaDonFinals.add(hoaDonFinal);
        }
    }
    void tinhtien(){
        giatien=0;
        for (int i = 0; i < cauhoimuonmua.size(); i++) {
            giatien +=Float.valueOf(cauhoimuonmua.get(i).getGia());
        }
        tv_total.setText(giatien+"");

    }
}
