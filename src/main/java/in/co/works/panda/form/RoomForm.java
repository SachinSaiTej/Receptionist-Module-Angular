package in.co.works.panda.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.FloorDTO;
import in.co.works.panda.dto.RoomDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomForm extends BaseForm {
	
	@NotEmpty(message = "Room Number is required")
	private String roomNumber;
	private String status;
	@Min(value = 1,message = "Floor is required")
	private long floorId;
	@Min(value = 1,message = "Room Type is required")
	private long roomTypeId;
	
	
	@Override
	public BaseDTO getDTO() {
		RoomDTO bean=new RoomDTO();
		bean.setId(id);
		bean.setRoomNumber(roomNumber);
		bean.setStatus(status);
		bean.setFloorId(floorId);
		bean.setRoomTypeId(roomTypeId);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	
	@Override
	public void populate(BaseDTO bDto) {
		RoomDTO bean=(RoomDTO)bDto;
		id=bean.getId();
		roomNumber=bean.getRoomNumber();
		roomTypeId=bean.getRoomTypeId();
		floorId=bean.getFloorId();
		status=bean.getStatus();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
