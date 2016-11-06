package org.changs.campus.mobile.module.model.http;

import org.changs.campus.mobile.domain.Account;
import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.domain.User;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yincs on 2016/11/6.
 */

public interface HttpRegister {

    @POST("account/register")
    Observable<AppRes<User>> register(@Body Account account);
}
