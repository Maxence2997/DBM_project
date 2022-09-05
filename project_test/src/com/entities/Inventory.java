package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory
{
	@Id
	@Column(name = "inv_id")
	private String inventoryId;
	
	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product product;
	
	private Inventory(String inventoryId)
	{
		this.inventoryId = inventoryId;
	}
	
	public static Inventory of(String inventoryId)
	{
		Inventory inv = new Inventory(inventoryId);
		
		return inv;
	}
	
	public Inventory setFields(Project project, Product product)
	{
		this.project = project;
		this.product = product;
		
		return this;
	}
}
