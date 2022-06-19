package in.co.works.panda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="DEPARTMENT")
public class DepartmentDTO extends BaseDTO {
	
	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="STATUS",length = 225)
	private String status;
	@Column(name="DESCRIPTION",length = 225)
	private String description;
	
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
