package org.changs.campus.mobile.module.view;

import android.content.Intent;
import android.view.View;

import org.changs.campus.mobile.R;
import org.changs.campus.mobile.base.databing.BindingActivity;
import org.changs.campus.mobile.databinding.RegisterActBinding;
import org.changs.campus.mobile.domain.Account;
import org.changs.campus.mobile.module.contract.RegisterContract;
import org.changs.campus.mobile.module.presenter.RegisterPresenterImpl;
import org.changs.campus.mobile.utils.ValidUtils;

public class RegisterActivity extends BindingActivity<RegisterActBinding> implements RegisterContract.View {

    private RegisterContract.Presenter presenter;

    @Override
    public int getLayoutRes() {
        return R.layout.register_act;
    }

    @Override
    public void afterView() {
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister();
            }
        });

        presenter = new RegisterPresenterImpl(this);
    }

    private void attemptRegister() {
        String account = binding.tvAccount.getText().toString();
        if (!ValidUtils.isEmailAccount(account)) {
            binding.tvAccount.setError(getString(R.string.account_format_not_correct));
            binding.tvAccount.requestFocus();
            return;
        }
        binding.tvAccount.setError(null);

        String password = binding.tvPasswd.getText().toString();
        if (!ValidUtils.isPasswordValid(password)) {
            binding.tvPasswd.setError(getString(R.string.passwd_format_not_correct));
            binding.tvPasswd.requestFocus();
            return;
        }
        binding.tvPasswd.setError(null);

        presenter.register(new Account(account, password));
    }

    @Override
    public void registerSuccess() {
        startActivity(new Intent(this, ModifyUserdataActivity.class));
        finish();
    }

    @Override
    public void registerFail(String error) {

    }
}
