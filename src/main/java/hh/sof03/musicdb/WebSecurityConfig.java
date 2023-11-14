package hh.sof03.musicdb;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import hh.sof03.musicdb.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    // Configure the endpoints with Spring Security
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(antMatcher("/css/**")).permitAll() // Allows the usage of css without login
                        // .requestMatchers(toH2Console()).permitAll() // Allow the usage of H2-console
                        .requestMatchers(antMatcher("/rest/**")).permitAll() // Allows the rest api to be accessed without authorization, NEEDS CORS HANDLING ASWELL IF USED FOR REACT FRONT END
                        .requestMatchers(antMatcher("/")).permitAll()
                        .requestMatchers(antMatcher("/listartists/**")).permitAll()
                        .requestMatchers(antMatcher("/listalbums/**")).permitAll()
                        .requestMatchers(antMatcher("/listsongs/**")).permitAll()
                        .requestMatchers(antMatcher("/search")).permitAll()
                        .anyRequest().authenticated() // All other endpoints require login
                )
                // .csrf(csrf -> csrf
                //         .ignoringRequestMatchers(toH2Console())) // H2 console modifications to security
                // .headers(headers -> headers
                //         .frameOptions(frameoptions -> frameoptions
                //                 .disable())) // H2 console modifications to security
                .formLogin(formlogin -> formlogin
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout
                .logoutSuccessUrl("/")
                        .permitAll());

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}