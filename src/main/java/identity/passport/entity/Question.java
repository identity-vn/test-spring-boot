package identity.passport.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "question")
@Data
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@ManyToOne
	@JoinColumn (name="survey_id")
	private Survey survey;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "type")
	private int type;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonBackReference
	private List<Answer> answerList;
	
	
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
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "modified")
	private Date modified;
	
}
