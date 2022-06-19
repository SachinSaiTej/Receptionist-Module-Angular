package in.co.works.panda.form;


import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.EmployeeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;
	@NotEmpty(message = "Last Name is required")
	private String lastName;
	@NotEmpty(message = "Email is required")
	private String email;
	@NotEmpty(message = "Mobile No is required")
	private String mobileNo;
	@NotEmpty(message = "Gender is required")
	private String gender;
	@NotEmpty(message = "Address is required")
	private String address;
	
	
	@Override
	public BaseDTO getDTO() {
		EmployeeDTO bean=new EmployeeDTO();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setGender(gender);
		bean.setMobileNo(mobileNo);
		bean.setAddress(address);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		EmployeeDTO bean = (EmployeeDTO) bDto;
		id = bean.getId();
		firstName = bean.getFirstName();
		lastName = bean.getLastName();
		email = bean.getEmail();
		gender = bean.getGender();
		mobileNo = bean.getMobileNo();
		address = bean.getAddress();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
