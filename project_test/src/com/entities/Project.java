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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project extends BaseEntity
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
}
