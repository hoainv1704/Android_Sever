package vn.com.ps10686.bookzone.Model;

class Tag {
    int hinhNhan;
    String maNhan;
    String tenNhan;

    public Tag(String maNhan, String tenNhan) {
        this.maNhan = maNhan;
        this.tenNhan = tenNhan;
    }

    public Tag(int hinhNhan, String maNhan, String tenNhan) {
        this.hinhNhan = hinhNhan;
        this.maNhan = maNhan;
        this.tenNhan = tenNhan;
    }

    public int getHinhNhan() {
        return hinhNhan;
    }

    public void setHinhNhan(int hinhNhan) {
        this.hinhNhan = hinhNhan;
    }

    public String getMaNhan() {
        return maNhan;
    }

    public void setMaNhan(String maNhan) {
        this.maNhan = maNhan;
    }

    public String getTenNhan() {
        return tenNhan;
    }

    public void setTenNhan(String tenNhan) {
        this.tenNhan = tenNhan;
    }
}
