package in.co.works.panda.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.works.panda.dto.CityDTO;
import in.co.works.panda.dto.CountryDTO;
import in.co.works.panda.dto.GuestDTO;
import in.co.works.panda.dto.StateDTO;

@Repository
public class GuestDAOImpl implements GuestDAOInt {

	private static Logger log = Logger.getLogger(GuestDAOImpl.class.getName());
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(GuestDTO dto) {
		log.info("GuestDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("GuestDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(GuestDTO dto) {
		log.info("GuestDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("GuestDAOImpl Delete method End");
		
	}

	@Override
	public GuestDTO findBypk(long pk) {
		log.info("GuestDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		GuestDTO dto = (GuestDTO) session.get(GuestDTO.class, pk);
		log.info("GuestDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public GuestDTO findByEmail(String email) {
		log.info("GuestDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(GuestDTO.class);
		criteria.add(Restrictions.eq("email", email));
		GuestDTO dto = (GuestDTO) criteria.uniqueResult();
		log.info("GuestDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(GuestDTO dto) {
		log.info("GuestDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("GuestDAOImpl update method End");
	}

	@Override
	public List<GuestDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<GuestDTO> list(int pageNo, int pageSize) {
		log.info("GuestDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<GuestDTO> query = session.createQuery("from GuestDTO", GuestDTO.class);
		List<GuestDTO> list = query.getResultList();
		log.info("GuestDAOImpl List method End");
		return list;
	}

	@Override
	public List<GuestDTO> search(GuestDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<GuestDTO> search(GuestDTO dto, int pageNo, int pageSize) {
		log.info("GuestDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		
		StringBuffer hql = new StringBuffer("from GuestDTO as u where 1=1 ");
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
			if (dto.getVip() != null && dto.getVip().length() > 0) {
				hql.append("and u.vip like '%" + dto.getVip() + "%'");
			}
			
		}
		Query<GuestDTO> query = session.createQuery(hql.toString(), GuestDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<GuestDTO> list = query.getResultList();
		log.info("GuestDAOImpl Search method End");
		return list;
	}

	@Override
	public List<CountryDTO> searchCountry(CountryDTO dto) {
		Session session = entityManager.unwrap(Session.class);
		Query<CountryDTO> query = session.createQuery("from CountryDTO", CountryDTO.class);
		List<CountryDTO> list = query.getResultList();
		return list;
	}

	@Override
	public List<StateDTO> searchState(StateDTO dto) {
		Session session = entityManager.unwrap(Session.class);
		Query<StateDTO> query = session.createQuery("from StateDTO", StateDTO.class);
		List<StateDTO> list = query.getResultList();
		return list;
	}

	@Override
	public List<CityDTO> searchCity(CityDTO dto) {
		Session session = entityManager.unwrap(Session.class);
		Query<CityDTO> query = session.createQuery("from CityDTO", CityDTO.class);
		List<CityDTO> list = query.getResultList();
		return list;
	}
	
	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		Session session=entityManager.unwrap(Session.class);
		GuestDTO person = (GuestDTO) session.get(GuestDTO.class, id);
        byte[] blob = person.getIdImage();
        Blob bBlob= new SerialBlob(blob);
		return bBlob;
	}

	@Override
	public CountryDTO findByCountryId(long pk) {
		log.info("GuestDAOImpl findByCountryId method Start");
		Session session = entityManager.unwrap(Session.class);
		CountryDTO dto = (CountryDTO) session.get(CountryDTO.class, pk);
		log.info("GuestDAOImpl findByCountryId method End");
		return dto;
	}

	@Override
	public StateDTO findByStateId(long pk) {
		log.info("GuestDAOImpl findByStateId method Start");
		Session session = entityManager.unwrap(Session.class);
		StateDTO dto = (StateDTO) session.get(StateDTO.class, pk);
		log.info("GuestDAOImpl findByStateId method End");
		return dto;
	}

	@Override
	public CityDTO findByCityId(long pk) {
		log.info("GuestDAOImpl findByCityId method Start");
		Session session = entityManager.unwrap(Session.class);
		CityDTO dto = (CityDTO) session.get(CityDTO.class, pk);
		log.info("GuestDAOImpl findByCityId method End");
		return dto;
	}


}
