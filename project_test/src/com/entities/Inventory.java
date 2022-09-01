package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity
{
	@Column(name = "inv_id")
	private String inventoryId;
	
	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product product;
}
