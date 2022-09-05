package com.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sheet")
public class Sheet
{
	@Id
	@Column(name = "sheet_id")
	protected String sheetId;
	
	@Column(name = "sheet_type")
	protected String sheetType;
	
	@ManyToOne
	@JoinColumn(name = "prod_id")
	protected Product product;
	
	@ManyToOne
	@JoinColumn(name = "proj_id")
	protected Project project;
	
	@ManyToOne
	@JoinColumn(name = "sup_id")
	protected Supplier supplier;
	
	@Column(name = "volume")
	protected int volume;
	
	@ManyToOne
	@JoinColumn(name = "supervisor_id")
	protected Employee supervisor;
	
	@Column(name = "unit_price")
	private int unitPrice;
	
	@Column(name = "total_price")
	private int totalPrice;
	
	@Column(name = "signature")
	private boolean sign;
	
	@Column(name = "esd_date")
	private LocalDate esdDate;	// Estimated Shipment Delivery Date
	
	@Column(name = "yield")
	private double yield;
	
	@Column(name = "result")
	private boolean inspectionResult;	// represent pass or not
	
	private Sheet(String sheetId, String sheetType)
	{
		this.sheetId = sheetId;
		this.sheetType = sheetType;
	}
	
	public static Sheet of(String sheetId, String sheetType)
	{
		Sheet sh = new Sheet(sheetId, sheetType);
		
		return sh;
	}
	
	public Sheet setFields(Product product, Project project, Supplier supplier, Employee supervisor)
	{
		this.product = product;
		this.project = project;
		this.supplier = supplier;
		this.supervisor = supervisor;
		
		return this;
	}
}
