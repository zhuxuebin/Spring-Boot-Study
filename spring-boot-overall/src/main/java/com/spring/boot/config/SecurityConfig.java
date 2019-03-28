package com.spring.boot.config;

import com.spring.boot.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author xuery
 * @Date 2019/3/27 19:58
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //这里要测一下："/"到底是拦截什么-就是指localhost:8080, antMatchers是或的关系，有一个通过就通过了
                .antMatchers("/readingList/**").access("hasRole('READER')") //访问"readingList/**"则用户必须要有READER角色，否则需要认证
                .antMatchers("/readingList/**").permitAll()
                .antMatchers("/").permitAll() // "/"不用认证
//                .anyRequest().authenticated() //不加这个则其他不符合上述条件的都不用认证；加了这个则不符合上述条件的都需要认证
                .and()

                .formLogin()
                .loginPage("/login") //这里指定了自定义的login登录页面，所以需要在template目录下创建
                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //存储用户信息：包括用户名，用户的权限等等，相当于一个名单，名单上的用户可以直接允许通过认证
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                UserDetails userDetails = readerRepository.getOne(username);
//                return readerRepository.getOne(username);
//            }
//        });

        auth
                .inMemoryAuthentication()//启用内存用户存储
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER","ADMIN");
    }
}
