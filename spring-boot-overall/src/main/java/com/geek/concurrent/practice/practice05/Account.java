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
    public void transfer1(Account target, int amt){
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

    private Allocator allocator = Allocator.getInstance();
    public void transfer2(Account target, int amt){
        while(!allocator.apply(this,target))
            ;

        try{
            //这里为什么还要加锁呢？因为可能不止转账一个场景，可能还有客户取款操作（这个也是需要锁定对应的单个账户的）
            synchronized (this){
                synchronized (target){
                    if(this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            allocator.free(this,target);
        }
    }
}
