package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.EmployeeDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface EmployeeServiceInt {

	public long add(EmployeeDTO dto) throws DuplicateRecordException;

	public void delete(EmployeeDTO dto);

	public EmployeeDTO findBypk(long pk);

	public EmployeeDTO findByEmployeeName(String login);

	public void update(EmployeeDTO dto) throws DuplicateRecordException;

	public List<EmployeeDTO> list();

	public List<EmployeeDTO> list(int pageNo, int pageSize);

	public List<EmployeeDTO> search(EmployeeDTO dto);

	public List<EmployeeDTO> search(EmployeeDTO dto, int pageNo, int pageSize);

}
