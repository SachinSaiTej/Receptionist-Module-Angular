package in.co.works.panda.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.works.panda.dao.RoomTypeDAOInt;
import in.co.works.panda.dto.RoomTypeDTO;
import in.co.works.panda.exception.DuplicateRecordException;


@Service
public class RoomTypeServiceImpl implements RoomTypeServiceInt {

	private static Logger log=Logger.getLogger(RoomTypeServiceImpl.class.getName());
	
	@Autowired
	private RoomTypeDAOInt dao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(RoomTypeDTO dto) throws DuplicateRecordException {
		log.info("RoomTypeServiceImpl Add method start");
		RoomTypeDTO existDTO=dao.findByTitle(dto.getTitle());
		if(existDTO !=null)
			throw new DuplicateRecordException("Title Already Exist");
		long pk=dao.add(dto);
		log.info("RoomTypeServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(RoomTypeDTO dto) {
		log.info("RoomTypeServiceImpl Delete method start");
		dao.delete(dto);
		log.info("RoomTypeServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public RoomTypeDTO findBypk(long pk) {
		log.info("RoomTypeServiceImpl findBypk method start");
		RoomTypeDTO dto=dao.findBypk(pk);
		log.info("RoomTypeServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public RoomTypeDTO findByTitle(String title) {
		log.info("RoomTypeServiceImpl findByRoomTypeName method start");
		RoomTypeDTO dto=dao.findByTitle(title);
		log.info("RoomTypeServiceImpl findByRoomTypeName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(RoomTypeDTO dto) throws DuplicateRecordException {
		log.info("RoomTypeServiceImpl update method start");
		RoomTypeDTO existDTO=dao.findByTitle(dto.getTitle());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Title Already Exist");
		dao.update(dto);
		log.info("RoomTypeServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<RoomTypeDTO> list() {
		log.info("RoomTypeServiceImpl list method start");
		List<RoomTypeDTO> list=dao.list();
		log.info("RoomTypeServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<RoomTypeDTO> list(int pageNo, int pageSize) {
		log.info("RoomTypeServiceImpl list method start");
		List<RoomTypeDTO> list=dao.list(pageNo, pageSize);
		log.info("RoomTypeServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<RoomTypeDTO> search(RoomTypeDTO dto) {
		log.info("RoomTypeServiceImpl search method start");
		List<RoomTypeDTO> list=dao.search(dto);
		log.info("RoomTypeServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<RoomTypeDTO> search(RoomTypeDTO dto, int pageNo, int pageSize) {
		log.info("RoomTypeServiceImpl search method start");
		List<RoomTypeDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("RoomTypeServiceImpl search method end");
		return list;
	}

}
