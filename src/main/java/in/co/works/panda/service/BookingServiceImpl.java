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

import in.co.works.panda.dao.BookingDAOInt;
import in.co.works.panda.dto.BookingDTO;
import in.co.works.panda.exception.DuplicateRecordException;
import in.co.works.panda.util.EmailBuilder;


@Service
public class BookingServiceImpl implements BookingServiceInt {

	private static Logger log=Logger.getLogger(BookingServiceImpl.class.getName());
	
	@Autowired
	private BookingDAOInt dao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	@Transactional
	public long add(BookingDTO dto) throws DuplicateRecordException {
		log.info("BookingServiceImpl Add method start");
		/*
		 * BookingDTO existDTO=dao.findByName(dto.getName()); if(existDTO !=null) throw
		 * new DuplicateRecordException("Name Already Exist");
		 */
		long pk=dao.add(dto);
		log.info("BookingServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(BookingDTO dto) {
		log.info("BookingServiceImpl Delete method start");
		dao.delete(dto);
		log.info("BookingServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public BookingDTO findBypk(long pk) {
		log.info("BookingServiceImpl findBypk method start");
		BookingDTO dto=dao.findBypk(pk);
		log.info("BookingServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public BookingDTO findByName(String name) {
		log.info("BookingServiceImpl findByBookingName method start");
		BookingDTO dto=dao.findByName(name);
		log.info("BookingServiceImpl findByBookingName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(BookingDTO dto) throws DuplicateRecordException {
		log.info("BookingServiceImpl update method start");
		/*
		 * BookingDTO existDTO=dao.findByName(dto.getName()); if(existDTO !=null &&
		 * dto.getId()!=existDTO.getId()) throw new
		 * DuplicateRecordException("Booking Name Already Exist");
		 */
		dao.update(dto);
		log.info("BookingServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<BookingDTO> list() {
		log.info("BookingServiceImpl list method start");
		List<BookingDTO> list=dao.list();
		log.info("BookingServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookingDTO> list(int pageNo, int pageSize) {
		log.info("BookingServiceImpl list method start");
		List<BookingDTO> list=dao.list(pageNo, pageSize);
		log.info("BookingServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookingDTO> search(BookingDTO dto) {
		log.info("BookingServiceImpl search method start");
		List<BookingDTO> list=dao.search(dto);
		log.info("BookingServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookingDTO> search(BookingDTO dto, int pageNo, int pageSize) {
		log.info("BookingServiceImpl search method start");
		List<BookingDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("BookingServiceImpl search method end");
		return list;
	}

	

	
}
