package identity.passport.config;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import identity.passport.service.JwtTokenService;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenService jwtTokenService;
	
	@Autowired
	private ConfigurationValue cv;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			final String requestHeader = request.getHeader(cv.getJwtTokenHeader());
			String username = null;
			String authToken = null;
			if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
				authToken = requestHeader.substring(7);
				DecodedJWT decodedJWT = jwtTokenService.parseToken(authToken);
				username = decodedJWT.getSubject();
			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			filterChain.doFilter(request, response);
		} catch (JWTVerificationException | IllegalArgumentException | UnsupportedEncodingException e) {
			filterChain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request) {
				@Override
				public String getRequestURI() {
					return "/error401";
				}
			}, response);
		}
	}

}
