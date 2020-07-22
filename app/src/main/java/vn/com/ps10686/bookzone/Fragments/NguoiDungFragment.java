package vn.com.ps10686.bookzone.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import vn.com.ps10686.bookzone.R;

public class NguoiDungFragment extends Fragment {
    //Biến giữa thông tin đc lưu
    SharedPreferences sharedPref;
    String saved_user, saved_sodu;
    //View trong fragment
    TextView tvInfoUser,tvInfoPassword, tvInfoSoDu;
    Button btnThemSoDu, btnCapNhatThongTin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nguoidung,null);
        map(view);
        sharedPref= PreferenceManager.getDefaultSharedPreferences(getContext());
        getInfoBeforeView();
        tvInfoUser.setText(saved_user);
        tvInfoSoDu.setText(saved_sodu);
        return view;
    }
    //map
    void map(View v){
        tvInfoUser = v.findViewById(R.id.tvInfoUser);
        tvInfoPassword = v.findViewById(R.id.tvInfoPassword);
        tvInfoSoDu = v.findViewById(R.id.tvInfoSoDu);
        btnThemSoDu = v.findViewById(R.id.btnThemSoDu);
        btnCapNhatThongTin = v.findViewById(R.id.btnCapNhatThongTin);
    }
    //Lấy thông tin
    void getInfoBeforeView(){
        saved_user = sharedPref.getString(getString(R.string.saved_user_name),"");
        saved_sodu = sharedPref.getString(getString(R.string.saved_so_du),"");
    }
}
