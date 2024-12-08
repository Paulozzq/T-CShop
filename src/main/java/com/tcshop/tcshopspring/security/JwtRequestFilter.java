package com.tcshop.tcshopspring.security;

import com.tcshop.tcshopspring.Util.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public JwtRequestFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;
        String email = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwtToken = authHeader.substring(7); // Extraemos el token JWT del encabezado
            username = jwtTokenUtil.extractUsername(jwtToken); // Extraemos el 'username' del token
            email = jwtTokenUtil.extractEmail(jwtToken); // Extraemos el 'email' del token
            logger.info(email);
            logger.info("Authorization header found. JWT token: {}, Extracted username: {}, Extracted email: {}" + jwtToken + username + email);
        } else {
            logger.warn("Authorization header is missing or malformed.");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            logger.info("Username found, proceeding to authenticate the user: {}" + username);

            // Cargar detalles del usuario usando username
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (userDetails instanceof CustomUserDetails) {
                CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
                email = customUserDetails.getEmail(); // Obtén el email si es necesario
            }

            logger.info("UserDetails loaded for username: {}" + username);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                logger.info("JWT token is valid for user: {}" + username);

                var authenticationToken = jwtTokenUtil.getAuthentication(jwtToken, userDetails);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                logger.info("Authentication has been set in SecurityContext for user: {}" + username);
            } else {
                logger.warn("JWT token is invalid for user: {}" + username);
            }
        }

        chain.doFilter(request, response);
    }
}