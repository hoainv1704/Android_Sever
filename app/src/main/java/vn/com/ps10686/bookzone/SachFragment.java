package vn.com.ps10686.bookzone;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ViewFlipper;

import java.util.ArrayList;

import vn.com.ps10686.bookzone.Activity.ChiTietSach;
import vn.com.ps10686.bookzone.Adapter.FlipperAdapter;
import vn.com.ps10686.bookzone.Adapter.SachAdapter;
import vn.com.ps10686.bookzone.Adapter.SearchAdapter;
import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.R;

import static vn.com.ps10686.bookzone.Activity.IntroActivity.sach1s;
import static vn.com.ps10686.bookzone.Activity.IntroActivity.sach2s;
import static vn.com.ps10686.bookzone.Activity.IntroActivity.sach3s;
import static vn.com.ps10686.bookzone.Activity.MainActivity.arrayList;
import static vn.com.ps10686.bookzone.Activity.MainActivity.arrayList1;

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

    public static String id;


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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                id = sach1s.get(i).get_id();


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
}
