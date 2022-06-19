package in.co.works.panda.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.works.panda.dto.CityDTO;
import in.co.works.panda.dto.CountryDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.dto.StateDTO;



public interface GuestDAOInt {

	public long add(GuestDTO dto);
	
	public void delete(GuestDTO dto);
	
	public GuestDTO findBypk(long pk);
	
	public GuestDTO findByEmail(String email);
	
	public void update(GuestDTO dto);
	
	public List<GuestDTO> list();
	
	public List<GuestDTO>list(int pageNo,int pageSize);
	
	public List<GuestDTO> search(GuestDTO dto);
	
	public List<GuestDTO> search(GuestDTO dto,int pageNo,int pageSize);
	
	public List<CountryDTO> searchCountry(CountryDTO dto);
	
	public List<StateDTO> searchState(StateDTO dto);
	
	public List<CityDTO> searchCity(CityDTO dto);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
	
	public CountryDTO findByCountryId(long pk);
	public StateDTO findByStateId(long pk);
	public CityDTO findByCityId(long pk);
	
	
}
