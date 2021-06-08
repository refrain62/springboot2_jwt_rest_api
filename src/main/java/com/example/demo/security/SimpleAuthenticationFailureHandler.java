package com.example.demo.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * îFèÿÇ™é∏îsÇµÇΩéûÇÃèàóù
 */
@Slf4j
public class SimpleAuthenticationFailureHandler implements AuthenticationFailureHandler
{
    public SimpleAuthenticationFailureHandler() 
    {
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException 
    {
//        response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        
        if (response.isCommitted())
        {
            log.info("Response has already been committed.");
            
            return;
        }
        
        response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
    }

}
