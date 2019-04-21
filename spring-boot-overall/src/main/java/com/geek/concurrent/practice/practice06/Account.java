package com.geek.concurrent.practice.practice06;

/**
 * @ClassName Account
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/19 14:38
 * @Version 1.0
 */
public class Account {
    private int balance;

    private Allocator allocator = Allocator.getInstance();

    public void transfer3(Account target, int amt){
        allocator.apply(this,target);

        try{
            synchronized (this){
                synchronized (target){
                    if(this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        }finally {
            allocator.free(this,target);
        }
    }
}
