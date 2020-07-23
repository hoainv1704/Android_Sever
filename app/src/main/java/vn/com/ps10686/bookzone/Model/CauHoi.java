package vn.com.ps10686.bookzone.Model;

public class CauHoi {
    String maCauHoi;
    String maSach;
    String maQuanTriVien;

    public CauHoi(){

    }

    public CauHoi(String maCauHoi, String maSach, String maQuanTriVien) {
        this.maCauHoi = maCauHoi;
        this.maSach = maSach;
        this.maQuanTriVien = maQuanTriVien;
    }

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaQuanTriVien() {
        return maQuanTriVien;
    }

    public void setMaQuanTriVien(String maQuanTriVien) {
        this.maQuanTriVien = maQuanTriVien;
    }
}
