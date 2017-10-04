package identity.passport.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import identity.passport.config.ConfigurationValue;

@Service
public class JwtTokenService {
	@Autowired
	private ConfigurationValue config;
	
	private Algorithm getAlgorithm() throws IllegalArgumentException, UnsupportedEncodingException {
		System.out.println(config.getJwtSecret());
		return Algorithm.HMAC512(config.getJwtSecret());
	}

	public String createToken(String username)
			throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {
		String token = JWT.create()
							.withIssuer(config.getJwtIssuer())
							.withSubject(username)
							.sign(getAlgorithm());
		return token;
	}

	public DecodedJWT parseToken(String token) throws IllegalArgumentException, UnsupportedEncodingException {
		JWTVerifier verifier = JWT.require(getAlgorithm()).withIssuer(config.getJwtIssuer()).build();
		DecodedJWT decodedJwt = verifier.verify(token);
		return decodedJwt;
	}
}
