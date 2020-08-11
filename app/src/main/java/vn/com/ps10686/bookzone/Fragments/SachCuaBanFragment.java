package vn.com.ps10686.bookzone.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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
        api.getAllHD(saved_user).enqueue(new Callback<List<HoaDon>>() {
            @Override
            public void onResponse(Call<List<HoaDon>> call, Response<List<HoaDon>> response) {
                if(response.code()==200){

                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<HoaDon>> call, Throwable t) {

            }
        });

    }
}
