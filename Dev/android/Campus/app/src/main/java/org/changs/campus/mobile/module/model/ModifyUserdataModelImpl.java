package org.changs.campus.mobile.module.model;

import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.domain.User;
import org.changs.campus.mobile.module.contract.ModifyUserdataContract;

import rx.Observable;

/**
 * Created by yincs on 2016/11/06
 */

public class ModifyUserdataModelImpl implements ModifyUserdataContract.Model {

    private User user;

    public ModifyUserdataModelImpl(User user) {
        this.user = user;
    }

    @Override
    public Observable<AppRes> modify() {
        return null;
    }
}