package kg.attractor.lesson_49.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        manager.setUsersByUsernameQuery(
                "select email, password, enabled from users where email = ?"
        );

        manager.setAuthoritiesByUsernameQuery(
                "select u.email, r.role from users u join roles r on u.role_id = r.id where u.email = ?"
        );

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())

                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // для H2

                .authorizeHttpRequests(auth -> auth

                        // Swagger
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        // H2
                        .requestMatchers("/h2-console/**").permitAll()

                        // регистрация
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()

                        // просмотр вакансий
                        .requestMatchers(HttpMethod.GET, "/vacancies/**").permitAll()

                        // защищено
                        .requestMatchers("/resumes/**").authenticated()
                        .requestMatchers("/files/**").authenticated()
                        .requestMatchers("/vacancies/**").authenticated()

                        .anyRequest().permitAll()
                )

                .httpBasic();

        return http.build();
    }
}