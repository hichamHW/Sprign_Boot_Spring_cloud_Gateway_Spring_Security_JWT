package com.example.auth.configs;

import com.example.auth.services.AccountServicesImp;
import com.example.auth.services.AccountServicesImp;
import com.example.auth.middleware.MiddlewareJWT;
import com.example.auth.models.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;


@EnableWebSecurity
@Configuration
public class Security  extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountServicesImp accountServicesimp;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                MyUser myuser = accountServicesimp.getUserByUsername(username);
                System.out.println(myuser.toString());
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                myuser.getMyRoles().forEach(r -> {
                    authorities.add(new SimpleGrantedAuthority(r.getName()));
                });
                return new User(myuser.getUsername(), myuser.getPassword(), authorities);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    //http.formLogin();
    ///http.authorizeRequests().anyRequest().permitAll();
    ///  http.authorizeRequests().antMatchers("/login").permitAll();
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtSecurity(authenticationManagerBean()));
        http.addFilterBefore(new MiddlewareJWT(), UsernamePasswordAuthenticationFilter.class);

}

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }
}
