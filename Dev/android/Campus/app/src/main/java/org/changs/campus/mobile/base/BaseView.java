package org.changs.campus.mobile.base;

/**
 * Created by yincs on 2016/11/5.
 */

public interface BaseView<p extends BasePresenter> {
    int getLayoutRes();

    void setContentView();

    void afterView();


}
