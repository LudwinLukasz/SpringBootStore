package pl.SpringStore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.SpringStore.repositories.UsersRepository;
import pl.SpringStore.services.CustomUserDetailsService;

/**
 * Created by arabk on 22.11.2017.
 */
@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/", "/login", "/about", "/assets/**").permitAll()
                // .antMatchers("/products/**").hasRole("ADMIN")
                .antMatchers("/products/**").authenticated()
                //.anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/")
                .and()
                .logout().logoutSuccessUrl("/");
        http.csrf().disable();
        //     http.headers().frameOptions().disable();
    }


}
