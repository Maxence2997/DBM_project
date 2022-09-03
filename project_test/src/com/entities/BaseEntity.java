package com.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity
{
	@ToString.Exclude
	@Column(name = "create_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime createTime;

	@ToString.Exclude
	@Column(name = "modify_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime modifyTime;
}
