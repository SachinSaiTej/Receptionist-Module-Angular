package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.PaidServiceDTO;


public interface PaidServiceDAOInt {

	public long add(PaidServiceDTO dto);
	
	public void delete(PaidServiceDTO dto);
	
	public PaidServiceDTO findBypk(long pk);
	
	public PaidServiceDTO findByName(String name);
	
	public void update(PaidServiceDTO dto);
	
	public List<PaidServiceDTO> list();
	
	public List<PaidServiceDTO>list(int pageNo,int pageSize);
	
	public List<PaidServiceDTO> search(PaidServiceDTO dto);
	
	public List<PaidServiceDTO> search(PaidServiceDTO dto,int pageNo,int pageSize);
	
}
