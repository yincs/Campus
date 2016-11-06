package org.changs.campus.mobile.module.app;

import org.changs.campus.mobile.app.AppPreferencesUtils;
import org.changs.campus.mobile.constants.PreferenceKey;

/**
 * Created by yincs on 2016/11/6.
 */

public class AppAccount {

    private static final AppAccount appAccount = new AppAccount();

    private MyUserInfo myUserInfo;

    public static AppAccount getAppAccount() {
        return appAccount;
    }

    private AppAccount() {
        myUserInfo = AppPreferencesUtils.readObject(PreferenceKey.MY_USER_INFO, MyUserInfo.class);
    }

    public MyUserInfo getMyUserInfo() {
        return myUserInfo;
    }

    public void modify(MyUserInfo userInfo) {
        myUserInfo = userInfo;
        AppPreferencesUtils.wirteObject(PreferenceKey.MY_USER_INFO, userInfo);
    }

    public void modify() {
        AppPreferencesUtils.wirteObject(PreferenceKey.MY_USER_INFO, myUserInfo);
    }

    public static final class MyUserInfo {
        private String account;
        private String passwd;

        private int userId;

        public MyUserInfo() {
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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
