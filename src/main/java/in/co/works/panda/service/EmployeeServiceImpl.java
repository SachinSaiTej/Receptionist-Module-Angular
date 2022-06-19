package in.co.works.panda.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.works.panda.dao.EmployeeDAOInt;
import in.co.works.panda.dto.EmployeeDTO;
import in.co.works.panda.exception.DuplicateRecordException;


@Service
public class EmployeeServiceImpl implements EmployeeServiceInt {

	private static Logger log=Logger.getLogger(EmployeeServiceImpl.class.getName());
	
	@Autowired
	private EmployeeDAOInt dao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(EmployeeDTO dto) throws DuplicateRecordException {
		log.info("EmployeeServiceImpl Add method start");
		EmployeeDTO existDTO=dao.findByEmail(dto.getEmail());
		if(existDTO !=null)
			throw new DuplicateRecordException("Email Already Exist");
		long pk=dao.add(dto);
		log.info("EmployeeServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(EmployeeDTO dto) {
		log.info("EmployeeServiceImpl Delete method start");
		dao.delete(dto);
		log.info("EmployeeServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public EmployeeDTO findBypk(long pk) {
		log.info("EmployeeServiceImpl findBypk method start");
		EmployeeDTO dto=dao.findBypk(pk);
		log.info("EmployeeServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public EmployeeDTO findByEmployeeName(String login) {
		log.info("EmployeeServiceImpl findByEmployeeName method start");
		EmployeeDTO dto=dao.findByEmail(login);
		log.info("EmployeeServiceImpl findByEmployeeName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(EmployeeDTO dto) throws DuplicateRecordException {
		log.info("EmployeeServiceImpl update method start");
		EmployeeDTO existDTO=dao.findByEmail(dto.getEmail());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Employee Name Already Exist");
		dao.update(dto);
		log.info("EmployeeServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<EmployeeDTO> list() {
		log.info("EmployeeServiceImpl list method start");
		List<EmployeeDTO> list=dao.list();
		log.info("EmployeeServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<EmployeeDTO> list(int pageNo, int pageSize) {
		log.info("EmployeeServiceImpl list method start");
		List<EmployeeDTO> list=dao.list(pageNo, pageSize);
		log.info("EmployeeServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<EmployeeDTO> search(EmployeeDTO dto) {
		log.info("EmployeeServiceImpl search method start");
		List<EmployeeDTO> list=dao.search(dto);
		log.info("EmployeeServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<EmployeeDTO> search(EmployeeDTO dto, int pageNo, int pageSize) {
		log.info("EmployeeServiceImpl search method start");
		List<EmployeeDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("EmployeeServiceImpl search method end");
		return list;
	}

	

	
}
