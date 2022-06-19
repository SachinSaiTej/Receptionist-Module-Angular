package in.co.works.panda.service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.works.panda.dao.FloorDAOInt;
import in.co.works.panda.dto.FloorDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.util.EmailBuilder;


@Service
public class FloorServiceImpl implements FloorServiceInt {

	private static Logger log=Logger.getLogger(FloorServiceImpl.class.getName());
	
	@Autowired
	private FloorDAOInt dao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(FloorDTO dto) throws DuplicateRecordException {
		log.info("FloorServiceImpl Add method start");
		FloorDTO existDTO=dao.findByName(dto.getName());
		if(existDTO !=null)
			throw new DuplicateRecordException("Name Already Exist");
		long pk=dao.add(dto);
		log.info("FloorServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(FloorDTO dto) {
		log.info("FloorServiceImpl Delete method start");
		dao.delete(dto);
		log.info("FloorServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public FloorDTO findBypk(long pk) {
		log.info("FloorServiceImpl findBypk method start");
		FloorDTO dto=dao.findBypk(pk);
		log.info("FloorServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public FloorDTO findByName(String name) {
		log.info("FloorServiceImpl findByFloorName method start");
		FloorDTO dto=dao.findByName(name);
		log.info("FloorServiceImpl findByFloorName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(FloorDTO dto) throws DuplicateRecordException {
		log.info("FloorServiceImpl update method start");
		FloorDTO existDTO=dao.findByName(dto.getName());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Floor Name Already Exist");
		dao.update(dto);
		log.info("FloorServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<FloorDTO> list() {
		log.info("FloorServiceImpl list method start");
		List<FloorDTO> list=dao.list();
		log.info("FloorServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<FloorDTO> list(int pageNo, int pageSize) {
		log.info("FloorServiceImpl list method start");
		List<FloorDTO> list=dao.list(pageNo, pageSize);
		log.info("FloorServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<FloorDTO> search(FloorDTO dto) {
		log.info("FloorServiceImpl search method start");
		List<FloorDTO> list=dao.search(dto);
		log.info("FloorServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<FloorDTO> search(FloorDTO dto, int pageNo, int pageSize) {
		log.info("FloorServiceImpl search method start");
		List<FloorDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("FloorServiceImpl search method end");
		return list;
	}

	

	
}
