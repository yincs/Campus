package org.changs.campus.mobile.module.account.login;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import org.changs.campus.mobile.R;
import org.changs.campus.mobile.base.databing.BindingActivity;
import org.changs.campus.mobile.databinding.LoginActBinding;
import org.changs.campus.mobile.utils.ValidUtils;

/**
 * Created by yincs on 2016/11/5.
 *
 * @des 登录界面
 */

public class LoginActivity extends BindingActivity<LoginActBinding> {
    @Override
    public int getLayoutRes() {
        return R.layout.login_act;
    }

    @Override
    public void afterView() {
        binding.emailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        binding.password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == R.id.login || actionId == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
    }

    private void attemptLogin() {
        if (binding.loginProgress.getVisibility() == View.VISIBLE)
            return;

        binding.email.setError(null);
        binding.password.setError(null);

        String email = binding.email.getText().toString();
        if (!ValidUtils.isEmailValid(email)) {
            binding.email.setError("邮件格式不正确");
            binding.email.requestFocus();
            return;
        }

        String password = binding.password.getText().toString();
        if (!ValidUtils.isPasswordValid(password)) {
            binding.password.setError("密码格式不正确");
            binding.password.requestFocus();
            return;
        }

//        HttpUtils.create(HttpLogin.class).login(new Account(email, password));

    }

}
