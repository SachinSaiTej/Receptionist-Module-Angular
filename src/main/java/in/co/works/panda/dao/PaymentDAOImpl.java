package in.co.works.panda.dao;

import java.util.Iterator;
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

import in.co.works.panda.dto.PaymentDTO;
import in.co.works.panda.dto.UserDTO;
import in.co.works.panda.util.DataUtility;

@Repository
public class PaymentDAOImpl implements PaymentDAOInt {

	private static Logger log = Logger.getLogger(PaymentDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(PaymentDTO dto) {
		log.info("PaymentDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("PaymentDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(PaymentDTO dto) {
		log.info("PaymentDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("PaymentDAOImpl Delete method End");
		
	}

	@Override
	public PaymentDTO findBypk(long pk) {
		log.info("PaymentDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		PaymentDTO dto = (PaymentDTO) session.get(PaymentDTO.class, pk);
		log.info("PaymentDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public PaymentDTO findByName(String name) {
		log.info("PaymentDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PaymentDTO.class);
		criteria.add(Restrictions.eq("name", name));
		PaymentDTO dto = (PaymentDTO) criteria.uniqueResult();
		log.info("PaymentDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(PaymentDTO dto) {
		log.info("PaymentDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("PaymentDAOImpl update method End");
	}

	@Override
	public List<PaymentDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<PaymentDTO> list(int pageNo, int pageSize) {
		log.info("PaymentDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<PaymentDTO> query = session.createQuery("from PaymentDTO", PaymentDTO.class);
		List<PaymentDTO> list = query.getResultList();
		log.info("PaymentDAOImpl List method End");
		return list;
	}

	@Override
	public List<PaymentDTO> search(PaymentDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<PaymentDTO> search(PaymentDTO dto, int pageNo, int pageSize) {
		log.info("PaymentDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from PaymentDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getGuestId() > 0) {
				hql.append("and u.guestId = " + dto.getGuestId());
			}
		}
		Query<PaymentDTO> query = session.createQuery(hql.toString(), PaymentDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<PaymentDTO> list = query.getResultList();
		log.info("PaymentDAOImpl Search method End");
		return list;
	}

	@Override
	public long getTotalAmount() {
		long amount=0;
		Session session = entityManager.unwrap(Session.class);
		Query<PaymentDTO> query = session.createQuery("from PaymentDTO", PaymentDTO.class);
		List<PaymentDTO> list = query.getResultList();
		Iterator<PaymentDTO> it=list.iterator();
		while (it.hasNext()) {
			PaymentDTO paymentDTO = (PaymentDTO) it.next();
			amount +=DataUtility.getLong(paymentDTO.getAmount());
		} 
		return amount;
	}

}
