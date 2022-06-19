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

import in.co.works.panda.dto.EmployeeDTO;
import in.co.works.panda.dto.GuestDTO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAOInt {

	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(EmployeeDTO dto) {
		log.info("EmployeeDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("EmployeeDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(EmployeeDTO dto) {
		log.info("EmployeeDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("EmployeeDAOImpl Delete method End");
		
	}

	@Override
	public EmployeeDTO findBypk(long pk) {
		log.info("EmployeeDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		EmployeeDTO dto = (EmployeeDTO) session.get(EmployeeDTO.class, pk);
		log.info("EmployeeDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public EmployeeDTO findByEmail(String email) {
		log.info("EmployeeDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(EmployeeDTO.class);
		criteria.add(Restrictions.eq("email", email));
		EmployeeDTO dto = (EmployeeDTO) criteria.uniqueResult();
		log.info("EmployeeDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(EmployeeDTO dto) {
		log.info("EmployeeDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("EmployeeDAOImpl update method End");
	}

	@Override
	public List<EmployeeDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<EmployeeDTO> list(int pageNo, int pageSize) {
		log.info("EmployeeDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<EmployeeDTO> query = session.createQuery("from EmployeeDTO", EmployeeDTO.class);
		List<EmployeeDTO> list = query.getResultList();
		log.info("EmployeeDAOImpl List method End");
		return list;
	}

	@Override
	public List<EmployeeDTO> search(EmployeeDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<EmployeeDTO> search(EmployeeDTO dto, int pageNo, int pageSize) {
		log.info("EmployeeDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from EmployeeDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				hql.append("and u.firstName like '%" + dto.getFirstName() + "%'");
			}
			if (dto.getEmail() != null && dto.getEmail().length() > 0) {
				hql.append("and u.email like '%" + dto.getEmail() + "%'");
			}
		}
		Query<EmployeeDTO> query = session.createQuery(hql.toString(), EmployeeDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<EmployeeDTO> list = query.getResultList();
		log.info("EmployeeDAOImpl Search method End");
		return list;
	}

}
