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

import in.co.works.panda.dao.PaidServiceDAOInt;
import in.co.works.panda.dto.PaidServiceDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.util.EmailBuilder;


@Service
public class PaidServiceServiceImpl implements PaidServiceServiceInt {

	private static Logger log=Logger.getLogger(PaidServiceServiceImpl.class.getName());
	
	@Autowired
	private PaidServiceDAOInt dao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(PaidServiceDTO dto) throws DuplicateRecordException {
		log.info("PaidServiceServiceImpl Add method start");
		PaidServiceDTO existDTO=dao.findByName(dto.getTitle());
		if(existDTO !=null)
			throw new DuplicateRecordException("Title Already Exist");
		long pk=dao.add(dto);
		log.info("PaidServiceServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(PaidServiceDTO dto) {
		log.info("PaidServiceServiceImpl Delete method start");
		dao.delete(dto);
		log.info("PaidServiceServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public PaidServiceDTO findBypk(long pk) {
		log.info("PaidServiceServiceImpl findBypk method start");
		PaidServiceDTO dto=dao.findBypk(pk);
		log.info("PaidServiceServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public PaidServiceDTO findByName(String name) {
		log.info("PaidServiceServiceImpl findByPaidServiceName method start");
		PaidServiceDTO dto=dao.findByName(name);
		log.info("PaidServiceServiceImpl findByPaidServiceName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(PaidServiceDTO dto) throws DuplicateRecordException {
		log.info("PaidServiceServiceImpl update method start");
		PaidServiceDTO existDTO=dao.findByName(dto.getTitle());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Title Already Exist");
		dao.update(dto);
		log.info("PaidServiceServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<PaidServiceDTO> list() {
		log.info("PaidServiceServiceImpl list method start");
		List<PaidServiceDTO> list=dao.list();
		log.info("PaidServiceServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PaidServiceDTO> list(int pageNo, int pageSize) {
		log.info("PaidServiceServiceImpl list method start");
		List<PaidServiceDTO> list=dao.list(pageNo, pageSize);
		log.info("PaidServiceServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PaidServiceDTO> search(PaidServiceDTO dto) {
		log.info("PaidServiceServiceImpl search method start");
		List<PaidServiceDTO> list=dao.search(dto);
		log.info("PaidServiceServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<PaidServiceDTO> search(PaidServiceDTO dto, int pageNo, int pageSize) {
		log.info("PaidServiceServiceImpl search method start");
		List<PaidServiceDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("PaidServiceServiceImpl search method end");
		return list;
	}

	

	
}
