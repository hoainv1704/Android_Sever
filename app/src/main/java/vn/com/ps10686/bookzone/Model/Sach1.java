package vn.com.ps10686.bookzone.Model;



public class Sach1 {
    private String tenSach;
    private String maNhan;
    private String tenLoai;
    private String tacGia;
    private String nhaXuatBan;
    private String namXuatBan;
    private String taiBan;

    public Sach1(String tenSach, String tenLoai, String tacGia, String nhaXuatBan, String namXuatBan, String taiBan) {
        this.tenSach = tenSach;
        this.tenLoai = tenLoai;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.taiBan = taiBan;
    }

    public Sach1(String tenSach) {
        this.tenSach = tenSach;
    }

    public Sach1() {
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaNhan() {
        return maNhan;
    }

    public void setMaNhan(String maNhan) {
        this.maNhan = maNhan;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTaiBan() {
        return taiBan;
    }

    public void setTaiBan(String taiBan) {
        this.taiBan = taiBan;
    }

    @Override
    public String toString() {
        return "Sach1{" +
                "tenSach='" + tenSach + '\'' +
                ", maNhan='" + maNhan + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", nhaXuatBan='" + nhaXuatBan + '\'' +
                ", namXuatBan='" + namXuatBan + '\'' +
                ", taiBan='" + taiBan + '\'' +
                '}';
    }
}
