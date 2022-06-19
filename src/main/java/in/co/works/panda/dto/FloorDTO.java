package in.co.works.panda.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="FLOOR")
public class FloorDTO extends BaseDTO {

	@Column(name="NAME",length = 225)
	private String name;
	
	@Column(name="STATUS",length = 225)
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "floor")
	private Set<RoomDTO> rooms;
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		return name;
	}
}
