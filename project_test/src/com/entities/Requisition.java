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
@Table(name = "Requisition")
public class Requisition extends Sheet
{
	private Product product;
	
	private int unitPrice;
	
	private int totalPrice;
	
	private LocalDate esdDate;	// Estimated Shipment Delivery Date
}
