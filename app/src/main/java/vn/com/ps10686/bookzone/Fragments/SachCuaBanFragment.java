package vn.com.ps10686.bookzone.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Adapter.SachCuaBanAdapter;
import vn.com.ps10686.bookzone.Model.HDFTraVe;
import vn.com.ps10686.bookzone.Model.HoaDon;
import vn.com.ps10686.bookzone.Model.HoaDonFinal;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

import static vn.com.ps10686.bookzone.Activity.MainActivity.saved_user;
import static vn.com.ps10686.bookzone.Activity.MainActivity.sodu;

public class SachCuaBanFragment extends Fragment {

    ArrayList<HoaDonFinal> hoaDonFinals;
    ListView lvSCT;
    SachCuaBanAdapter sachCuaBanAdapter;
    RetrofitClient retrofitClient;

    public SachCuaBanFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        hoaDonFinals = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_sach_cua_ban, container, false);

        lvSCT = view.findViewById(R.id.lv_sachcuaban);

        getHDFinal();

        return view;


    }

    void getHDFinal() {
        API api = retrofitClient.getClien().create(API.class);
        api.getAllHD(saved_user).enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(response.code()==200){
                    List<String> HDFs = response.body();
                    for(int i =0; i<HDFs.size(); i++){
                        HoaDonFinal hoaDonFinal = new HoaDonFinal();
                        hoaDonFinal.setCauHoi(xuLyCauHoi(HDFs.get(i)));
                        hoaDonFinal.setMaSach(xuLyMaSach(HDFs.get(i)));

                        hoaDonFinals.add(hoaDonFinal);
                    }
                    System.out.println(hoaDonFinals.size()+"");
                    sachCuaBanAdapter = new SachCuaBanAdapter(getContext(), R.layout.row_sachcuaban, hoaDonFinals);
                    lvSCT.setAdapter(sachCuaBanAdapter);
                }
                else if(response.code()==404){
                    Toast.makeText(getContext(), "Not Good", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }
    String xuLyCauHoi(String HDF){
        return HDF.substring(HDF.indexOf("Hoi=")+5, HDF.indexOf("gia=")-3);
    }
    String xuLyMaSach(String HDF){
        return HDF.substring(HDF.indexOf("Sach=")+6, HDF.lastIndexOf("}")-1);
    }
}
