package vn.com.ps10686.bookzone.Model;

import java.util.ArrayList;

public class HoaDon {
    public     ArrayList<HoaDonFinal> hoaDonFinals;

    public HoaDon(ArrayList<HoaDonFinal> hoaDonFinals) {
        this.hoaDonFinals = hoaDonFinals;
    }
    public HoaDon(){

    }

    public ArrayList<HoaDonFinal> getHoaDonFinals() {
        return hoaDonFinals;
    }

    public void setHoaDonFinals(ArrayList<HoaDonFinal> hoaDonFinals) {
        this.hoaDonFinals = hoaDonFinals;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "hoaDonFinals=" + hoaDonFinals +
                '}';
    }
}
