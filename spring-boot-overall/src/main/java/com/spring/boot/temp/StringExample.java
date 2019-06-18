package com.spring.boot.temp;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @ClassName StringExample
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/20 16:32
 * @Version 1.0
 */
public class StringExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        list = list.stream().filter(s->!"1".equals(s)).collect(Collectors.toList());
        System.out.println(list);

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        String s = "ello";
        String replaceS = s.replace("el","xxx");
        System.out.println(s);
        System.out.println(replaceS);

        List<String> unitAreaCodes = new ArrayList<>(Arrays.asList("JU001","JU002","JU003"));
        String unitAreaCodesStr = String.join(",",unitAreaCodes);
        if(StringUtils.isNotBlank(unitAreaCodesStr) && unitAreaCodesStr.length() > 10){
            unitAreaCodesStr = unitAreaCodesStr.substring(0,10);
        }
        System.out.println(unitAreaCodesStr);
    }
}
