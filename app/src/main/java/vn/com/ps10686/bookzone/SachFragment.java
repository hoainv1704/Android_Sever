package vn.com.ps10686.bookzone;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import vn.com.ps10686.bookzone.Adapter.FlipperAdapter;
import vn.com.ps10686.bookzone.Adapter.SachAdapter;
import vn.com.ps10686.bookzone.Adapter.SearchAdapter;
import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.R;

import static vn.com.ps10686.bookzone.Activity.MainActivity.arrayList;
import static vn.com.ps10686.bookzone.Activity.MainActivity.arrayList1;

public class SachFragment extends Fragment{
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


    public SachFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        view = inflater.inflate(R.layout.fragment_sach, container, false);
        grView = (GridView) view.findViewById(R.id.grView);
        searchView = (SearchView) view.findViewById(R.id.search);
        adapterViewFlipper = view.findViewById(R.id.viewAdapter);
        listView =(ListView) view.findViewById(R.id.listview);
        flipperAdapter = new FlipperAdapter(getContext(), arrayList);
        adapterViewFlipper.setAdapter(flipperAdapter);
        adapterViewFlipper.setFlipInterval(3000);
// set auto start for flipping between views
        adapterViewFlipper.setAutoStart(true);
        sachAdapter = new SachAdapter(getContext(), R.layout.row_sach, arrayList);
        grView.setAdapter(sachAdapter);
        searchAdapter = new SearchAdapter(getContext(),arrayList1);
        listView.setAdapter(searchAdapter);
        listView.setVisibility(View.INVISIBLE);

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
}
