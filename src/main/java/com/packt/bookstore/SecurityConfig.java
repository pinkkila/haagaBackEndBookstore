// package com.packt.bookstore;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// import java.util.Arrays;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
//     @Bean
//     public InMemoryUserDetailsManager userDetailsService() {
//         UserDetails user = User.builder().username("user").
//             password(passwordEncoder().encode("password"))
//             .roles("USER").build();
//         return new InMemoryUserDetailsManager(user);
//     }
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public CorsConfigurationSource corsConfigurationSource() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowedOrigins(Arrays.asList("*"));
//         config.setAllowedMethods(Arrays.asList("*"));
//         config.setAllowedHeaders(Arrays.asList("*"));
//         config.setAllowCredentials(false);
//         config.applyPermitDefaultValues();
//         source.registerCorsConfiguration("/**", config);
//         return source;
//     }

// }
