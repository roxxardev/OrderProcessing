package com.example.restspringbootangular.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.restspringbootangular.security.SecurityConstants.HEADER_STRING;
import static com.example.restspringbootangular.security.SecurityConstants.SECRET;
import static com.example.restspringbootangular.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("content-type", MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8");
            response.getWriter().write(convertObjectToJson("No '" + HEADER_STRING + "' header or does not start with '"+TOKEN_PREFIX+"'"));
            //chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken;
        try {
            authenticationToken = getAuthentication(request);
        } catch (ExpiredJwtException e) {

            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT expired");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("content-type", MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8");
            response.getWriter().write(convertObjectToJson("JWT expired"));
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if(token == null) return null;

        String user = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        if(user == null) return null;

        return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}
