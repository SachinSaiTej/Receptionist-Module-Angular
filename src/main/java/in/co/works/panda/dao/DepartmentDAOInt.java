package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.DepartmentDTO;



public interface DepartmentDAOInt {

	public long add(DepartmentDTO dto);
	
	public void delete(DepartmentDTO dto);
	
	public DepartmentDTO findBypk(long pk);
	
	public DepartmentDTO findByName(String name);
	
	public void update(DepartmentDTO dto);
	
	public List<DepartmentDTO> list();
	
	public List<DepartmentDTO>list(int pageNo,int pageSize);
	
	public List<DepartmentDTO> search(DepartmentDTO dto);
	
	public List<DepartmentDTO> search(DepartmentDTO dto,int pageNo,int pageSize);
	
}
