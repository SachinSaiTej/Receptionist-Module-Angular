package in.co.works.panda.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.works.panda.dto.FloorDTO;
import in.co.works.panda.dto.PaidServiceDTO;

@Repository
public class PaidServiceDAOImpl implements PaidServiceDAOInt {

	private static Logger log = Logger.getLogger(PaidServiceDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(PaidServiceDTO dto) {
		log.info("PaidServiceDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("PaidServiceDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(PaidServiceDTO dto) {
		log.info("PaidServiceDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("PaidServiceDAOImpl Delete method End");
		
	}

	@Override
	public PaidServiceDTO findBypk(long pk) {
		log.info("PaidServiceDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		PaidServiceDTO dto = (PaidServiceDTO) session.get(PaidServiceDTO.class, pk);
		log.info("PaidServiceDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public PaidServiceDTO findByName(String name) {
		log.info("PaidServiceDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PaidServiceDTO.class);
		criteria.add(Restrictions.eq("title", name));
		PaidServiceDTO dto = (PaidServiceDTO) criteria.uniqueResult();
		log.info("PaidServiceDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(PaidServiceDTO dto) {
		log.info("PaidServiceDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("PaidServiceDAOImpl update method End");
	}

	@Override
	public List<PaidServiceDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<PaidServiceDTO> list(int pageNo, int pageSize) {
		log.info("PaidServiceDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<PaidServiceDTO> query = session.createQuery("from PaidServiceDTO", PaidServiceDTO.class);
		List<PaidServiceDTO> list = query.getResultList();
		log.info("PaidServiceDAOImpl List method End");
		return list;
	}

	@Override
	public List<PaidServiceDTO> search(PaidServiceDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<PaidServiceDTO> search(PaidServiceDTO dto, int pageNo, int pageSize) {
		log.info("PaidServiceDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from PaidServiceDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getTitle() != null && dto.getTitle().length() > 0) {
				hql.append("and u.title like '%" + dto.getTitle() + "%'");
			}
		}
		Query<PaidServiceDTO> query = session.createQuery(hql.toString(), PaidServiceDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<PaidServiceDTO> list = query.getResultList();
		log.info("PaidServiceDAOImpl Search method End");
		return list;
	}

}
