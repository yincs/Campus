package org.changs.campus.mobile.domain;

/**
 * Created by yincs on 2016/11/5.
 */

public class Account {
    private String account;
    private String passwd;

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
}
