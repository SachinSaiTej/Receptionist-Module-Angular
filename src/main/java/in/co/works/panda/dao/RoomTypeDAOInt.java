package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.RoomTypeDTO;




public interface RoomTypeDAOInt {

	public long add(RoomTypeDTO dto);
	
	public void delete(RoomTypeDTO dto);
	
	public RoomTypeDTO findBypk(long pk);
	
	public RoomTypeDTO findByTitle(String title);
	
	public void update(RoomTypeDTO dto);
	
	public List<RoomTypeDTO> list();
	
	public List<RoomTypeDTO>list(int pageNo,int pageSize);
	
	public List<RoomTypeDTO> search(RoomTypeDTO dto);
	
	public List<RoomTypeDTO> search(RoomTypeDTO dto,int pageNo,int pageSize);
	
}
