package vn.com.ps10686.bookzone.Model;

public class Sach {
    private String maSach;
    private String maTheLoai;
    private String tenSach;
    private String NXB;
    private int bia;

    public Sach(int bia){
        this.bia = bia;
    }

    public Sach(String tenSach, int bia) {
        this.tenSach = tenSach;
        this.bia = bia;
    }

    public Sach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Sach(){}
    public Sach(String maSach, String maTheLoai, String tenSach, String NXB, int bia) {
        this.maSach = maSach;
        this.maTheLoai = maTheLoai;
        this.tenSach = tenSach;
        this.NXB = NXB;
        this.bia = bia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getBia() {
        return bia;
    }

    public void setBia(int bia) {
        this.bia = bia;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "maSach='" + maSach + '\'' +
                ", maTheLoai='" + maTheLoai + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", NXB='" + NXB + '\'' +
                ", bia=" + bia +
                '}';
    }
}
