package org.changs.campus.mobile.module.presenter;

import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.domain.User;
import org.changs.campus.mobile.module.app.AppAccount;
import org.changs.campus.mobile.module.contract.ModifyUserdataContract;
import org.changs.campus.mobile.module.model.ModifyUserdataModelImpl;

import java.util.Date;

import rx.Subscriber;

/**
 * Created by yincs on 2016/11/06
 */

public class ModifyUserdataPresenterImpl implements ModifyUserdataContract.Presenter {

    private ModifyUserdataContract.View view;


    public ModifyUserdataPresenterImpl(ModifyUserdataContract.View view) {
        this.view = view;
    }

    @Override
    public void modify(String nickname, Date date, String qq, String phonenumber) {
        User user = new User();
        user.setName(nickname);
        user.setBirthday(new Date());
        user.setQq(qq);
        user.setPhonenumber(phonenumber);
        user.setId(AppAccount.getAppAccount().getMyUserInfo().getUserId());

        new ModifyUserdataModelImpl(user)
                .modify()
                .subscribe(new Subscriber<AppRes>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.modifyFail();
                    }

                    @Override
                    public void onNext(AppRes appRes) {
                        view.modifySuccess();
                    }
                });
    }
}