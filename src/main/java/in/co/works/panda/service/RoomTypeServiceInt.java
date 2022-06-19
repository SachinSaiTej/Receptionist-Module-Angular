package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.RoomTypeDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface RoomTypeServiceInt {

	public long add(RoomTypeDTO dto) throws DuplicateRecordException;

	public void delete(RoomTypeDTO dto);

	public RoomTypeDTO findBypk(long pk);

	public RoomTypeDTO findByTitle(String title);

	public void update(RoomTypeDTO dto) throws DuplicateRecordException;

	public List<RoomTypeDTO> list();

	public List<RoomTypeDTO> list(int pageNo, int pageSize);

	public List<RoomTypeDTO> search(RoomTypeDTO dto);

	public List<RoomTypeDTO> search(RoomTypeDTO dto, int pageNo, int pageSize);

}
