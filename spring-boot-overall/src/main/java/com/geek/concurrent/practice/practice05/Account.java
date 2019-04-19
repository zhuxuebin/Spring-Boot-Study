package com.geek.concurrent.practice.practice05;

/**
 * @ClassName Account
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/19 14:38
 * @Version 1.0
 */
public class Account {
    private int balance;
    public void transfer(Account target, int amt){
        //锁定转出账户
        synchronized (this){
            //锁定转入账户
            synchronized (target){
                if(this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
