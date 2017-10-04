package identity.passport.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginForm {
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
}
