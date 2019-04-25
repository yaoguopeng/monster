package com.island.monster;


import com.island.monster.security.IslandManagerDetailsService;
import com.island.monster.security.IslandPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 权限控制配置：
 *
 * @EnableWebSecurity注解开启Spring Security的功能
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IslandManagerDetailsService islandManagerDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 自定义密码加密
        return IslandPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 放行指定请求，指定登录界面
        http.formLogin().loginPage("/login").loginProcessingUrl("/login_success").and().authorizeRequests()
                .antMatchers("/island/**","/image/**","/sound/**", "/login").permitAll().anyRequest().authenticated().and().httpBasic();
        http.csrf().disable();
        // 过滤所有请求，使用spring security默认登录界面
        //        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.islandManagerDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

}
