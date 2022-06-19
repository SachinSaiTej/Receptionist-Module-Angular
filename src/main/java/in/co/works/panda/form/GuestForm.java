package in.co.works.panda.form;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "LastName is required")
	private String lastName;

	@NotEmpty(message = "email is required")
	private String email;

	@NotEmpty(message = "Password is required")
	private String password;

	@NotEmpty(message = "Confirm Password is required")
	private String confirmPassword;

	@NotEmpty(message = "Gender is required")
	private String gender;
	
	@NotEmpty(message = "DOB is required")
	private String dob;
	
	@NotEmpty(message = "Mobile No is required")
	private String mobileNo;
	
	@Min(value = 1,message = "Country is required")
	private long country;
	
	@Min(value = 1,message = "Region is required")
	private long region;
	
	@Min(value = 1,message = "City is required")
	private long city;
	
	@NotEmpty(message = "Address is required")
	private String address;
	
	private String idType;
	
	@NotEmpty(message = "Id Number is required")
	private String idNumber;
	
	private MultipartFile idImage;
	
	@NotEmpty(message = "Remark is required")
	private String remark;
	
	private String vip;

	@Override
	public BaseDTO getDTO() {
		GuestDTO bean = new GuestDTO();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setConfirmPassword(confirmPassword);
		bean.setGender(gender);
		bean.setDob(DataUtility.getDate(dob));
		bean.setMobileNo(mobileNo);
		bean.setCountryId(country);
		bean.setStateId(region);
		bean.setCityId(city);
		bean.setAddress(address);
		bean.setIdNumber(DataUtility.getLong(idNumber));
		bean.setIdType(idType);
		bean.setRemark(remark);
		bean.setVip(vip);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO baseBean) {
		GuestDTO bean = (GuestDTO) baseBean;
		id = bean.getId();
		firstName = bean.getFirstName();
		lastName = bean.getLastName();
		email = bean.getEmail();
		password = bean.getPassword();
		gender = bean.getGender();
		dob = DataUtility.getDateString(bean.getDob());
		mobileNo = bean.getMobileNo();
		country = bean.getCountryId();
		region = bean.getStateId();
		city = bean.getCityId();
		address = bean.getAddress();
		idType = bean.getIdType();
		idNumber = String.valueOf(bean.getIdNumber());
		remark = bean.getRemark();
		vip = bean.getVip();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
