package com.telusko.spring_sec_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;


    //@Bean
    //AuthenticationProvider authProvider(){
    //@Bean
    //public SecurityFilterChain securityFilterChain(HttpSecurity httpsss) throws Exception {


//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf= new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//                httpSecurityCsrfConfigurer.disable();
//            }
//        };
//       http.csrf(customizer->customizer.disable());
//      http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
      // http.formLogin(Customizer.withDefaults());
//       http.httpBasic(Customizer.withDefaults());
//       http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//        http.csrf(custCsrf);

//        Customizer<AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry<HttpSecurity> custHttp=
//                new Customizer<AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry<HttpSecurity>>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
//                                          registry) {
//                registry.anyRequest().authenticated();
//
//            }
//        };
       // http.authorizeHttpRequests(custHttp);
   //     return http.build();
    @Bean
        public AuthenticationProvider authProvider(){
            DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService);
            provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
            return provider;
        }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
