package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.DepartmentDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface DepartmentServiceInt {

	public long add(DepartmentDTO dto) throws DuplicateRecordException;

	public void delete(DepartmentDTO dto);

	public DepartmentDTO findBypk(long pk);

	public DepartmentDTO findByName(String name);

	public void update(DepartmentDTO dto) throws DuplicateRecordException;

	public List<DepartmentDTO> list();

	public List<DepartmentDTO> list(int pageNo, int pageSize);

	public List<DepartmentDTO> search(DepartmentDTO dto);

	public List<DepartmentDTO> search(DepartmentDTO dto, int pageNo, int pageSize);

}
