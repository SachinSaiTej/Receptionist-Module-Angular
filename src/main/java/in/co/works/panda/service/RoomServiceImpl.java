package in.co.works.panda.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.works.panda.dao.FloorDAOInt;
import in.co.works.panda.dao.RoomDAOInt;
import in.co.works.panda.dao.RoomTypeDAOInt;
import in.co.works.panda.dto.RoomDTO;
import in.co.works.panda.exception.DuplicateRecordException;


@Service
public class RoomServiceImpl implements RoomServiceInt {

	private static Logger log=Logger.getLogger(RoomServiceImpl.class.getName());
	
	@Autowired
	private RoomDAOInt dao;
	
	@Autowired
	private RoomTypeDAOInt roomTypeDao;
	
	@Autowired
	private FloorDAOInt floorDao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(RoomDTO dto) throws DuplicateRecordException {
		log.info("RoomServiceImpl Add method start");
		RoomDTO existDTO=dao.findByRoomNumber(dto.getRoomNumber());
		if(existDTO !=null)
			throw new DuplicateRecordException("Room Already Exist");
		dto.setRoomType(roomTypeDao.findBypk(dto.getRoomTypeId()));
		dto.setFloor(floorDao.findBypk(dto.getFloorId()));
		long pk=dao.add(dto);
		log.info("RoomServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(RoomDTO dto) {
		log.info("RoomServiceImpl Delete method start");
		dao.delete(dto);
		log.info("RoomServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public RoomDTO findBypk(long pk) {
		log.info("RoomServiceImpl findBypk method start");
		RoomDTO dto=dao.findBypk(pk);
		log.info("RoomServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public RoomDTO findByRoomNumber(String number) {
		log.info("RoomServiceImpl findByRoomName method start");
		RoomDTO dto=dao.findByRoomNumber(number);
		log.info("RoomServiceImpl findByRoomName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(RoomDTO dto) throws DuplicateRecordException {
		log.info("RoomServiceImpl update method start");
		RoomDTO existDTO=dao.findByRoomNumber(dto.getRoomNumber());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Room  Already Exist");
		
			dto.setRoomType(roomTypeDao.findBypk(dto.getRoomTypeId()));
			dto.setFloor(floorDao.findBypk(dto.getFloorId()));
		dao.update(dto);
		log.info("RoomServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<RoomDTO> list() {
		log.info("RoomServiceImpl list method start");
		List<RoomDTO> list=dao.list();
		log.info("RoomServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<RoomDTO> list(int pageNo, int pageSize) {
		log.info("RoomServiceImpl list method start");
		List<RoomDTO> list=dao.list(pageNo, pageSize);
		log.info("RoomServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<RoomDTO> search(RoomDTO dto) {
		log.info("RoomServiceImpl search method start");
		List<RoomDTO> list=dao.search(dto);
		log.info("RoomServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<RoomDTO> search(RoomDTO dto, int pageNo, int pageSize) {
		log.info("RoomServiceImpl search method start");
		List<RoomDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("RoomServiceImpl search method end");
		return list;
	}
}
