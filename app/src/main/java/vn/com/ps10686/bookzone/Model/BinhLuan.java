package vn.com.ps10686.bookzone.Model;

public class BinhLuan {
    public String tenND;
    public String ndBL;

    public BinhLuan(String tenND, String ndBL) {
        this.tenND = tenND;
        this.ndBL = ndBL;
    }

    public BinhLuan(){}

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
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
                "tenND='" + tenND + '\'' +
                ", ndBL='" + ndBL + '\'' +
                '}';
    }
}
