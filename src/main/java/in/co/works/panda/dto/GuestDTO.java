package in.co.works.panda.dto;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="GUEST")
@Getter
@Setter
public class GuestDTO extends BaseDTO {
	
	@Column(name="FIRST_NAME" ,length = 225)
	private String firstName;
	@Column(name="LAST_NAME" ,length = 225)
	private String lastName;
	@Column(name="EMAIL" ,length = 225)
	private String email;
	@Column(name="PASSWORD" ,length = 225)
	private String password;
	private String confirmPassword;
	@Column(name="GENDER" ,length = 225)
	private String gender;
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="MOBILE_NO" ,length = 225)
	private String mobileNo;
	@Column(name="COUNTRY" ,length = 225)
	private String country;
	@Column(name="REGION" ,length = 225)
	private String region;
	@Column(name="CITY" ,length = 225)
	private String city;
	@Column(name="ADDRESS" ,length = 225)
	private String address;
	@Column(name="ID_TYPE" ,length = 225)
	private String idType;
	@Column(name="ID_NUMBER" )
	private long idNumber;
	
	@Lob
	@Column(name="ID_IMAGE",columnDefinition="MEDIUMBLOB" )
	private byte[] idImage;
	@Column(name="REMARK" ,length = 225)
	private String remark;
	@Column(name="VIP" ,length = 225)
	private String vip;
	

	private long countryId;
	private long stateId;
	private long cityId;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		return firstName+" "+lastName;
	}

}
