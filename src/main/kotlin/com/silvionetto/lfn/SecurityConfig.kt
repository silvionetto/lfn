package com.silvionetto.lfn

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean


@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
class SecurityConfig : WebSecurityConfigurerAdapter() {

    val client = listOf("facebook")

    override fun configure(http: HttpSecurity) {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login()
        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and().httpBasic()

    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(authentication: AuthenticationManagerBuilder) {
        authentication.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ROLE_ADMIN")
        authentication.inMemoryAuthentication()
                .withUser("lojista")
                .password("lojista")
                .authorities("ROLE_LOJISTA")
        authentication.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .authorities("ROLE_USER")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}