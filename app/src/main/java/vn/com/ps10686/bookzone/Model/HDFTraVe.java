package vn.com.ps10686.bookzone.Model;

import java.util.ArrayList;

public class HDFTraVe {
    String tenNguoiDung;
    ArrayList<HoaDonFinal> hoaDonFinals;
    public HDFTraVe(){

    }
    public HDFTraVe(String tenNguoiDung, ArrayList<HoaDonFinal> hoaDonFinals) {
        this.tenNguoiDung = tenNguoiDung;
        this.hoaDonFinals = hoaDonFinals;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public ArrayList<HoaDonFinal> getHoaDonFinals() {
        return hoaDonFinals;
    }

    public void setHoaDonFinals(ArrayList<HoaDonFinal> hoaDonFinals) {
        this.hoaDonFinals = hoaDonFinals;
    }


}
