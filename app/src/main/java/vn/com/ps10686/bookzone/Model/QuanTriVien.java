package vn.com.ps10686.bookzone.Model;

public class QuanTriVien {
    String maQuanTriVien;
    String matKhau;

    public QuanTriVien(){

    }
    public QuanTriVien(String maQuanTriVien) {
        this.maQuanTriVien = maQuanTriVien;

    }

    public String getMaQuanTriVien() {
        return maQuanTriVien;
    }

    public void setMaQuanTriVien(String maQuanTriVien) {
        this.maQuanTriVien = maQuanTriVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
