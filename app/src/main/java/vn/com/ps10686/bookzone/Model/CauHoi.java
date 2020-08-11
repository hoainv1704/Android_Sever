package vn.com.ps10686.bookzone.Model;

public class CauHoi {
    String cauHoi;
    String maSach;
    String cauTraLoi;
    String gia;

    public CauHoi(String cauHoi, String maSach, String cauTraLoi, String gia) {
        this.cauHoi = cauHoi;
        this.maSach = maSach;
        this.cauTraLoi = cauTraLoi;
        this.gia = gia;
    }

    public CauHoi() {

    }

    public CauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "CauHoi{" +
                "cauHoi='" + cauHoi + '\'' +
                ", maSach='" + maSach + '\'' +
                ", cauTraLoi='" + cauTraLoi + '\'' +
                ", gia='" + gia + '\'' +
                '}';
    }
}