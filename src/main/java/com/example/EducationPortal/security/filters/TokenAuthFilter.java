package com.example.EducationPortal.security.filters;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.eduPortal.security.token.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;


@Component
public class TokenAuthFilter implements Filter { @Override

public void init(FilterConfig filterConfig) throws ServletException {

}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException, IOException { HttpServletRequest request = (HttpServletRequest) servletRequest;
// String token = request.getParameter("token");
        String token= request.getHeader("token");
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        if (token == null) { tokenAuthentication.setAuthenticated(false);
        } else {
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

