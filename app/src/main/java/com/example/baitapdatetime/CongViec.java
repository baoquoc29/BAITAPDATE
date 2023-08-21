package com.example.baitapdatetime;

public class CongViec {
    private String tenCv;
    private String noiDung;
    private String ngay;
    private String gio;

    public CongViec(String tenCv, String noiDung, String ngay, String gio) {

        this.tenCv = tenCv;
        this.noiDung = noiDung;
        this.ngay = ngay;
        this.gio = gio;
    }

    public String getTenCv() {
        return tenCv;
    }

    public void setTenCv(String tenCv) {
        this.tenCv = tenCv;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    @Override
    public String toString() {
        return tenCv + " " + noiDung + " " + ngay + " " + gio;
    }
}
