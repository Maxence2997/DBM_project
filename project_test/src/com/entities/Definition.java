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
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "Definition")
public class Definition extends BaseEntity
{
	@Column(name = "Key")
	private String key;
	
	@Column(name = "Value")
	private String value;
}
