package org.changs.campus.mobile.module.presenter;

import org.changs.campus.mobile.domain.Account;
import org.changs.campus.mobile.module.contract.RegisterContract;

/**
 * Created by yincs on 2016/11/05
 */

public class RegisterPresenterImpl implements RegisterContract.Presenter {

    private RegisterContract.View view;


    public RegisterPresenterImpl(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void register(Account account) {
    }
}