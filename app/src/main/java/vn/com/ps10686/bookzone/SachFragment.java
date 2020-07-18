package vn.com.ps10686.bookzone;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import vn.com.ps10686.bookzone.Adapter.SachAdapter;
import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.R;

import static vn.com.ps10686.bookzone.Activity.MainActivity.arrayList;

public class SachFragment extends Fragment {
    View view;
    GridView grView;
    SachAdapter sachAdapter;
    ViewFlipper viewFlipper;
    Button next;
    Button previous;

    public SachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_sach, container, false);
        grView = (GridView) view.findViewById(R.id.grView);
        sachAdapter = new SachAdapter(getContext(), R.layout.row_sach, arrayList);
        grView.setAdapter(sachAdapter);
        viewFlipper = (ViewFlipper)view.findViewById(R.id.viewFlipper);
        next = (Button) view.findViewById(R.id.next);
        previous = (Button) view.findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
            }
        });
        return view;
    }

}
