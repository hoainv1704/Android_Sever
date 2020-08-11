package vn.com.ps10686.bookzone.Model;

public class HoaDonChiTiet {
    String maHoaDon;
    String maSach;
    String maCauHoi;

    public HoaDonChiTiet(String maHoaDon, String maSach, String maCauHoi, String maCauTraLoi) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.maCauHoi = maCauHoi;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

}
