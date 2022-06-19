package in.co.works.panda.service;

import java.util.List;

import in.co.works.panda.dto.BookingDTO;
import in.co.works.panda.exception.DuplicateRecordException;


public interface BookingServiceInt {

	public long add(BookingDTO dto) throws DuplicateRecordException;

	public void delete(BookingDTO dto);

	public BookingDTO findBypk(long pk);

	public BookingDTO findByName(String name);

	public void update(BookingDTO dto) throws DuplicateRecordException;

	public List<BookingDTO> list();

	public List<BookingDTO> list(int pageNo, int pageSize);

	public List<BookingDTO> search(BookingDTO dto);

	public List<BookingDTO> search(BookingDTO dto, int pageNo, int pageSize);

}
