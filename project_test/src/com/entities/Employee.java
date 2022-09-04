package com.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee
{
	@Id
	@Column(name = "emp_id")
	private String employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_num")
	private String phoneNum;

	// For self joining: https://stackoverflow.com/questions/31668522/hibernate-self-join-confusion

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "supervisor_id")
	private Employee supervisor;

	@Column(name = "performance")
	private String performance;

	@ToString.Exclude
	@OneToMany(mappedBy = "supervisor")
	private List<Employee> subordinateList;

	@ToString.Exclude
	@OneToMany(mappedBy = "employee")
	private List<Project> projectList;

	public Employee(String firstName, String lastName, String address, String phoneNum,
			Employee supervisor, String performance)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNum = phoneNum;
		this.supervisor = supervisor;
		this.performance = performance;
	}

	public Employee(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(String firstName, String lastName, String address, String phoneNum)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public Employee(String empId)
	{
		this.employeeId = empId;
	}
}
