package com.example.EducationPortal.security.config;

mport org.springframework.beans.factory.annotation.Autowired; import org.springframework.context.annotation.ComponentScan; import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.eduPortal.security.filters.TokenAuthFilter;

@Configuration @ComponentScan("ru.eduPortal") @EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenAuthFilter tokenAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//.hasAuthority("ADMIN")
        http
                .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()

                .antMatchers("/users").permitAll()
                .antMatchers("/addUser/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/course").permitAll()
                .antMatchers("/education").permitAll()
                .antMatchers("/addCourseUser").authenticated()
                .antMatchers("/user-portal").permitAll()
                .antMatchers("/users/info").permitAll();

        http.csrf().disable();
    }

}

