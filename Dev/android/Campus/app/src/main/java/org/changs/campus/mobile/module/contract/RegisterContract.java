package org.changs.campus.mobile.module.contract;

import org.changs.campus.mobile.domain.Account;

/**
 * Created by yincs on 2016/11/5.
 */

public class RegisterContract {
    public interface View {
        void registerSuccess();

        void registerFail(String error);
    }

    public interface Presenter {
        void register(Account account);
    }
}