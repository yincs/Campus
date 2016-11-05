package org.changs.campus.mobile.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yincs on 2016/11/5.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(getLayoutRes(), container, false);
        afterView();
        return rootView;
    }
}
