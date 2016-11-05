package org.changs.campus.mobile.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yincs on 2016/11/5.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutRes() != 0)
            setContentView();

        afterView();
    }

    @Override
    public void setContentView() {
        setContentView(getLayoutRes());
    }
}
