package identity.passport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "point_history")
@Data
public class PointHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "survey_id")
	private Long survey_id;
	
	@Column(name = "point_type_id")
	private Long point_type_id;
	
	@Column(name = "point_value")
	private int point_value;
	
	@ManyToOne
	@JoinColumn (name="modified_by")
	private User modified_by;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "modified")
	private Date modified;
	
}
