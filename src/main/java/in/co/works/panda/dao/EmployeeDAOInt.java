package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.EmployeeDTO;



public interface EmployeeDAOInt {

	public long add(EmployeeDTO dto);
	
	public void delete(EmployeeDTO dto);
	
	public EmployeeDTO findBypk(long pk);
	
	public EmployeeDTO findByEmail(String email);
	
	public void update(EmployeeDTO dto);
	
	public List<EmployeeDTO> list();
	
	public List<EmployeeDTO>list(int pageNo,int pageSize);
	
	public List<EmployeeDTO> search(EmployeeDTO dto);
	
	public List<EmployeeDTO> search(EmployeeDTO dto,int pageNo,int pageSize);
	
}
