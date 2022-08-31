package com.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "Supplier")
public class Supplier extends BaseEntity
{
	@Column(name = "Supplier_ID")
	private String supplierId;
	
	@Column(name = "Supplier_name")
	private String supplierName;
	
	@Column(name = "Supplier_address")
	private String supplierAddress;
	
	@Column(name = "Contact_name")
	private String contactName;
	
	@Column(name = "Contact_mobile")
	private String contactMobile;
	
	@Column(name = "Contact_email")
	private String contactEmail;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> productList;
}
