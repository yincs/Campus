package org.changs.campus.mobile.module.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import org.changs.campus.mobile.R;
import org.changs.campus.mobile.base.databing.BindingActivity;
import org.changs.campus.mobile.databinding.LoginActBinding;
import org.changs.campus.mobile.module.contract.LoginContract;
import org.changs.campus.mobile.module.presenter.LoginPresenterImpl;
import org.changs.campus.mobile.utils.ValidUtils;

/**
 * Created by yincs on 2016/11/5.
 *
 * @des 登录界面
 */

public class LoginActivity extends BindingActivity<LoginActBinding> implements LoginContract.View {

    private LoginContract.Presenter presenter;

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

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterAct();
            }
        });

        presenter = new LoginPresenterImpl(this);

        startActivity(new Intent(this, ModifyUserdataActivity.class));
    }

    private void attemptLogin() {
        if (binding.loginProgress.getVisibility() == View.VISIBLE)
            return;

        String email = binding.email.getText().toString();
        if (!ValidUtils.isEmailAccount(email)) {
            binding.email.setError(getString(R.string.account_format_not_correct));
            binding.email.requestFocus();
            return;
        }
        binding.email.setError(null);

        String password = binding.password.getText().toString();
        if (!ValidUtils.isPasswordValid(password)) {
            binding.password.setError(getString(R.string.passwd_format_not_correct));
            binding.password.requestFocus();
            return;
        }
        binding.password.setError(null);

        presenter.login(email, password);
        showProgress(true);
    }


    @Override
    public void loginSuccess() {
        showProgress(false);

        finish();
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void loginFail(String error) {
        showProgress(false);
        binding.emailSignInButton.setError("");
        binding.emailSignInButton.setText(error);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            binding.loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
            binding.loginForm.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    binding.loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            binding.loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            binding.loginProgress.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    binding.loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            binding.loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            binding.loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private void startRegisterAct() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
