package in.co.works.panda.form;

import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.DepartmentDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentForm extends BaseForm {
	
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "Status is required")
	private String status;
	@NotEmpty(message = "Description is required")
	private String description;
	
	
	@Override
	public BaseDTO getDTO() {
		DepartmentDTO bean=new DepartmentDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setStatus(status);
		bean.setDescription(description);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	@Override
	public void populate(BaseDTO bDto) {
		DepartmentDTO bean=(DepartmentDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		status=bean.getStatus();
		description=bean.getDescription();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
