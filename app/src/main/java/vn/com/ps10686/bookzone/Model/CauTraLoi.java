package vn.com.ps10686.bookzone.Model;

public class CauTraLoi {
    String maCauTraLoi;
    String maCauHoi;
    String maQuanTriVien;
    float giaTien;
    public CauTraLoi(){

    }
    public CauTraLoi(String maCauTraLoi, String maCauHoi, String maQuanTriVien) {
        this.maCauTraLoi = maCauTraLoi;
        this.maCauHoi = maCauHoi;
        this.maQuanTriVien = maQuanTriVien;
    }

    public CauTraLoi(String maCauTraLoi, String maCauHoi, String maQuanTriVien, float giaTien) {
        this.maCauTraLoi = maCauTraLoi;
        this.maCauHoi = maCauHoi;
        this.maQuanTriVien = maQuanTriVien;
        this.giaTien = giaTien;
    }

    public String getMaCauTraLoi() {
        return maCauTraLoi;
    }

    public void setMaCauTraLoi(String maCauTraLoi) {
        this.maCauTraLoi = maCauTraLoi;
    }

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getMaQuanTriVien() {
        return maQuanTriVien;
    }

    public void setMaQuanTriVien(String maQuanTriVien) {
        this.maQuanTriVien = maQuanTriVien;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }
}
