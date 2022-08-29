package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product
{
	@Id
	@Column(name = "Module_ID")
	private String id;
	
	@Column(name = "Item_name")
	private String itemName;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "Supplier_ID")
	private Supplier supplier;
}
