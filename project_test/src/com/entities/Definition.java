package com.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

	@ToString.Exclude
	@Column(name = "create_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime createTime;

	@Column(name = "modify_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime modifyTime;
}
