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

import in.co.works.panda.dto.PriceManagerDTO;
import in.co.works.panda.dto.RoomDTO;

@Repository
public class PriceManagerDAOImpl implements PriceManagerDAOInt {

	private static Logger log = Logger.getLogger(PriceManagerDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(PriceManagerDTO dto) {
		log.info("PriceManagerDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("PriceManagerDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(PriceManagerDTO dto) {
		log.info("PriceManagerDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("PriceManagerDAOImpl Delete method End");
		
	}

	@Override
	public PriceManagerDTO findBypk(long pk) {
		log.info("PriceManagerDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		PriceManagerDTO dto = (PriceManagerDTO) session.get(PriceManagerDTO.class, pk);
		log.info("PriceManagerDAOImpl FindByPk method End");
		return dto;
	}
	
	@Override
	public PriceManagerDTO findBypkRoomTypeId(long id) {
		log.info("PriceManagerDAOImpl findBypkRoomTypeId method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PriceManagerDTO.class);
		criteria.add(Restrictions.eq("roomTypeId", id));
		PriceManagerDTO dto = (PriceManagerDTO) criteria.uniqueResult();
		log.info("PriceManagerDAOImpl findBypkRoomTypeId method End");
		return dto;
	}

	@Override
	public PriceManagerDTO findByName(String name) {
		log.info("PriceManagerDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PriceManagerDTO.class);
		criteria.add(Restrictions.eq("name", name));
		PriceManagerDTO dto = (PriceManagerDTO) criteria.uniqueResult();
		log.info("PriceManagerDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(PriceManagerDTO dto) {
		log.info("PriceManagerDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("PriceManagerDAOImpl update method End");
	}

	@Override
	public List<PriceManagerDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<PriceManagerDTO> list(int pageNo, int pageSize) {
		log.info("PriceManagerDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<PriceManagerDTO> query = session.createQuery("from PriceManagerDTO", PriceManagerDTO.class);
		List<PriceManagerDTO> list = query.getResultList();
		log.info("PriceManagerDAOImpl List method End");
		return list;
	}

	@Override
	public List<PriceManagerDTO> search(PriceManagerDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<PriceManagerDTO> search(PriceManagerDTO dto, int pageNo, int pageSize) {
		log.info("PriceManagerDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from PriceManagerDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getRoomTypeId() > 0) {
				hql.append("and u.roomTypeId = " + dto.getRoomTypeId());
			}
			
		}
		Query<PriceManagerDTO> query = session.createQuery(hql.toString(), PriceManagerDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<PriceManagerDTO> list = query.getResultList();
		log.info("PriceManagerDAOImpl Search method End");
		return list;
	}

	

}
