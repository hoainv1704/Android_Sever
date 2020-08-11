package vn.com.ps10686.bookzone.Model;

public class HoaDonFinal {

    String cauHoi;
    Float gia;
    String maSach;

    public HoaDonFinal() {

    }

    public HoaDonFinal(String cauHoi, Float gia, String maSach) {
        this.cauHoi = cauHoi;
        this.gia = gia;
        this.maSach = maSach;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    @Override
    public String toString() {
        return "HoaDonFinal{" +
                "cauHoi='" + cauHoi + '\'' +
                ", gia=" + gia +
                ", maSach='" + maSach + '\'' +
                '}';
    }
}
