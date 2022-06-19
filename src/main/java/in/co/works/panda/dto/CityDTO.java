package in.co.works.panda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class CityDTO extends BaseDTO {

	@Column(name="state_Id")
	private long stateId;
	
	@Column(name="name" ,length = 225)
	private String name;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
