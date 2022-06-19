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

import in.co.works.panda.dto.EmployeeDTO;
import in.co.works.panda.dto.FloorDTO;

@Repository
public class FloorDAOImpl implements FloorDAOInt {

	private static Logger log = Logger.getLogger(FloorDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(FloorDTO dto) {
		log.info("FloorDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("FloorDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(FloorDTO dto) {
		log.info("FloorDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("FloorDAOImpl Delete method End");
		
	}

	@Override
	public FloorDTO findBypk(long pk) {
		log.info("FloorDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		FloorDTO dto = (FloorDTO) session.get(FloorDTO.class, pk);
		log.info("FloorDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public FloorDTO findByName(String name) {
		log.info("FloorDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FloorDTO.class);
		criteria.add(Restrictions.eq("name", name));
		FloorDTO dto = (FloorDTO) criteria.uniqueResult();
		log.info("FloorDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(FloorDTO dto) {
		log.info("FloorDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("FloorDAOImpl update method End");
	}

	@Override
	public List<FloorDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<FloorDTO> list(int pageNo, int pageSize) {
		log.info("FloorDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<FloorDTO> query = session.createQuery("from FloorDTO", FloorDTO.class);
		List<FloorDTO> list = query.getResultList();
		log.info("FloorDAOImpl List method End");
		return list;
	}

	@Override
	public List<FloorDTO> search(FloorDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<FloorDTO> search(FloorDTO dto, int pageNo, int pageSize) {
		log.info("FloorDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from FloorDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				hql.append("and u.name like '%" + dto.getName() + "%'");
			}
			
		}
		Query<FloorDTO> query = session.createQuery(hql.toString(), FloorDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<FloorDTO> list = query.getResultList();
		log.info("FloorDAOImpl Search method End");
		return list;
	}

}
