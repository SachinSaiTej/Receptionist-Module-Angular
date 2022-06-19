package in.co.works.panda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="PAID_SERVICE")
public class PaidServiceDTO extends BaseDTO {
	
	@Column(name="TITLE",length = 225)
	private String title;
	@Column(name="STATUS",length = 225)
	private String status;
	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return title;
	}

}
