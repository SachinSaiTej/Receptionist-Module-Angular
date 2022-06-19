package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.PriceManagerDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface PriceManagerServiceInt {

	public long add(PriceManagerDTO dto) throws DuplicateRecordException;

	public void delete(PriceManagerDTO dto);

	public PriceManagerDTO findBypk(long pk);

	public PriceManagerDTO findByName(String name);
	
	public PriceManagerDTO findBypkRoomTypeId(long id);

	public void update(PriceManagerDTO dto) throws DuplicateRecordException;

	public List<PriceManagerDTO> list();

	public List<PriceManagerDTO> list(int pageNo, int pageSize);

	public List<PriceManagerDTO> search(PriceManagerDTO dto);

	public List<PriceManagerDTO> search(PriceManagerDTO dto, int pageNo, int pageSize);

}
