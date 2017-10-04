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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "answer")
@Data
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	@JsonBackReference
	private Question question;
	
	@Column(name = "positive_value")
	private int positive_value;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	@JsonManagedReference
	private User created_by;
	
	@ManyToOne
	@JoinColumn(name = "modified_by")
	@JsonManagedReference
	private User modified_by;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "modified")
	private Date modified;
}
