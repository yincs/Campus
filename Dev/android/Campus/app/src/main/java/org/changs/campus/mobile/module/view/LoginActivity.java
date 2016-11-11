package org.changs.campus.mobile.module.view;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.tbruyelle.rxpermissions.RxPermissions;

import org.changs.campus.mobile.R;
import org.changs.campus.mobile.base.databing.BindingActivity;
import org.changs.campus.mobile.databinding.LoginActBinding;
import org.changs.campus.mobile.module.contract.LoginContract;
import org.changs.campus.mobile.module.presenter.LoginPresenterImpl;
import org.changs.campus.mobile.utils.ValidUtils;

import rx.Subscriber;

/**
 * Created by yincs on 2016/11/5.
 *
 * @des 登录界面
 */

public class LoginActivity extends BindingActivity<LoginActBinding> implements LoginContract.View {

    private static final String TAG = "LoginActivity";
    private LoginContract.Presenter presenter;

    @Override
    public int getLayoutRes() {
        return R.layout.login_act;
    }

    @Override
    public void afterView() {

//        granted -> {
//            if (granted) {
//                // All requested permissions are granted
//            } else {
//                // At least one permission is denied
//            }
//        }
//        binding.emailSignInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                attemptLogin();
//                getPermission();
//            }
//        });


        binding.password.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == R.id.login || actionId == EditorInfo.IME_NULL) {
                attemptLogin();
                return true;
            }
            return false;
        });
        binding.btnRegister.setOnClickListener(v -> {
            Log.d(TAG, "v = " + v);
        });

        binding.btnRegister.setOnClickListener(v -> startRegisterAct());

        presenter = new LoginPresenterImpl(this);

//        startActivity(new Intent(this, ModifyUserdataActivity.class));
    }

    private void getPermission() {
        RxPermissions.getInstance(this)
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE)
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onCompleted() {

                        Log.e(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError");
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (aBoolean) {
                            Log.e(TAG, "同意了");
                        } else {
                            Log.e(TAG, "不同意");
                            Toast.makeText(LoginActivity.this, "相机权限已被禁止，无法使用该功能", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
