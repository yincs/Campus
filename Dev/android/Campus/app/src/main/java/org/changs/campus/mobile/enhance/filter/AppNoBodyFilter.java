package org.changs.campus.mobile.enhance.filter;

import org.changs.campus.mobile.domain.AppRes;
import org.changs.campus.mobile.enhance.exception.CampusException;

import rx.functions.Func1;

/**
 * Created by yincs on 2016/11/6.
 */

public class AppNoBodyFilter implements Func1<AppRes<?>, Boolean> {
    @Override
    public Boolean call(AppRes<?> objectAppRes) {
        if (objectAppRes.getData() == null)
            throw new CampusException("内容为空");
        return true;
    }
}