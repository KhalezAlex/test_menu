package org.klozevitz.test_menu.config;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.config.JWT.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
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
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("").hasRole("MANAGER")
//                        .requestMatchers("/event/save", "/new_event").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/profile", "/profile/update", "/logout", "/profile/activity/*",
//                                "/event/participate", "/event/roastOut", "event/filter").authenticated()
//                        .requestMatchers("/auth/register").anonymous()
                        .requestMatchers("/auth/**", "/service/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout().logoutUrl("/logout").addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()));
//        тут крашит этот код
//                .and()
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .failureUrl("/login?error=true")
//                        .permitAll()
//                        .defaultSuccessUrl("/")
//                );
        return http.build();
    }
}
