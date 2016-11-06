package org.changs.campus.mobile.module.presenter;

import org.changs.campus.mobile.domain.Account;
import org.changs.campus.mobile.enhance.subscriber.AppSubscriber1;
import org.changs.campus.mobile.module.contract.LoginContract;
import org.changs.campus.mobile.module.model.LoginModeImpl;


/**
 * Created by yincs on 2016/11/05
 */

public class LoginPresenterImpl implements LoginContract.Presenter {

    private LoginContract.View view;

    public LoginPresenterImpl(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(String account, String password) {
        new LoginModeImpl(new Account(account, password))
                .login()
                .subscribe(new AppSubscriber1<Account>() {
                    @Override
                    public void onSuccess(Account a) {
                        view.loginSuccess();
                    }

                    @Override
                    public void onFail(Throwable e) {
                        super.onFail(e);
                        view.loginFail(e.getMessage());
                    }
                });
    }
}