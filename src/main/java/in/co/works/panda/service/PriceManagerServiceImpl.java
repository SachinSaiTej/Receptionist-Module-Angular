package in.co.works.panda.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.works.panda.dao.PriceManagerDAOInt;
import in.co.works.panda.dao.RoomTypeDAOInt;
import in.co.works.panda.dto.PriceManagerDTO;
import in.co.works.panda.exception.DuplicateRecordException;


@Service
public class PriceManagerServiceImpl implements PriceManagerServiceInt {

	private static Logger log=Logger.getLogger(PriceManagerServiceImpl.class.getName());
	
	@Autowired
	private PriceManagerDAOInt dao;
	
	@Autowired
	private RoomTypeDAOInt roomTypeDao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(PriceManagerDTO dto) throws DuplicateRecordException {
		log.info("PriceManagerServiceImpl Add method start");
		dto.setRoomType(roomTypeDao.findBypk(dto.getRoomTypeId()));
		long pk=dao.add(dto);
		log.info("PriceManagerServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(PriceManagerDTO dto) {
		log.info("PriceManagerServiceImpl Delete method start");
		dao.delete(dto);
		log.info("PriceManagerServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public PriceManagerDTO findBypk(long pk) {
		log.info("PriceManagerServiceImpl findBypk method start");
		PriceManagerDTO dto=dao.findBypk(pk);
		log.info("PriceManagerServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public PriceManagerDTO findByName(String name) {
		log.info("PriceManagerServiceImpl findByPriceManagerName method start");
		PriceManagerDTO dto=dao.findByName(name);
		log.info("PriceManagerServiceImpl findByPriceManagerName method end");
		return dto;
	}
	
	@Override
	@Transactional
	public PriceManagerDTO findBypkRoomTypeId(long id) {
		log.info("PriceManagerServiceImpl findBypkRoomTypeId method start");
		PriceManagerDTO dto=dao.findBypkRoomTypeId(id);
		log.info("PriceManagerServiceImpl findBypkRoomTypeId method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(PriceManagerDTO dto) throws DuplicateRecordException {
		log.info("PriceManagerServiceImpl update method start");
		dto.setRoomType(roomTypeDao.findBypk(dto.getRoomTypeId()));
		dao.update(dto);
		log.info("PriceManagerServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<PriceManagerDTO> list() {
		log.info("PriceManagerServiceImpl list method start");
		List<PriceManagerDTO> list=dao.list();
		log.info("PriceManagerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PriceManagerDTO> list(int pageNo, int pageSize) {
		log.info("PriceManagerServiceImpl list method start");
		List<PriceManagerDTO> list=dao.list(pageNo, pageSize);
		log.info("PriceManagerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PriceManagerDTO> search(PriceManagerDTO dto) {
		log.info("PriceManagerServiceImpl search method start");
		List<PriceManagerDTO> list=dao.search(dto);
		log.info("PriceManagerServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<PriceManagerDTO> search(PriceManagerDTO dto, int pageNo, int pageSize) {
		log.info("PriceManagerServiceImpl search method start");
		List<PriceManagerDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("PriceManagerServiceImpl search method end");
		return list;
	}

	

	

	
}
