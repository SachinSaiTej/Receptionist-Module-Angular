package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.RoomDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface RoomServiceInt {

	public long add(RoomDTO dto) throws DuplicateRecordException;

	public void delete(RoomDTO dto);

	public RoomDTO findBypk(long pk);

	public RoomDTO findByRoomNumber(String number);

	public void update(RoomDTO dto) throws DuplicateRecordException;

	public List<RoomDTO> list();

	public List<RoomDTO> list(int pageNo, int pageSize);

	public List<RoomDTO> search(RoomDTO dto);

	public List<RoomDTO> search(RoomDTO dto, int pageNo, int pageSize);

}
