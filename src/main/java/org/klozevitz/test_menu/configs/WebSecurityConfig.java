package org.klozevitz.test_menu.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//
//    private final JwtAuthenticationFilter jwtAuthFilter;
//
//    private final
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests((authz) -> authz
////                        .anyRequest().authenticated()
////                )
////                .httpBasic(withDefaults());
////        return http.build();
////    }
//
//        @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//    }
//
////    @Bean
////    public WebSecurityCustomizer webSecurityCustomizer() {
////        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
////    }
//
//    private static final String[] endpointsForAll = {"/" ,"/login", "/home_page", "/register",
//            "/onLoad", "/error_page", "/checkLoginForRegistration"};
//    private static final String[] endpointsForAdmin = {"/admin_page"};
//
////    @Override
////    protected void configure(HttpSecurity httpSecurity) throws Exception{
////          httpSecurity
////                .httpBasic().disable()
////                .csrf().disable()
//////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//////                .and()
////                .authorizeRequests()
////                .antMatchers("/profile").hasAnyRole("ADMIN", "USER", "STRIKED")
////                .antMatchers(endpointsForAdmin).hasRole("ADMIN")
////                .antMatchers(endpointsForAll).permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/").permitAll()
////                .and()
////                .logout().permitAll().logoutSuccessUrl("/");
////    }
//
////    @Bean
////    @Override
////    public AuthenticationManager authenticationManagerBean() throws Exception {return super.authenticationManagerBean();}
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
