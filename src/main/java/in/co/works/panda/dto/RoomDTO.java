package in.co.works.panda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ROOM")
@Getter
@Setter
public class RoomDTO extends BaseDTO {
	
	@ManyToOne
	@JoinColumn(name="FLOOR",nullable = false)
	private FloorDTO floor;
	
	@ManyToOne
	@JoinColumn(name="ROOM_TYPE",nullable = false)
	private RoomTypeDTO roomType;
	
	@Column(name="Room_Number" ,length = 225)
	private String roomNumber;
	
	@Column(name="STATUS",length = 225)
	private String status;
	
	
	private long floorId;
	
	private long roomTypeId;
	
	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return roomNumber;
	}

}
