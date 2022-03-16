package com.myapplication1.my.bean;

import java.io.Serializable;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/9 19:57
 */
public class Owner implements Serializable {
    private Integer Ono;
    private String Oname;
    private String Ophonenum;
    private String Oidnum;
    private String Ocert;
    private String Ocheck;
    private String Oaddress;
    private String Oemail;
    private String Bname;
    private String Onickname;

    public Owner() {}

    public Owner(Integer ono, String oname, String ophonenum, String oidnum, String ocert, String ocheck, String oaddress, String oemail, String bname, String onickname) {
        Ono = ono;
        Oname = oname;
        Ophonenum = ophonenum;
        Oidnum = oidnum;
        Ocert = ocert;
        Ocheck = ocheck;
        Oaddress = oaddress;
        Oemail = oemail;
        Bname = bname;
        Onickname = onickname;
    }

    public Integer getOno() {
        return Ono;
    }

    public void setOno(Integer ono) {
        Ono = ono;
    }

    public String getOname() {
        return Oname;
    }

    public void setOname(String oname) {
        Oname = oname;
    }

    public String getOphonenum() {
        return Ophonenum;
    }

    public void setOphonenum(String ophonenum) {
        Ophonenum = ophonenum;
    }

    public String getOidnum() {
        return Oidnum;
    }

    public void setOidnum(String oidnum) {
        Oidnum = oidnum;
    }

    public String getOcert() {
        return Ocert;
    }

    public void setOcert(String ocert) {
        Ocert = ocert;
    }

    public String getOcheck() {
        return Ocheck;
    }

    public void setOcheck(String ocheck) {
        Ocheck = ocheck;
    }

    public String getOaddress() {
        return Oaddress;
    }

    public void setOaddress(String oaddress) {
        Oaddress = oaddress;
    }

    public String getOemail() {
        return Oemail;
    }

    public void setOemail(String oemail) {
        Oemail = oemail;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public String getOnickname() {
        return Onickname;
    }

    public void setOnickname(String onickname) {
        Onickname = onickname;
    }
}
