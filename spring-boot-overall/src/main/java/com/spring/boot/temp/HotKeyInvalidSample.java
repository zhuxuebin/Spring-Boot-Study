package com.spring.boot.temp;

/**
 * @ClassName HotKeyInvalidSample
 * @Description 某个热点key失效了，前端大量请求打过来，如何防止全部请求到mysql端
 *
 * 当然是要拦截在缓存层面，可以通过加锁来实现（分布式锁或者单机锁）
 * 现成的
 * @Author xuery
 * @Date 2019/6/28 14:44
 * @Version 1.0
 */
public class HotKeyInvalidSample {


}
