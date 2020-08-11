package vn.com.ps10686.bookzone.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Activity.IntroActivity;
import vn.com.ps10686.bookzone.Activity.MainActivity;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

public class NguoiDungFragment extends Fragment {
    //Biến giữa thông tin đc lưu
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String saved_user, saved_sodu;
    //View trong fragment
    TextView tvInfoUser,tvInfoPassword, tvInfoSoDu;
    Button btnThemSoDu, btnCapNhatThongTin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view1 = inflater.inflate(R.layout.fragment_nguoidung,null);
        map(view1);
        sharedPref=PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = sharedPref.edit();
        getInfoBeforeView();
        tvInfoUser.setText(saved_user);
        tvInfoSoDu.setText(saved_sodu);
        capNhatPassword();
        return view1;
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
    EditText matKhauHienTai, matKhauMoi, xacNhan;
    void capNhatPassword(){
        btnCapNhatThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());

                LayoutInflater layoutInflater = getLayoutInflater();
                final View dialogView =layoutInflater.inflate(R.layout.dialog_doimatkhau,null);
                mapOnDialog(dialogView);
                alertDialog.setView(dialogView);
                alertDialog.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username1 = tvInfoUser.getText().toString();
                        String matKhauHienTaiCanThayDoi = matKhauHienTai.getText().toString();
                        String matKhauMoiChoTK = matKhauMoi.getText().toString();
                        String xnMK = xacNhan.getText().toString();
                        if(xnMK.equals(matKhauMoiChoTK)){
                            doiMatKhauTrenServer(username1, matKhauHienTaiCanThayDoi,matKhauMoiChoTK);
                        }
                    }
                }).setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });
    }
    void mapOnDialog(View dialogView){
        matKhauHienTai = dialogView.findViewById(R.id.etDialogPass);
        matKhauMoi = dialogView.findViewById(R.id.etDialogNewPass);
        xacNhan = dialogView.findViewById(R.id.etDialogNewPassConfirm);
    }
    private RetrofitClient retrofitClient = new RetrofitClient();

    void doiMatKhauTrenServer(String user, String pass, String moi){
        API api = retrofitClient.getClien().create(API.class);
        api.doiMatKhau(user, pass, moi).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code()==201){
                    Toast.makeText(getContext(), "Đổi MK thành công!", Toast.LENGTH_SHORT).show();

                    editor.putString(getString(R.string.saved_user_name), "");
                    editor.putString(getString(R.string.saved_so_du),"");
                    editor.commit();
                    Intent i = new Intent(getActivity(), IntroActivity.class);
                    startActivity(i);

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    };
}
