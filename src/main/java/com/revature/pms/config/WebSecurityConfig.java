package com.revature.pms.config;

import com.revature.pms.config.JwtAuthenticationEntryPoint;
import com.revature.pms.config.JwtRequestFilter;
import com.revature.pms.config.UnauthorizedEntryPoint;

import javax.annotation.Resource;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource(name = "usersService")
    private UserDetailsService userDetailsService;

    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
    

    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and().csrf().disable()
        	.authorizeRequests()
        	.antMatchers("/swagger-ui", "/api-docs/", "/api/auth/**", "/api/users/**", "/api/pokemon/**", "/**").permitAll()
        	.anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    	http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

    }
    
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtRequestFilter authenticationTokenFilterBean() throws Exception {
        return new JwtRequestFilter();
    }
}