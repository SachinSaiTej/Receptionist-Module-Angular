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

import in.co.works.panda.dto.PaidServiceDTO;
import in.co.works.panda.dto.RoomTypeDTO;

@Repository
public class RoomTypeDAOImpl implements RoomTypeDAOInt {

	private static Logger log = Logger.getLogger(RoomTypeDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(RoomTypeDTO dto) {
		log.info("RoomTypeDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("RoomTypeDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(RoomTypeDTO dto) {
		log.info("RoomTypeDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("RoomTypeDAOImpl Delete method End");
		
	}

	@Override
	public RoomTypeDTO findBypk(long pk) {
		log.info("RoomTypeDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		RoomTypeDTO dto = (RoomTypeDTO) session.get(RoomTypeDTO.class, pk);
		log.info("RoomTypeDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public RoomTypeDTO findByTitle(String title) {
		log.info("RoomTypeDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(RoomTypeDTO.class);
		criteria.add(Restrictions.eq("title", title));
		RoomTypeDTO dto = (RoomTypeDTO) criteria.uniqueResult();
		log.info("RoomTypeDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(RoomTypeDTO dto) {
		log.info("RoomTypeDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("RoomTypeDAOImpl update method End");
	}

	@Override
	public List<RoomTypeDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<RoomTypeDTO> list(int pageNo, int pageSize) {
		log.info("RoomTypeDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<RoomTypeDTO> query = session.createQuery("from RoomTypeDTO", RoomTypeDTO.class);
		List<RoomTypeDTO> list = query.getResultList();
		log.info("RoomTypeDAOImpl List method End");
		return list;
	}

	@Override
	public List<RoomTypeDTO> search(RoomTypeDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<RoomTypeDTO> search(RoomTypeDTO dto, int pageNo, int pageSize) {
		log.info("RoomTypeDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from RoomTypeDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getTitle() != null && dto.getTitle().length() > 0) {
				hql.append("and u.title like '%" + dto.getTitle() + "%'");
			}
		}
		Query<RoomTypeDTO> query = session.createQuery(hql.toString(), RoomTypeDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<RoomTypeDTO> list = query.getResultList();
		log.info("RoomTypeDAOImpl Search method End");
		return list;
	}

}
