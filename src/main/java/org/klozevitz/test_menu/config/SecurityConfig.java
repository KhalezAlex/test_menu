package org.klozevitz.test_menu.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/styles/**", "/fonts/**", "/scripts/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/register/chiefs").hasRole("COMPANY")
                        .requestMatchers("/register/linear/*").hasAnyRole("MANAGER", "CHEF", "HEAD_BARTENDER")
                        .requestMatchers("/register/chiefs", "/menu/add").hasRole("COMPANY")
                        .requestMatchers("/register/managerSubs").hasRole("MANAGER")
                        .requestMatchers("/register/chefSubs").hasRole("CHEF")
                        .requestMatchers("/register/bartenderSubs").hasRole("HEAD_BARTENDER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/logout").authenticated()
                        .requestMatchers("/register/company").anonymous()
                        .requestMatchers("/auth/**", "/service/**", "/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .permitAll()
                        .defaultSuccessUrl("/")
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/"));
        return http.build();
    }
}
