package vn.com.ps10686.bookzone;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import vn.com.ps10686.bookzone.R;

import java.util.ArrayList;


public class GioiThieuFragment extends Fragment {
    ListView lv;
    ArrayList<String> ds=new ArrayList<String>();

    public GioiThieuFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gioithieu,null);
        lv=view.findViewById(R.id.lv_gioithieu);
        ds.add("Tên ứng dụng: BOOKZONE");
        ds.add("Nhà phát triển: CEOs");
        ds.add("Năm phát triển: 2020");
        ds.add("Chức năng: Đọc sách & giải trí");
        ds.add("Hình thức: Miễn phí");
        ds.add("Kích thước: 5MB");
        ds.add("Đối tác: FPT Sofware");
        ds.add("Cập nhật lần cuối: 17/07/2020");
        ds.add("Phiên bản: 29.0.1");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                ds);
        lv.setAdapter(adapter);

        return view;
    }
}


