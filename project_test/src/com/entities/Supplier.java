package com.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier
{
	@Id
	@Column(name = "sup_id")
	private String supplierId;
	
	@Column(name = "sup_name")
	private String supplierName;
	
	@Column(name = "sup_address")
	private String supplierAddress;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_mobile")
	private String contactMobile;
	
	@Column(name = "contact_email")
	private String contactEmail;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> productList;
	
	private Supplier(String supId)
	{
		this.supplierId = supId;
	}
	
	public static Supplier of(String supId)
	{
		Supplier sup = new Supplier(supId);
		return sup;
	}
	
	public Supplier setFields(String supName, String supAddress, String contactName,
			String contactMobile, String contactEmail)
	{
		this.supplierName = supName;
		this.supplierAddress = supAddress;
		this.contactName = contactName;
		this.contactMobile = contactMobile;
		this.contactEmail = contactEmail;
		
		return this;
	}
	
	public Supplier setFields(String supName, String supAddress)
	{
		this.supplierName = supName;
		this.supplierAddress = supAddress;
		
		return this;
	}
}
