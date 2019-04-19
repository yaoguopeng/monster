package com.island.monster.security;

import com.island.monster.common.IslandUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 单例的密码加密器
 */
public final class IslandPasswordEncoder implements PasswordEncoder {

    private static final PasswordEncoder INSTANCE = new IslandPasswordEncoder();

    @Override
    public String encode(CharSequence charSequence) {
        // md5加密
        return IslandUtil.MD5Encode(charSequence.toString(),"utf-8");
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        // md5加密后比较
        return encode(charSequence).equals(s);
    }

    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private IslandPasswordEncoder() {
    }
}
