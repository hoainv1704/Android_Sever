package vn.com.ps10686.bookzone;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Activity.ChiTietSach;
import vn.com.ps10686.bookzone.Activity.LoginActivity;
import vn.com.ps10686.bookzone.Adapter.FlipperAdapter;
import vn.com.ps10686.bookzone.Adapter.SachAdapter;
import vn.com.ps10686.bookzone.Adapter.SearchAdapter;
import vn.com.ps10686.bookzone.Model.BinhLuan;
import vn.com.ps10686.bookzone.Model.NguoiDung;
import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;
;import static vn.com.ps10686.bookzone.Activity.MainActivity.sach1s;
import static vn.com.ps10686.bookzone.Activity.MainActivity.sach2s;
import static vn.com.ps10686.bookzone.Activity.MainActivity.sach3s;


public class SachFragment extends Fragment {
    View view;
    GridView grView;
    SachAdapter sachAdapter;
    AdapterViewFlipper adapterViewFlipper;
    FlipperAdapter flipperAdapter;
    SearchAdapter searchAdapter;
    SearchView searchView;
    ListView listView;
    Button next;
    Button previous;
    RetrofitClient retrofitClient;

    public static ArrayList<BinhLuan> bls = new ArrayList<>();

    public static String id;


    public SachFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        view = inflater.inflate(R.layout.fragment_sach, container, false);
        grView = (GridView) view.findViewById(R.id.grView);
        searchView = (SearchView) view.findViewById(R.id.search);
        adapterViewFlipper = view.findViewById(R.id.viewAdapter);
        listView = (ListView) view.findViewById(R.id.listview);
        // sét adapter choh view flipper
        flipperAdapter = new FlipperAdapter(getContext(), sach1s);
        adapterViewFlipper.setAdapter(flipperAdapter);
        adapterViewFlipper.setFlipInterval(3000);
        adapterViewFlipper.setAutoStart(true);
        // sét adapter cho gridview sách
        sachAdapter = new SachAdapter(getContext(), R.layout.row_sach, sach3s);
        grView.setAdapter(sachAdapter);
        // sét adapter cho search view
        searchAdapter = new SearchAdapter(getContext(), sach2s);
        listView.setAdapter(searchAdapter);
        listView.setVisibility(View.INVISIBLE);


        grView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                API api = retrofitClient.getClien().create(API.class);
                api.chitietsach(sach3s.get(i).get_id()).enqueue(new Callback<Sach1>() {
                    @Override
                    public void onResponse(Call<Sach1> call, Response<Sach1> response) {
                        if (response.code() == 200){

                            ArrayList<Sach1> sachChiTiets = new ArrayList<>();
                            sachChiTiets.add(response.body());
                            System.out.println("chi tiet sach: " + sachChiTiets);
                            Toast.makeText(getContext(), "Lấy dữ liệu thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getContext(), ChiTietSach.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("tenSach", sachChiTiets.get(0).getTenSach());
                            bundle.putString("tenLoai", sachChiTiets.get(0).getTenLoai());
                            bundle.putString("tacGia", sachChiTiets.get(0).getTacGia());
                            bundle.putString("namXB", sachChiTiets.get(0).getNamXuatBan());
                            bundle.putString("nhaXB", sachChiTiets.get(0).getNhaXuatBan());
                            bundle.putString("taiBan", sachChiTiets.get(0).getTaiBan());
                            bundle.putString("hinh", sachChiTiets.get(0).getHinh());
                            bundle.putString("_id", sachChiTiets.get(0).get_id());
                            intent.putExtra("chitietsach", bundle);
                            startActivity(intent);
                        }
                        else if (response.code() == 600){
                            Toast.makeText(getContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Sach1> call, Throwable t) {
                        Log.i("Sach", t.getMessage());
                    }
                });
                API api1 = retrofitClient.getClien().create(API.class);
                api1.getBL(sach3s.get(i).get_id()).enqueue(new Callback<List<BinhLuan>>() {
                    @Override
                    public void onResponse(Call<List<BinhLuan>> call, Response<List<BinhLuan>> response) {
                        if (response.code() == 200){

                            List<BinhLuan> binhLuanss = response.body();

                            for (int i = 0; i < binhLuanss.size() ; i++){
                                bls.add(binhLuanss.get(i));
                            }

                            System.out.println("chi tiet sach: " + binhLuanss);
                            Toast.makeText(getContext(), "Lấy dữ liệu thành công", Toast.LENGTH_SHORT).show();

                        }
                        else if (response.code() == 600){
                            Toast.makeText(getContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BinhLuan>> call, Throwable t) {
                        Log.i("Sach", t.getMessage());
                    }
                });

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String text = s;
                listView.setVisibility(View.VISIBLE);
                searchAdapter.filter(text);

                return false;
            }
        });

        next = (Button) view.findViewById(R.id.next);
        previous = (Button) view.findViewById(R.id.previous);

        next.getBackground().setAlpha(50);
        previous.getBackground().setAlpha(50);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterViewFlipper.showNext();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterViewFlipper.showPrevious();
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void getBL (){
        API api = retrofitClient.getClien().create(API.class);
        api.getBL(sach3s.get(0).get_id()).enqueue(new Callback<List<BinhLuan>>() {
            @Override
            public void onResponse(Call<List<BinhLuan>> call, Response<List<BinhLuan>> response) {
                if (response.code() == 200){

                    List<BinhLuan> binhLuanss = response.body();

                    for (int i = 0; i < binhLuanss.size() ; i++){
                        bls.add(binhLuanss.get(i));
                    }

                    System.out.println("chi tiet sach: " + binhLuanss);
                    Toast.makeText(getContext(), "Lấy dữ liệu thành công", Toast.LENGTH_SHORT).show();

                }
                else if (response.code() == 600){
                    Toast.makeText(getContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BinhLuan>> call, Throwable t) {
                Log.i("Sach", t.getMessage());
            }
        });
    }
}
