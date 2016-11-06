package org.changs.campus.mobile.module.view;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import org.changs.campus.mobile.R;
import org.changs.campus.mobile.base.databing.BindingActivity;
import org.changs.campus.mobile.databinding.ModifyUserdataActBinding;
import org.changs.campus.mobile.module.contract.ModifyUserdataContract;
import org.changs.campus.mobile.module.presenter.ModifyUserdataPresenterImpl;

import java.util.Date;


/**
 * 修改用户资料
 */
public class ModifyUserdataActivity extends BindingActivity<ModifyUserdataActBinding> implements ModifyUserdataContract.View {

    private ModifyUserdataContract.Presenter presenter;

    @Override
    public int getLayoutRes() {
        return R.layout.modify_userdata_act;
    }

    @Override
    public void afterView() {
        binding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister();
            }
        });
        binding.etPhonenumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == R.id.btn_done || actionId == EditorInfo.IME_NULL) {
                    attemptRegister();
                    return true;
                }
                return false;
            }
        });


        presenter = new ModifyUserdataPresenterImpl(this);
    }

    private void attemptRegister() {
        String doneText = binding.btnDone.getText().toString();
        if (!doneText.equals(getString(R.string.action_done)))
            return;

        String nickname = binding.etNickname.getText().toString();
        if (TextUtils.isEmpty(nickname)) {
            binding.etNickname.requestFocus();
            binding.etNickname.setError("请输入昵称");
            return;
        }
        binding.etNickname.setError(null);

        String birthday = binding.etBirthday.getText().toString();
        if (TextUtils.isEmpty(birthday)) {
            binding.etBirthday.requestFocus();
            binding.etBirthday.setError("请输入出生日期");
            return;
        }
        binding.etBirthday.setError(null);

        String qq = binding.etQq.getText().toString();
        if (TextUtils.isEmpty(qq)) {
            binding.etQq.requestFocus();
            binding.etQq.setError("请输入qq");
            return;
        }
        binding.etQq.setError(null);

        String phonenumber = binding.etPhonenumber.getText().toString();
        if (TextUtils.isEmpty(phonenumber)) {
            binding.etPhonenumber.requestFocus();
            binding.etPhonenumber.setError("请输入电话号码");
            return;
        }
        binding.etPhonenumber.setError(null);

        presenter.modify(nickname, new Date(), qq, phonenumber);
    }

    @Override
    public void modifySuccess() {

    }

    @Override
    public void modifyFail() {

    }
}
