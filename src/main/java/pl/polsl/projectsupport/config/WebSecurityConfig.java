package pl.polsl.projectsupport.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.polsl.projectsupport.JSONWebToken.AuthEntryPointJwt;
import pl.polsl.projectsupport.JSONWebToken.AuthTokenFilter;
import pl.polsl.projectsupport.service.UserDetailsServiceImpl;

import org.springframework.http.HttpMethod;
import javax.servlet.Filter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
//                .antMatchers("/api/auth/signin").permitAll()
//                .antMatchers("/api/auth/logout").permitAll()
//                .antMatchers("/api/public/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/teams/member").permitAll()
//                .antMatchers(HttpMethod.GET,"/api/teams/student").permitAll()
//                .antMatchers("/api/student/**").permitAll()
//                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/swagger-ui/**").permitAll()
//
//                .antMatchers("/api/auth/signup").hasRole("ADMIN")
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
//
//                .antMatchers("/api/attendances/**").hasAnyRole( "ADMIN","SUPERVISOR")
//                .antMatchers("/api/teams").hasAnyRole( "ADMIN","SUPERVISOR")
//                .antMatchers("/api/teams/supervisor").hasAnyRole( "ADMIN","SUPERVISOR")
//                .antMatchers(HttpMethod.POST,"/api/teams/member/**").hasAnyRole( "ADMIN","SUPERVISOR")
//                .antMatchers("/api/teams/status/**").hasAnyRole( "ADMIN","SUPERVISOR")
//                .antMatchers(HttpMethod.POST,"/api/teams/student").hasAnyRole( "ADMIN","SUPERVISOR")
//                .antMatchers("/api/teams/members").hasAnyRole( "ADMIN","SUPERVISOR")
//                .antMatchers("/api/topics/**").hasAnyRole( "ADMIN","SUPERVISOR")

                .anyRequest().authenticated();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore((Filter) authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}