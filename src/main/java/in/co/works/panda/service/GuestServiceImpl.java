package in.co.works.panda.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.works.panda.dao.GuestDAOInt;
import in.co.works.panda.dto.CityDTO;
import in.co.works.panda.dto.CountryDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.dto.StateDTO;
import in.co.works.panda.exception.DuplicateRecordException;


@Service
public class GuestServiceImpl implements GuestServiceInt {

	private static Logger log=Logger.getLogger(GuestServiceImpl.class.getName());
	
	@Autowired
	private GuestDAOInt dao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(GuestDTO dto) throws DuplicateRecordException {
		log.info("GuestServiceImpl Add method start");
		GuestDTO existDTO=dao.findByEmail(dto.getEmail());
		if(existDTO !=null)
			throw new DuplicateRecordException("Email Already Exist");
		dto.setCountry(dao.findByCountryId(dto.getCountryId()).getName());
		dto.setRegion(dao.findByStateId(dto.getStateId()).getName());
		dto.setCity(dao.findByCityId(dto.getCityId()).getName());
		long pk=dao.add(dto);
		log.info("GuestServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(GuestDTO dto) {
		log.info("GuestServiceImpl Delete method start");
		dao.delete(dto);
		log.info("GuestServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public GuestDTO findBypk(long pk) {
		log.info("GuestServiceImpl findBypk method start");
		GuestDTO dto=dao.findBypk(pk);
		log.info("GuestServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public GuestDTO findByGuestName(String login) {
		log.info("GuestServiceImpl findByGuestName method start");
		GuestDTO dto=dao.findByEmail(login);
		log.info("GuestServiceImpl findByGuestName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(GuestDTO dto) throws DuplicateRecordException {
		log.info("GuestServiceImpl update method start");
		GuestDTO existDTO=dao.findByEmail(dto.getEmail());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Guest Name Already Exist");
		dto.setCountry(dao.findByCountryId(dto.getCountryId()).getName());
		dto.setRegion(dao.findByStateId(dto.getStateId()).getName());
		dto.setCity(dao.findByCityId(dto.getCityId()).getName());
		dao.update(dto);
		log.info("GuestServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<GuestDTO> list() {
		log.info("GuestServiceImpl list method start");
		List<GuestDTO> list=dao.list();
		log.info("GuestServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<GuestDTO> list(int pageNo, int pageSize) {
		log.info("GuestServiceImpl list method start");
		List<GuestDTO> list=dao.list(pageNo, pageSize);
		log.info("GuestServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<GuestDTO> search(GuestDTO dto) {
		log.info("GuestServiceImpl search method start");
		List<GuestDTO> list=dao.search(dto);
		log.info("GuestServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<GuestDTO> search(GuestDTO dto, int pageNo, int pageSize) {
		log.info("GuestServiceImpl search method start");
		List<GuestDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("GuestServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<CountryDTO> searchCountry(CountryDTO dto) {
		return dao.searchCountry(dto);
	}

	@Override
	@Transactional
	public List<StateDTO> searchState(StateDTO dto) {
		return dao.searchState(dto);
	}

	@Override
	@Transactional
	public List<CityDTO> searchCity(CityDTO dto) {
		return dao.searchCity(dto);
	}

	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		return dao.getImageById(id);
	}

	@Override
	@Transactional
	public CountryDTO findByCountryId(long pk) {
		// TODO Auto-generated method stub
		return dao.findByCountryId(pk);
	}

	@Override
	@Transactional
	public StateDTO findByStateId(long pk) {
		return dao.findByStateId(pk);
	}

	@Override
	@Transactional
	public CityDTO findByCityId(long pk) {
		return dao.findByCityId(pk);
	}


	
}
