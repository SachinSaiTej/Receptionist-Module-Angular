package in.co.works.panda.form;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.PriceManagerDTO;
import in.co.works.panda.dto.RoomTypeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceManagerForm extends BaseForm {

	private RoomTypeDTO roomType;
	
	@Min(value = 1,message = "Room Type is required")
	private long roomTypeId;
	@NotEmpty(message = "Sunday price is required")
	private String sun;
	@NotEmpty(message = "Monday price is required")
	private String mon;
	@NotEmpty(message = "Tuesday price is required")
	private String tues;
	@NotEmpty(message = "Wednesday price is required")
	private String wed;
	@NotEmpty(message = "Thursday price is required")
	private String thus;
	@NotEmpty(message = "Friday price is required")
	private String fri;
	@NotEmpty(message = "Saturday price is required")
	private String sat;

	@Override
	public BaseDTO getDTO() {
		PriceManagerDTO bean = new PriceManagerDTO();
		bean.setId(id);
		bean.setRoomType(roomType);
		bean.setSun(sun);
		bean.setMon(mon);
		bean.setTues(tues);
		bean.setWed(wed);
		bean.setThus(thus);
		bean.setFri(fri);
		bean.setSat(sat);
		bean.setRoomTypeId(roomTypeId);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		PriceManagerDTO bean = (PriceManagerDTO) bDto;
		id = bean.getId();
		roomTypeId=bean.getRoomTypeId();
		sun = bean.getSun();
		mon = bean.getMon();
		tues = bean.getTues();
		wed = bean.getWed();
		thus = bean.getThus();
		fri = bean.getFri();
		sat = bean.getSat();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
