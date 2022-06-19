package in.co.works.panda.form;

import javax.validation.constraints.NotEmpty;

import in.co.works.panda.dto.BaseDTO;
import in.co.works.panda.dto.UserDTO;





public class LoginForm extends BaseForm {

	@NotEmpty(message = "Login is required")
	private String login;
	@NotEmpty(message = "Password is required")
	private String password;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public BaseDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setLogin(login);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bdto) {
		UserDTO entity=(UserDTO) bdto;
		login=entity.getLogin();
		password=entity.getPassword();
	}

}
