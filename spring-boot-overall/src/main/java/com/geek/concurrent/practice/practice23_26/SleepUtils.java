package com.geek.concurrent.practice.practice23_26;

/**
 * @ClassName SleepUtils
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/31 14:39
 * @Version 1.0
 */
public class SleepUtils {

   public static void sleep(long millseconds){
       try{
           Thread.sleep(millseconds);
       } catch (Exception e){
           e.printStackTrace();
       }
   }
}
