package identity.passport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "login_token")
@Data
public class LoginToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne
	private User user;
	
	@Column(name = "jwt_id")
	private Long jwt_id;
	
	@Column(name = "last_used")
	private Date last_used;
	
	@Column(name = "expired")
	private Date expired;
	
	@Column(name = "is_valid")
	private boolean isValid;
	
	@Column(name = "issued")
	private Date issued;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "modified")
	private Date modified;
	
}
