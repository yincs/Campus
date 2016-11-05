package org.changs.campus.mobile.base.databing;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.changs.campus.mobile.base.BaseFragment;

/**
 * Created by yincs on 2016/11/5.
 */

public abstract class BindingFragment<T extends ViewDataBinding> extends BaseFragment {
    protected T binding;

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        afterView();
        return binding.getRoot();
    }
}
