package in.co.works.panda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EMPLOYEE")
@Getter
@Setter
public class EmployeeDTO extends BaseDTO {
	
	
	@Column(name="FIRST_NAME",length = 225)
	private String firstName;
	@Column(name="LAST_NAME",length = 225)
	private String lastName;
	@Column(name="EMAIL_ID",length = 225)
	private String email;
	@Column(name="MOBILE_NO",length = 225)
	private String mobileNo;
	@Column(name="GENDER",length = 225)
	private String gender;
	@Column(name="ADDRESS",length = 225)
	private String address;
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		return firstName+" "+lastName;
	}
	
	
	

}
