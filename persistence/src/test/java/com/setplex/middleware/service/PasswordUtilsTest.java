package com.setplex.middleware.service;


import com.setplex.middleware.util.PasswordHelper;
import org.junit.Assert;
import org.junit.Test;

public class PasswordUtilsTest {
    @Test
    public void testCheckUser(){
        String password = "pwd";
        String salt = PasswordHelper.makeSalt();
        String hash= PasswordHelper.hashPassword(password, salt);
        System.out.println("hash = " + hash);
        System.out.println("salt = " + salt);
        Assert.assertTrue(PasswordHelper.check(password, hash, salt));

        Assert.assertFalse(PasswordHelper.check(password + password, hash, salt));
    }
}
