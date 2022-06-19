package in.co.works.panda.dao;

import java.util.List;

import in.co.works.panda.dto.BookingDTO;



public interface BookingDAOInt {

	public long add(BookingDTO dto);
	
	public void delete(BookingDTO dto);
	
	public BookingDTO findBypk(long pk);
	
	public BookingDTO findByName(String name);
	
	public void update(BookingDTO dto);
	
	public List<BookingDTO> list();
	
	public List<BookingDTO>list(int pageNo,int pageSize);
	
	public List<BookingDTO> search(BookingDTO dto);
	
	public List<BookingDTO> search(BookingDTO dto,int pageNo,int pageSize);
	
}
