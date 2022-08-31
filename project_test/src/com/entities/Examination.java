package com.entities;

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
@Table(name = "examination")
public class Examination extends Sheet
{
	@Column(name = "product_id")
	private String moduleId;
	
	@Column(name = "yield")
	private double yield;
	
	@Column(name = "Result")
	private boolean result;	// represent pass or not
}
