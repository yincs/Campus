package org.changs.campus.mobile.module.contract;

import org.changs.campus.mobile.domain.AppRes;

import java.util.Date;

import rx.Observable;

/**
 * Created by yincs on 2016/11/6.
 */

public interface ModifyUserdataContract {


    interface View {
        void modifySuccess();

        void modifyFail();
    }

    interface Presenter {

        void modify(String nickname, Date date, String qq, String phonenumber);
    }

    interface Model {

        Observable<AppRes> modify();
    }


}