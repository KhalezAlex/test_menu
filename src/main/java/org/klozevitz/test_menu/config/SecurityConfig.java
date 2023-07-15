package org.klozevitz.test_menu.config;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.config.JWT.JwtAuthFilter;
import org.klozevitz.test_menu.model.dao.user.UD.DBUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                            try {
                                requests
                                        .requestMatchers("/admin", "/admin_customer/*", "/admin_profile/*", "/admin_event/*",
                                                "/admin_home/*").hasRole("ADMIN")
                                        .requestMatchers("/event/save", "/new_event").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/profile", "/profile/update", "/logout", "/profile/activity/*",
                                                "/event/participate", "/event/roastOut", "event/filter").authenticated()
                                        .requestMatchers("/customer/register", "/register",
                                                "/service/generateBase", "/service/tags", "/service/events").anonymous()
                                        .requestMatchers("/", "/webjars/**", "/*", "/home/events/onLoadEvents", "/search",
                                                "/event/filter").permitAll()
                                        .anyRequest().authenticated()
                                        .and().sessionManagement((session) -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                        .authenticationProvider(authenticationProvider)
                                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                ).logout().logoutUrl("").addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()))
                        .and()
                .formLogin((form) -> form
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .permitAll()
                        .defaultSuccessUrl("/")
                );
        return http.build();
    }


//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//    // КОНФИГУРАЦИЯ ДЛЯ ПОДКЛЮЧЕНИЯ БД
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new DBUserDetailsService();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public UserDetailsManager users(HttpSecurity http) throws Exception {
//        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailsService())
//                .passwordEncoder(encoder())
//                .and()
//                .authenticationProvider(authenticationProvider())
//                .build();
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
//        return jdbcUserDetailsManager;
//    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/admin", "/admin_customer/*", "/admin_profile/*", "/admin_event/*",
//                                "/admin_home/*").hasRole("ADMIN")
//                        .requestMatchers("/event/save", "/new_event").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/profile", "/profile/update", "/logout", "/profile/activity/*",
//                                "/event/participate", "/event/roastOut", "event/filter").authenticated()
//                        .requestMatchers("/customer/register", "/register",
//                                "/service/generateBase", "/service/tags", "/service/events").anonymous()
//                        .requestMatchers("/", "/webjars/**", "/*", "/home/events/onLoadEvents", "/search",
//                                "/event/filter").permitAll()
//                        .anyRequest().authenticated()
//                        .and().sessionManagement((session) -> session
//                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                        .and().authenticationProvider(authenticationProvider)
//                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                ).logout().logoutUrl("").addLogoutHandler(logoutHandler)
//                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()))
//                .and()
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .failureUrl("/login?error=true")
//                        .permitAll()
//                        .defaultSuccessUrl("/")
//                );
//        return http.build();
//    }
}
