package org.changs.campus.mobile.utils;

/**
 * Created by yincs on 2016/11/5.
 */

public class ValidUtils {
    private ValidUtils() {
    }

    public static boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public static boolean isEmailAccount(String text) {
        return text.length() > 4;
    }

    public static boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}
