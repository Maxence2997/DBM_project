package com.entities;

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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Employee")
public class Employee
{
	@Id
	@Column(name = "Emp_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
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
	private Employee supervisor;
	
	@OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Employee> subordinateList;
	
	@Column(name = "Performance")
	private String Performance;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Project> projectList;

	@Override
	public String toString()
	{
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", supervisorId=" + supervisor + ", Performance=" + Performance + "]";
	}
}
