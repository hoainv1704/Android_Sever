package vn.com.ps10686.bookzone.Model;

public class NguoiDung {
    String tenNguoiDung;
    String matKhau;
    String email;
    String sdt;
    String maNhan1;
    String maNhan2;
    float soDu;

    public NguoiDung(String tenNguoiDung, String matKhau, String email, String sdt, String maNhan1, String maNhan2, float soDu) {
        this.tenNguoiDung = tenNguoiDung;
        this.matKhau = matKhau;
        this.email = email;
        this.sdt = sdt;
        this.maNhan1 = maNhan1;
        this.maNhan2 = maNhan2;
        this.soDu = soDu;
    }

    public NguoiDung(String tenNguoiDung, String matKhau) {
        this.tenNguoiDung = tenNguoiDung;
        this.matKhau = matKhau;
    }

    public NguoiDung() {
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaNhan1() {
        return maNhan1;
    }

    public void setMaNhan1(String maNhan1) {
        this.maNhan1 = maNhan1;
    }

    public String getMaNhan2() {
        return maNhan2;
    }

    public void setMaNhan2(String maNhan2) {
        this.maNhan2 = maNhan2;
    }

    public float getSoDu() {
        return soDu;
    }

    public void setSoDu(float soDu) {
        this.soDu = soDu;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "tenNguoiDung='" + tenNguoiDung + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", email='" + email + '\'' +
                ", sdt='" + sdt + '\'' +
                ", maNhan1='" + maNhan1 + '\'' +
                ", maNhan2='" + maNhan2 + '\'' +
                ", soDu=" + soDu +
                '}';
    }
}
