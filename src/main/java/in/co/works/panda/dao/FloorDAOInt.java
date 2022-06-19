package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.FloorDTO;



public interface FloorDAOInt {

	public long add(FloorDTO dto);
	
	public void delete(FloorDTO dto);
	
	public FloorDTO findBypk(long pk);
	
	public FloorDTO findByName(String name);
	
	public void update(FloorDTO dto);
	
	public List<FloorDTO> list();
	
	public List<FloorDTO>list(int pageNo,int pageSize);
	
	public List<FloorDTO> search(FloorDTO dto);
	
	public List<FloorDTO> search(FloorDTO dto,int pageNo,int pageSize);
	
}
