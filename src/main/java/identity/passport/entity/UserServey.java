package identity.passport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user_survey")
public class UserServey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Survey survey;

	@Column(name = "evaluate_point")
	private int evaluate_point;

	@Column(name = "created")
	private Date created;

	@Column(name = "modified")
	private Date modified;
}
