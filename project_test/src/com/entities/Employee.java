package com.entities;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee
{
	@Id
	@Column(name = "Emp_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "First_name")
	private String firstName;
	
	@Column(name = "Last_name")
	private String lastName;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Phone_number")
	private String phoneNumber;
	
	//For self joining: https://stackoverflow.com/questions/31668522/hibernate-self-join-confusion
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "Supervisor_ID")
	private Integer supervisorId;
	
	@OneToMany(mappedBy = "supervisorId", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Employee> subordinateList;
	
	@Column(name = "Performance")
	private String Performance;
}
