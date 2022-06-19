package in.co.works.panda.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.FloorDTO;
import in.co.works.panda.dto.PaidServiceDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaidServiceForm extends BaseForm {
	
	@NotEmpty(message = "title is required")
	private String title;
	@NotEmpty(message = "Status is required")
	private String status;
	
	
	@Override
	public BaseDTO getDTO() {
		PaidServiceDTO bean=new PaidServiceDTO();
		bean.setId(id);
		bean.setTitle(title);
		bean.setStatus(status);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	@Override
	public void populate(BaseDTO bDto) {
		PaidServiceDTO bean=(PaidServiceDTO)bDto;
		id=bean.getId();
		title=bean.getTitle();
		status=bean.getStatus();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
