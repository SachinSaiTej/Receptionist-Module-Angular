package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.RoomDTO;



public interface RoomDAOInt {

	public long add(RoomDTO dto);
	
	public void delete(RoomDTO dto);
	
	public RoomDTO findBypk(long pk);
	
	public RoomDTO findByRoomNumber(String number);
	
	public void update(RoomDTO dto);
	
	public List<RoomDTO> list();
	
	public List<RoomDTO>list(int pageNo,int pageSize);
	
	public List<RoomDTO> search(RoomDTO dto);
	
	public List<RoomDTO> search(RoomDTO dto,int pageNo,int pageSize);
	
}
