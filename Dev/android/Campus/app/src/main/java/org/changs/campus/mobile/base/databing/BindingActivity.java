package org.changs.campus.mobile.base.databing;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import org.changs.campus.mobile.base.BaseActivity;

/**
 * Created by yincs on 2016/11/5.
 */

public abstract class BindingActivity<T extends ViewDataBinding> extends BaseActivity {
    protected T binding;

    @Override
    public void setContentView() {
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
    }
}
