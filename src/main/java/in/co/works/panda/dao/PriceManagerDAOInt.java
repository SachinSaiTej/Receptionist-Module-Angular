package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.PriceManagerDTO;



public interface PriceManagerDAOInt {

	public long add(PriceManagerDTO dto);
	
	public void delete(PriceManagerDTO dto);
	
	public PriceManagerDTO findBypk(long pk);
	
	public PriceManagerDTO findBypkRoomTypeId(long id);
	
	public PriceManagerDTO findByName(String name);
	
	public void update(PriceManagerDTO dto);
	
	public List<PriceManagerDTO> list();
	
	public List<PriceManagerDTO>list(int pageNo,int pageSize);
	
	public List<PriceManagerDTO> search(PriceManagerDTO dto);
	
	public List<PriceManagerDTO> search(PriceManagerDTO dto,int pageNo,int pageSize);
	
}
