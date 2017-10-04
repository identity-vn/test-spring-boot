package identity.passport.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "survey")
@Data
public class Survey {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "point")
	private int point;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "start_time")
	private String start_time;
	
	@Column(name = "end_time")
	private String end_time;
	
	@ManyToOne
	@JoinColumn (name="created_by")
	@JsonManagedReference
	private User created_by;
	
	@ManyToOne
	@JoinColumn (name="modified_by")
	@JsonManagedReference
	private User modified_by;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	@JsonBackReference
	private List<Question> questionList;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "modified")
	private Date modified;
	
	

}
