package com.geek.concurrent.practice.practice05;

/**
 * @ClassName Account01
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/22 16:38
 * @Version 1.0
 */
public class Account01 {

    private String password;

    void updatePassword(String pw){
        synchronized (password){
            this.password = pw;
        }
    }
}
