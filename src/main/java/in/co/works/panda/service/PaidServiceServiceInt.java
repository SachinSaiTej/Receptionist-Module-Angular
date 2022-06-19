package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.PaidServiceDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface PaidServiceServiceInt {

	public long add(PaidServiceDTO dto) throws DuplicateRecordException;

	public void delete(PaidServiceDTO dto);

	public PaidServiceDTO findBypk(long pk);

	public PaidServiceDTO findByName(String name);

	public void update(PaidServiceDTO dto) throws DuplicateRecordException;

	public List<PaidServiceDTO> list();

	public List<PaidServiceDTO> list(int pageNo, int pageSize);

	public List<PaidServiceDTO> search(PaidServiceDTO dto);

	public List<PaidServiceDTO> search(PaidServiceDTO dto, int pageNo, int pageSize);

}
