package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "definition")
public class Definition
{
	@Id
	@Column(name = "param_key")
	private String key;

	@Column(name = "param_value")
	private String value;
}
