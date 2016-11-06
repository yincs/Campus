package org.changs.campus.mobile.module.model;

import org.changs.campus.mobile.domain.Account;
import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.enhance.filter.AppErrorFilter;
import org.changs.campus.mobile.enhance.filter.AppNoBodyFilter;
import org.changs.campus.mobile.module.app.AppAccount;
import org.changs.campus.mobile.module.contract.LoginContract;
import org.changs.campus.mobile.module.model.http.HttpLogin;
import org.changs.campus.mobile.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yuserIdincs on 2016/11/6.
 */

public class LoginModeImpl implements LoginContract.Mode {

    private Account account;

    public LoginModeImpl(Account account) {
        this.account = account;
    }


    @Override
    public  Observable<AppRes<Account>> login() {
        return HttpUtils.create(HttpLogin.class)
                .login(account)
                .subscribeOn(Schedulers.io())
                .filter(new AppErrorFilter())
                .filter(new AppNoBodyFilter())
                .filter(new Func1<AppRes<Account>, Boolean>() {
                    @Override
                    public Boolean call(AppRes<Account> objectAppRes) {
                        loginSuccess(objectAppRes.getData().getUserid());
                        return true;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    private void loginSuccess(int userId) {
        AppAccount.MyUserInfo myUserInfo = new AppAccount.MyUserInfo();
        myUserInfo.setAccount(account.getAccount());
        myUserInfo.setPasswd(account.getPasswd());
        myUserInfo.setUserId(userId);
        AppAccount.getAppAccount().modify(myUserInfo);
    }


}
