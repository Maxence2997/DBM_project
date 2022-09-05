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
@Table(name = "project")
public class Project
{
	@Id
	@Column(name = "proj_id")
	private String projectId;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	@Column(name = "status")
	private String status;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "project")
	private List<Inventory> inventoryList;
	
	private Project(String projId)
	{
		this.projectId = projId;
	}
	
	public static Project of(String projId)
	{
		Project proj = new Project(projId);
		
		return proj;
	}
	
	public Project setFields(Employee employee, String status)
	{
		this.employee = employee;
		this.status = status;
		
		return this;
	}
}
