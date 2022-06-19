package in.co.works.panda.form;



import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.UserDTO;
import in.co.works.panda.util.DataUtility;






public class MyProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;
	
	@NotEmpty(message = "LastName is required")
	private String lastName;
	
	@NotEmpty(message = "Login is required")
	private String login;
	

	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	public BaseDTO getDTO() {
		UserDTO entity = new UserDTO();
		entity.setLogin(login);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		return entity;
	}

	
	public void populate(BaseDTO bDto) {
		UserDTO entity = (UserDTO) bDto;
		login = entity.getLogin();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();

	}

	

}
