package org.atr.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.atr.users.security.ApplicationUserRole.*;
import javax.sql.DataSource;

import java.util.concurrent.TimeUnit;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ApplicationSecurityConfiguration {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //Disabled csrf just in case of NO user client
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .csrf().disable()
                //.and()
                .authorizeHttpRequests((authz) -> authz
                       /* .requestMatchers(ApiPaths.USER_VALIDATE.getPath()).hasAnyRole(ADMIN.name(),ADMINTRAINEE.name(),USER.name())
                        .requestMatchers(HttpMethod.POST,ApiPaths.USER_MANAGER_CREATE.getPath()).hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                        .requestMatchers(HttpMethod.PUT,ApiPaths.USER_MANAGER_UPDATE.getPath()).hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                        .requestMatchers(HttpMethod.GET,ApiPaths.USER_MANAGER_READ.getPath()).hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                        .requestMatchers(HttpMethod.DELETE,ApiPaths.USER_MANAGER_DELETE.getPath()).hasRole(ADMIN.name())*/
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .rememberMe().tokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(1));
        return http.build();
    }

    /*@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(USER_VALIDATE.getPath());
    }*/
    

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(ADMIN.name())
                //.authorities(ADMIN.getGrantedAuthorities())
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        return users;
    }
}
