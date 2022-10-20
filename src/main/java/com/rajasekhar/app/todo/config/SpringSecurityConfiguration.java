package com.rajasekhar.app.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails user = createUser("rajasekhar2307", "naktelvadi");
        UserDetails user2 = createUser("shinchan", "shinchan");

        return new InMemoryUserDetailsManager(user, user2);
    }

    private UserDetails createUser(String username, String password) {
        UserDetails user = User
                .builder()
                .passwordEncoder(pass -> passwordEncoder().encode(pass))
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return user;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}
