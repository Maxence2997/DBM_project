package com.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee extends BaseEntity
{
	@Column(name = "Emp_ID")
	private String employeeId;
	
	@Column(name = "First_name")
	private String firstName;
	
	@Column(name = "Last_name")
	private String lastName;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Phone_number")
	private String phoneNumber;
	
	// For self joining: https://stackoverflow.com/questions/31668522/hibernate-self-join-confusion
	
	@ToString.Exclude
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "Supervisor_ID")
	private Employee supervisor;
	
	@Column(name = "Performance")
	private String Performance;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Employee> subordinateList;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Project> projectList;
}
