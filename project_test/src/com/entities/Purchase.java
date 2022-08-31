package com.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Purchase")
public class Purchase extends Sheet
{
	@Column(name = "Module_ID")
	private String moduleId;
	
	@Column(name = "Unit_price")
	private int unitPrice;
	
	@Column(name = "Total_price")
	private int totalPrice;
	
	@Column(name = "Esd_Date")
	private LocalDate esdDate;	// Estimated Shipment Delivery Date
}
