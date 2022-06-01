package com.first.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	private AuthenticationSuccessHandler successHandler;
	private AuthenticationProvider provider;
	private CustomAuthenticationFailureHandler failureHandler;

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public SecurityConfig(CustomAuthenticationProvider authenticationProvider, CustomAuthenticationSuccessHandler authenticationSuccessHandler)
	{
		this.provider = authenticationProvider;
		this.successHandler = authenticationSuccessHandler;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.csrf().disable()
			.authorizeRequests()
//				.antMatchers("/**").permitAll()
//				.antMatchers("/user/login").anonymous()
//				.antMatchers("/user/signup", "static/**", "/resources/**").permitAll()
//				.antMatchers("/join").hasAuthority("0")
//				.anyRequest().authenticated()
				.anyRequest().permitAll() //로그인, 회원가입 css 깨져서 임시로 변경해놓음.
			.and()
			.formLogin()
				.loginPage("/user/login")
				.usernameParameter("user_id")
				.passwordParameter("user_pw")
				.successHandler(successHandler)
				.failureHandler(failureHandler)
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/user/login")
				.invalidateHttpSession(true)
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(provider);
	}

	@Bean
    public SpringSecurityDialect springSecurityDialect()
	{
        return new SpringSecurityDialect();
    }

	@Override
	public void configure(WebSecurity web) throws Exception
	{
	    web.httpFirewall(defaultHttpFirewall());

	    web.ignoring().antMatchers("/static/**");
	}

	@Bean
	public HttpFirewall defaultHttpFirewall()
	{
	    return new DefaultHttpFirewall();
	}
}