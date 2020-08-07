package vn.com.ps10686.bookzone.Model;

public class BinhLuan {
    public String tenNguoiDung;
    public String maSach;
    public String ndBL;

    public BinhLuan(String maSach, String ndBL, String maNguoiDung) {
        this.tenNguoiDung = maNguoiDung;
        this.ndBL = ndBL;
        this.maSach = maSach;
    }

    public BinhLuan(){}

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNdBL() {
        return ndBL;
    }

    public void setNdBL(String ndBL) {
        this.ndBL = ndBL;
    }

    @Override
    public String toString() {
        return "BinhLuan{" +
                "tenNguoiDung='" + tenNguoiDung + '\'' +
                ", maSach='" + maSach + '\'' +
                ", ndBL='" + ndBL + '\'' +
                '}';
    }
}
