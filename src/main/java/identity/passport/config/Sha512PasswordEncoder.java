package identity.passport.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Sha512PasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPassword) {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);
		return encoder.encodePassword(rawPassword.toString(), null);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);
		String encodedRawPassword = encoder.encodePassword(rawPassword.toString(), null);
		return StringUtils.equals(encodedRawPassword, encodedPassword);
	}

}
