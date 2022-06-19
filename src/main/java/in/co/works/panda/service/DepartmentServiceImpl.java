package in.co.works.panda.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.works.panda.dao.DepartmentDAOInt;
import in.co.works.panda.dto.DepartmentDTO;
import in.co.works.panda.exception.DuplicateRecordException;


@Service
public class DepartmentServiceImpl implements DepartmentServiceInt {

	private static Logger log=Logger.getLogger(DepartmentServiceImpl.class.getName());
	
	@Autowired
	private DepartmentDAOInt dao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(DepartmentDTO dto) throws DuplicateRecordException {
		log.info("DepartmentServiceImpl Add method start");
		DepartmentDTO existDTO=dao.findByName(dto.getName());
		if(existDTO !=null)
			throw new DuplicateRecordException("Name Already Exist");
		long pk=dao.add(dto);
		log.info("DepartmentServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(DepartmentDTO dto) {
		log.info("DepartmentServiceImpl Delete method start");
		dao.delete(dto);
		log.info("DepartmentServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public DepartmentDTO findBypk(long pk) {
		log.info("DepartmentServiceImpl findBypk method start");
		DepartmentDTO dto=dao.findBypk(pk);
		log.info("DepartmentServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public DepartmentDTO findByName(String name) {
		log.info("DepartmentServiceImpl findByDepartmentName method start");
		DepartmentDTO dto=dao.findByName(name);
		log.info("DepartmentServiceImpl findByDepartmentName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(DepartmentDTO dto) throws DuplicateRecordException {
		log.info("DepartmentServiceImpl update method start");
		DepartmentDTO existDTO=dao.findByName(dto.getName());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Department Name Already Exist");
		dao.update(dto);
		log.info("DepartmentServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<DepartmentDTO> list() {
		log.info("DepartmentServiceImpl list method start");
		List<DepartmentDTO> list=dao.list();
		log.info("DepartmentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<DepartmentDTO> list(int pageNo, int pageSize) {
		log.info("DepartmentServiceImpl list method start");
		List<DepartmentDTO> list=dao.list(pageNo, pageSize);
		log.info("DepartmentServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<DepartmentDTO> search(DepartmentDTO dto) {
		log.info("DepartmentServiceImpl search method start");
		List<DepartmentDTO> list=dao.search(dto);
		log.info("DepartmentServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<DepartmentDTO> search(DepartmentDTO dto, int pageNo, int pageSize) {
		log.info("DepartmentServiceImpl search method start");
		List<DepartmentDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("DepartmentServiceImpl search method end");
		return list;
	}

	

	
}
