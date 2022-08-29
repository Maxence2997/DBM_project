package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier
{
	@Id
	@Column(name = "Supplier_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Supplier_name")
	private String supplierName;
	
	@Column(name="Supplier_address")
	private String supplierAddress;
	
	@Column(name="Contact_name")
	private String contactName;
	@Column(name="Contact_mobile")
	private String contactMobile;
	
	@Column(name="Contact_email")
	private String contactEmail;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> productList;
}
