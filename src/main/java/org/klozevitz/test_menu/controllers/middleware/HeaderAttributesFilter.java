package org.klozevitz.test_menu.controllers.middleware;

import jakarta.servlet.*;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(100)
@RequiredArgsConstructor
public class HeaderAttributesFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        setHeaderAttributes(servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void setHeaderAttributes(ServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            setAuthAttrs(request, auth);
        }
        else {
            setUnAuthAttrs(request);
        }
    }

    private void setAuthAttrs(ServletRequest request, Authentication auth) {
        request.setAttribute("isAuthenticated", !auth.getPrincipal().equals("anonymousUser"));
        request.setAttribute("username", auth.getName());
        request.setAttribute("isAdmin",
                auth.getAuthorities().stream().anyMatch(t -> t.toString().contains("ADMIN")));
    }

    private void setUnAuthAttrs(ServletRequest request) {
        request.setAttribute("isAuthenticated", false);
        request.setAttribute("isAdmin", false);
    }
}
