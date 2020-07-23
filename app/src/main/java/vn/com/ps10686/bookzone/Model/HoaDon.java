package vn.com.ps10686.bookzone.Model;

public class HoaDon {
    String maHoaDon;
    String maNguoiDung;
    String ngayPhatSinh;
    float tienThanhToan;
    public HoaDon(){

    }

    public HoaDon(String maNguoiDung, String ngayPhatSinh) {
        this.maNguoiDung = maNguoiDung;
        this.ngayPhatSinh = ngayPhatSinh;
    }

    public HoaDon(String maHoaDon, String maNguoiDung, String ngayPhatSinh, float tienThanhToan ) {
        this.maHoaDon = maHoaDon;
        this.maNguoiDung = maNguoiDung;
        this.ngayPhatSinh = ngayPhatSinh;
        this.tienThanhToan = tienThanhToan;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getNgayPhatSinh() {
        return ngayPhatSinh;
    }

    public void setNgayPhatSinh(String ngayPhatSinh) {
        this.ngayPhatSinh = ngayPhatSinh;
    }

    public float getTienThanhToan() {
        return tienThanhToan;
    }

    public void setTienThanhToan(float tienThanhToan) {
        this.tienThanhToan = tienThanhToan;
    }
}
