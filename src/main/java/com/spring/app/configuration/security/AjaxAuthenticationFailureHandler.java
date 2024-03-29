package com.spring.app.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("ajaxAuthenticationFailureHandler")
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler{

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException, ServletException {
	 	
		System.out.println("FAIL " + e.getMessage());
		
		response.getWriter().print(e.getMessage());
		
        response.getWriter().flush();
	}
	
	
}
