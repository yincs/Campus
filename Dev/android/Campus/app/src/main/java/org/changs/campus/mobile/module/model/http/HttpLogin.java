package org.changs.campus.mobile.module.model.http;

import org.changs.campus.mobile.domain.Account;
import org.changs.campus.mobile.domain.AppRes;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yincs on 2016/11/5.
 */


public interface HttpLogin {

    @POST("account/login")
    Observable<AppRes<Account>> login(@Body Account account);
}
