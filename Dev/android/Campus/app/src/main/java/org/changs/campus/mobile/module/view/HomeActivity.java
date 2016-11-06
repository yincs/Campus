package org.changs.campus.mobile.module.view;

import org.changs.campus.mobile.R;
import org.changs.campus.mobile.base.databing.BindingActivity;
import org.changs.campus.mobile.databinding.HomeActBinding;
import org.changs.campus.mobile.module.app.AppAccount;

public class HomeActivity extends BindingActivity<HomeActBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.home_act;
    }

    @Override
    public void afterView() {
        binding.setMyUserInfo(AppAccount.getAppAccount().getMyUserInfo());
    }
}
