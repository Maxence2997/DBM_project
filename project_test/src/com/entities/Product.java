package com.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity
{
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
}
