package vn.com.ps10686.bookzone.Model;

public class HoaDonChiTiet {
    String maHDCT;
    String maHoaDon;
    String maSach;
    String maCauHoi;
    String maCauTraLoi;

    public HoaDonChiTiet(String maHoaDon, String maSach, String maCauHoi, String maCauTraLoi) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.maCauHoi = maCauHoi;
        this.maCauTraLoi = maCauTraLoi;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
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

    public String getMaCauTraLoi() {
        return maCauTraLoi;
    }

    public void setMaCauTraLoi(String maCauTraLoi) {
        this.maCauTraLoi = maCauTraLoi;
    }
}
