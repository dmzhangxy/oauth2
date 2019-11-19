package com.dmzhangxy.spring.security.oauth2.server.configure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//说明拦截所有请求，认证类一开即通过它来做
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 配置默认的加密方式，密码加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers("/oauth/check_token");
       //说明里面的地址并不需要授权
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中创建用户,设置认证
      auth.userDetailsService(userDetailsService());
   }

}