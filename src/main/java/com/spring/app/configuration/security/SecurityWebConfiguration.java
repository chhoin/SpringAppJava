package com.spring.app.configuration.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import com.spring.app.services.impl.CustomUserDetailService;



@Configuration
/*
* indicates that the class can be used by the Spring IoC
* container as a source of bean definitions.
*/
@EnableWebSecurity
/*
* The @EnableWebSecurity annotation and WebSecurityConfigurerAdapter work
* together to provide web based security. 
*/
public class SecurityWebConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	CustomUserDetailService userDetailsService;
	
	@Autowired
	@Qualifier(value="ajaxAuthenticationSuccessHandler")
	private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
	
	@Autowired
	@Qualifier(value="ajaxAuthenticationFailureHandler")
	private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;
	
	@Autowired
	@Qualifier(value="customSuccessHandler")
	CustomSuccessHandler customSuccessHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//set permission to link of user
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/user/**").hasAnyRole("USER" , "ADMIN")
			.antMatchers("/dba/**").hasAnyRole("DBA","ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN");
		
		//when user click login two method will do for success or fails
		http
			.formLogin()
			.permitAll()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(ajaxAuthenticationSuccessHandler)
			//.successHandler(customSuccessHandler)
			.failureHandler(ajaxAuthenticationFailureHandler);
		
		//session management in spring
		http
			.sessionManagement()
				.sessionAuthenticationErrorUrl("/login")
				.maximumSessions(1)
				.expiredUrl("/login")
				.sessionRegistry(sessionRegistryImpl());
		
		//when user logout
		http
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
			.invalidateHttpSession(true)
			.deleteCookies("JESSIONID")
			.permitAll();
		http.csrf().disable();
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		
		//add for remember me method
		http
			.rememberMe().tokenRepository(persistentTokenRepository())
			.tokenValiditySeconds(1209600);
	}
	
	
	@Bean
	protected SessionRegistry sessionRegistryImpl(){
		return new SessionRegistryImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	//add this two more function for remember me
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	
	//???
	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
		SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
		
		auth.setTargetUrlParameter("targetUrl");
		return auth;
	}
	
	
}
