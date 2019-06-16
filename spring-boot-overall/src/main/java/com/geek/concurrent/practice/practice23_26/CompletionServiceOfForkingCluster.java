package com.geek.concurrent.practice.practice23_26;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName CompletionServiceOfForkingCluster
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/31 16:13
 * @Version 1.0
 */
public class CompletionServiceOfForkingCluster {

    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(3);

        CompletionService<Integer> cs = new ExecutorCompletionService<>(es);

        List<Future> futures = new ArrayList<>();
        futures.add(cs.submit(() -> {
            SleepUtils.sleep(3000);
            return 1;
        }));

        futures.add(cs.submit(() -> {
            SleepUtils.sleep(2000);
            return 2;
        }));

        futures.add(cs.submit(() -> {
            SleepUtils.sleep(1000);
            return 3;
        }));

        for (int i = 0; i < 3; i++) {

            Future firstF = cs.take();
            Integer ret = (Integer) firstF.get();
            if (ret != null) {
                System.out.println(ret);
                //且取消掉其他在执行的请求
                futures.remove(firstF);
                for (Future future : futures) {
                    future.cancel(true);
                }
                break;
            }
        }

    }
}
