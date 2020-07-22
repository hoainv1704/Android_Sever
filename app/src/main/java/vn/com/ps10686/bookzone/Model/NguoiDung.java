package vn.com.ps10686.bookzone.Model;

public class NguoiDung {
    String maNguoiDung;
    String matKhau;
    String mail;
    String sdt;
    String maNhan1;
    String maNhan2;
    float soDu;

    public NguoiDung(){}

    public NguoiDung(String maNguoiDung, float soDu) {
        this.maNguoiDung = maNguoiDung;
        this.soDu = soDu;
    }

    public NguoiDung(String maNguoiDung, String matKhau, String mail, String sdt, float soDu) {
        this.maNguoiDung = maNguoiDung;
        this.matKhau = matKhau;
        this.mail = mail;
        this.sdt = sdt;
        this.soDu = soDu;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getSoDu() {
        return soDu;
    }

    public void setSoDu(float soDu) {
        this.soDu = soDu;
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

    @Override
    public String toString() {
        return "NguoiDung{" +
                "maNguoiDung='" + maNguoiDung + '\'' +
                '}';
    }
}
