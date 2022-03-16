package com.myapplication1.home.bean;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/5 19:33
 */
public class Banner {
    private String baname;
    private Integer baphoto;

    public Banner(String baname, int baphoto) {
        this.baname = baname;
        this.baphoto = baphoto;
    }

    public String getBaname() {
        return baname;
    }

    public void setBaname(String baname) {
        this.baname = baname;
    }

    public int getBaphoto() {
        return baphoto;
    }

    public void setBaphoto(int baphoto) {
        this.baphoto = baphoto;
    }
}
