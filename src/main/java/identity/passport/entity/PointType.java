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
@Table(name = "point_type")
@Data
public class PointType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "value")
	private int value;
	
	@ManyToOne
	@JoinColumn (name="created_by")
	private User created_by;
	
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
