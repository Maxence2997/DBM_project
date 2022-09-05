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
@Table(name = "product")
public class Product
{
	@Id
	@Column(name = "prod_id")
	private String productId;
	
	@Column(name = "prod_name")
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "sup_id")
	private Supplier supplier;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "product")
	private List<Sheet> sheetList;
	
	private Product(String productId)
	{
		this.productId = productId;
	}
	
	public static Product of(String productId)
	{
		Product pd = new Product(productId);
		
		return pd;
	}
	
	public Product setFields(String productName, Supplier supplier)
	{
		this.productName = productName;
		this.supplier = supplier;
		
		return this;
	}
}
