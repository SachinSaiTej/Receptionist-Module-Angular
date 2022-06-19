package in.co.works.panda.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.works.panda.dto.CityDTO;
import in.co.works.panda.dto.CountryDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.dto.StateDTO;
import in.co.works.panda.exception.DuplicateRecordException;

public interface GuestServiceInt {

	public long add(GuestDTO dto) throws DuplicateRecordException;

	public void delete(GuestDTO dto);

	public GuestDTO findBypk(long pk);

	public GuestDTO findByGuestName(String login);

	public void update(GuestDTO dto) throws DuplicateRecordException;

	public List<GuestDTO> list();

	public List<GuestDTO> list(int pageNo, int pageSize);

	public List<GuestDTO> search(GuestDTO dto);

	public List<GuestDTO> search(GuestDTO dto, int pageNo, int pageSize);

	public List<CountryDTO> searchCountry(CountryDTO dto);

	public List<StateDTO> searchState(StateDTO dto);

	public List<CityDTO> searchCity(CityDTO dto);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
	public CountryDTO findByCountryId(long pk);
	public StateDTO findByStateId(long pk);
	public CityDTO findByCityId(long pk);

}
