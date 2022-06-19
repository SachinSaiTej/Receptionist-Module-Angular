package in.co.works.panda.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.FloorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FloorForm extends BaseForm {
	
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "Status is required")
	private String status;
	
	
	@Override
	public BaseDTO getDTO() {
		FloorDTO bean=new FloorDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setStatus(status);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	@Override
	public void populate(BaseDTO bDto) {
		FloorDTO bean=(FloorDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		status=bean.getStatus();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
