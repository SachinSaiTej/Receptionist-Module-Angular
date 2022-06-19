package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.UserDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface UserServiceInt {

	public long add(UserDTO dto) throws DuplicateRecordException;

	public void delete(UserDTO dto);

	public UserDTO findBypk(long pk);

	public UserDTO findByUserName(String login);

	public void update(UserDTO dto) throws DuplicateRecordException;

	public List<UserDTO> list();

	public List<UserDTO> list(int pageNo, int pageSize);

	public List<UserDTO> search(UserDTO dto);

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

	public UserDTO authentication(UserDTO dto);
	
	  public boolean changePassword(Long id, String oldPassword, String newPassword);
	  
	  public boolean forgetPassword(String login);

}
