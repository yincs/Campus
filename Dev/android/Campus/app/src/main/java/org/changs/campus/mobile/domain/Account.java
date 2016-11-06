package org.changs.campus.mobile.domain;

/**
 * Created by yincs on 2016/11/5.
 */


public class Account extends Entity {
    private String account;
    private String passwd;

    private int userid;

    public Account() {
    }

    public Account(String account, String passwd) {
        this.account = account;
        this.passwd = passwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
