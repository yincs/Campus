package org.changs.campus.mobile.module.contract;


import org.changs.campus.mobile.domain.Account;
import org.changs.campus.mobile.domain.AppRes;

import rx.Observable;

/**
 * Created by yincs on 2016/11/5.
 */

public class LoginContract {
    public interface View {
        void loginSuccess();

        void loginFail(String error);
    }

    public interface Presenter {
        void login(String account, String password);
    }

    public interface Mode{
        Observable<AppRes<Account>> login();
    }

}