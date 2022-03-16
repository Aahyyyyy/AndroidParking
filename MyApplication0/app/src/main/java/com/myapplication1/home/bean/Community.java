package com.myapplication1.home.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/1 21:56
 */
public class Community implements Parcelable {
    private Integer Cno;
    private String Cname;
    private String Caddress;
    private String Cphoto;
    private Integer Dno;
    private String Ccity;
    private BigDecimal Clat;
    private BigDecimal Clng;

    public Community() { }

    public Community(Integer cno, String cname, String caddress, String cphoto, String ccity) {
        this.Cno = cno;
        this.Cname = cname;
        this.Caddress = caddress;
        this.Cphoto = cphoto;
        this.Ccity = ccity;
    }

    private Community(Parcel in) {
        if (in.readByte() == 0) {
            Cno = null;
        } else {
            Cno = in.readInt();
        }
        Cname = in.readString();
        Caddress = in.readString();
        Cphoto = in.readString();
        if (in.readByte() == 0) {
            Dno = null;
        } else {
            Dno = in.readInt();
        }
        Ccity = in.readString();
    }

    public static final Creator<Community> CREATOR = new Creator<Community>() {
        @Override
        public Community createFromParcel(Parcel in) {
            return new Community(in);
        }

        @Override
        public Community[] newArray(int size) {
            return new Community[size];
        }
    };

    public Integer getCno() {
        return Cno;
    }

    public void setCno(Integer cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCaddress() {
        return Caddress;
    }

    public void setCaddress(String caddress) {
        Caddress = caddress;
    }

    public String getCphoto() {
        return Cphoto;
    }

    public void setCphoto(String cphoto) {
        Cphoto = cphoto;
    }

    public Integer getDno() {
        return Dno;
    }

    public void setDno(Integer dno) {
        Dno = dno;
    }

    public String getCcity() {
        return Ccity;
    }

    public void setCcity(String ccity) {
        Ccity = ccity;
    }

    public BigDecimal getClat() {
        return Clat;
    }

    public void setClat(BigDecimal clat) {
        Clat = clat;
    }

    public BigDecimal getClng() {
        return Clng;
    }

    public void setClng(BigDecimal clng) {
        Clng = clng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getCno());
        dest.writeString(getCaddress());
        dest.writeString(getCphoto());
        dest.writeString(getCcity());
    }
}
