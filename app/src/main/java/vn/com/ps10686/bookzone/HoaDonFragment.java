package vn.com.ps10686.bookzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import vn.com.ps10686.bookzone.Adapter.SachAdapter;
import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.R;

public class HoaDonFragment extends Fragment {

    GridView grView;
    ArrayList<Sach> arrayList;
    SachAdapter sachAdapter;
    View view;

    public HoaDonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_hoadon, container, false);

        return view;
    }
}
