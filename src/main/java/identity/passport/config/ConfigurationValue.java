package identity.passport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@PropertySource(name = "jwt", value = { "jwt.properties" })
public class ConfigurationValue {
	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.issuer}")
	private String jwtIssuer;
	
	@Value("${jwt.header}")
	private String jwtTokenHeader;
}
