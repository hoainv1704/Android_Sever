package vn.com.ps10686.bookzone.Model;



public class Sach1 {
    private  String _id;
    private String tenSach;
    private String maNhan;
    private String tenLoai;
    private String tacGia;
    private String nhaXuatBan;
    private String namXuatBan;
    private String taiBan;
    private String hinh;


    public Sach1(String _id, String tenSach, String maNhan, String tenLoai, String tacGia, String nhaXuatBan, String namXuatBan, String taiBan, String hinh) {
        this._id = _id;
        this.tenSach = tenSach;
        this.maNhan = maNhan;
        this.tenLoai = tenLoai;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.taiBan = taiBan;
        this.hinh = hinh;
    }

    public Sach1(String hinh){
        this.hinh = hinh;
    }

    public Sach1(String tenSach, String maNhan, String tenLoai, String tacGia, String nhaXuatBan, String namXuatBan, String taiBan, String hinh) {
        this.tenSach = tenSach;
        this.maNhan = maNhan;
        this.tenLoai = tenLoai;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.taiBan = taiBan;
        this.hinh = hinh;
    }

    public Sach1(String tenSach, String tenLoai, String tacGia, String nhaXuatBan, String namXuatBan, String taiBan, String hinh) {
        this.tenSach = tenSach;
        this.tenLoai = tenLoai;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.taiBan = taiBan;
        this.hinh = hinh;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "Sach1{" +
                "_id='" + _id + '\'' +
                "tenSach='" + tenSach + '\'' +
                ", maNhan='" + maNhan + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", nhaXuatBan='" + nhaXuatBan + '\'' +
                ", namXuatBan='" + namXuatBan + '\'' +
                ", taiBan='" + taiBan + '\'' +
                ", hinh='" + hinh + '\'' +
                '}';
    }
}
