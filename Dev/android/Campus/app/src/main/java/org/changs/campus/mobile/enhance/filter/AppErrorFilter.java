package org.changs.campus.mobile.enhance.filter;

import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.enhance.exception.CampusException;

import rx.functions.Func1;

/**
 * Created by yincs on 2016/11/5.
 */

public class AppErrorFilter implements Func1<AppRes<?>, Boolean> {
    @Override
    public Boolean call(AppRes<?> objectAppRes) {
        if (objectAppRes.getCode() != 0)
            throw new CampusException(objectAppRes.getDes());
        return true;
    }
}
