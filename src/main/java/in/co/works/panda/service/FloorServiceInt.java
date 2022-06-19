package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.FloorDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface FloorServiceInt {

	public long add(FloorDTO dto) throws DuplicateRecordException;

	public void delete(FloorDTO dto);

	public FloorDTO findBypk(long pk);

	public FloorDTO findByName(String name);

	public void update(FloorDTO dto) throws DuplicateRecordException;

	public List<FloorDTO> list();

	public List<FloorDTO> list(int pageNo, int pageSize);

	public List<FloorDTO> search(FloorDTO dto);

	public List<FloorDTO> search(FloorDTO dto, int pageNo, int pageSize);

}
