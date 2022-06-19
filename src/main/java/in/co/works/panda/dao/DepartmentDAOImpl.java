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

import in.co.works.panda.dto.DepartmentDTO;
import in.co.works.panda.dto.GuestDTO;

@Repository
public class DepartmentDAOImpl implements DepartmentDAOInt {

	private static Logger log = Logger.getLogger(DepartmentDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(DepartmentDTO dto) {
		log.info("DepartmentDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("DepartmentDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(DepartmentDTO dto) {
		log.info("DepartmentDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("DepartmentDAOImpl Delete method End");
		
	}

	@Override
	public DepartmentDTO findBypk(long pk) {
		log.info("DepartmentDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		DepartmentDTO dto = (DepartmentDTO) session.get(DepartmentDTO.class, pk);
		log.info("DepartmentDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public DepartmentDTO findByName(String name) {
		log.info("DepartmentDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(DepartmentDTO.class);
		criteria.add(Restrictions.eq("name", name));
		DepartmentDTO dto = (DepartmentDTO) criteria.uniqueResult();
		log.info("DepartmentDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(DepartmentDTO dto) {
		log.info("DepartmentDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("DepartmentDAOImpl update method End");
	}

	@Override
	public List<DepartmentDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<DepartmentDTO> list(int pageNo, int pageSize) {
		log.info("DepartmentDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<DepartmentDTO> query = session.createQuery("from DepartmentDTO", DepartmentDTO.class);
		List<DepartmentDTO> list = query.getResultList();
		log.info("DepartmentDAOImpl List method End");
		return list;
	}

	@Override
	public List<DepartmentDTO> search(DepartmentDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<DepartmentDTO> search(DepartmentDTO dto, int pageNo, int pageSize) {
		log.info("DepartmentDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from DepartmentDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				hql.append("and u.name like '%" + dto.getName() + "%'");
			}
			
		}
		Query<DepartmentDTO> query = session.createQuery(hql.toString(), DepartmentDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<DepartmentDTO> list = query.getResultList();
		log.info("DepartmentDAOImpl Search method End");
		return list;
	}

}
