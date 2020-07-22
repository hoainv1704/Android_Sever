package vn.com.ps10686.bookzone.Model;

import android.graphics.drawable.Drawable;

public class Tag {
    int mauNhan;
    String maNhan;
    String tenNhan;

    public Tag(String maNhan, String tenNhan) {
        this.maNhan = maNhan;
        this.tenNhan = tenNhan;
    }

    public Tag(int mauNhan, String maNhan, String tenNhan) {
        this.mauNhan = mauNhan;
        this.maNhan = maNhan;
        this.tenNhan = tenNhan;
    }

    public int getMauNhan() {
        return mauNhan;
    }

    public void setMauNhan(int mauNhan) {
        this.mauNhan = mauNhan;
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
