package in.co.works.panda.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.works.panda.dto.BookingDTO;
import in.co.works.panda.dto.UserDTO;

@Repository
public class BookingDAOImpl implements BookingDAOInt {

	private static Logger log = Logger.getLogger(BookingDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(BookingDTO dto) {
		log.info("BookingDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("BookingDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(BookingDTO dto) {
		log.info("BookingDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("BookingDAOImpl Delete method End");
		
	}

	@Override
	public BookingDTO findBypk(long pk) {
		log.info("BookingDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		BookingDTO dto = (BookingDTO) session.get(BookingDTO.class, pk);
		log.info("BookingDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public BookingDTO findByName(String name) {
		log.info("BookingDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BookingDTO.class);
		criteria.add(Restrictions.eq("name", name));
		BookingDTO dto = (BookingDTO) criteria.uniqueResult();
		log.info("BookingDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(BookingDTO dto) {
		log.info("BookingDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("BookingDAOImpl update method End");
	}

	@Override
	public List<BookingDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BookingDTO> list(int pageNo, int pageSize) {
		log.info("BookingDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<BookingDTO> query = session.createQuery("from BookingDTO order by id desc", BookingDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<BookingDTO> list = query.getResultList();
		log.info("BookingDAOImpl List method End");
		return list;
	}

	@Override
	public List<BookingDTO> search(BookingDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<BookingDTO> search(BookingDTO dto, int pageNo, int pageSize) {
		log.info("BookingDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from BookingDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getGuestId() > 0) {
				hql.append("and u.guestId = " + dto.getGuestId());
			}
			if (dto.getBookingDate() !=null && dto.getBookingDate().getTime()>0) {
				hql.append("and u.bookingDate = " + dto.getBookingDate());
			}
			if (dto.getBookingNumber() !=null && dto.getBookingNumber().length()>0) {
				hql.append("and u.bookingNumber = " + dto.getBookingNumber());
			}
		}
		Query<BookingDTO> query = session.createQuery(hql.toString(), BookingDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<BookingDTO> list = query.getResultList();
		log.info("BookingDAOImpl Search method End");
		return list;
	}

}
