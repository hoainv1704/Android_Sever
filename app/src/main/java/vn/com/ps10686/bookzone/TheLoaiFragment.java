package vn.com.ps10686.bookzone;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import vn.com.ps10686.bookzone.R;

public class TheLoaiFragment extends Fragment {

    View view;

    public TheLoaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       view = inflater.inflate(R.layout.fragment_theloai, container, false);

        return view;
    }
}
