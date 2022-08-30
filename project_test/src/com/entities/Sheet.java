package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
public abstract class Sheet
{
	@Data
	@NoArgsConstructor
	@Embeddable
	public class SheetId implements Serializable
	{
		@Column(name = "Sheet_ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int sheetId;

		@Column(name = "Project_ID")
		private int proejctId;

		@Column(name = "Supplier_ID")
		private int supplierId;
	}

	@EmbeddedId
	protected SheetId sheetId;

	protected String sheetType;

	protected int moduleId;

	protected int volume;

	protected LocalDate date;

	protected abstract Sheet getSheet();
}
