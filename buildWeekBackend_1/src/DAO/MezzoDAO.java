package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import InterfaceDAO.IMezziDAO;
import model.Mezzo;
import utils.JpaUtil;
import utils.TipoMezzo;

public class MezzoDAO implements IMezziDAO{
	static Logger log=LoggerFactory.getLogger(MezzoDAO.class);
	@Override
	public void save(Mezzo m) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		log.info("mezzo aggiunto nel DB: "+m.getId()+" : "+m.getTipoMezzo());
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			em.close();
		}
	}

	@Override
	public Mezzo getById(Integer id) {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
	
			Mezzo m= em.find(Mezzo.class, id);
	
		log.info("mezzo Trovato nel DB");
		return m;
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			em.close();
			
		}
		return null;
	}
	
	@Override
	public void delete(Mezzo m) {

		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		log.info("mezzo Eliminato nel DB: "+m.getId()+" : "+m.getTipoMezzo());
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Mezzo> getAllMezzi() {
		
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
		
			Query q=em.createQuery("SELECT m FROM MEZZO m");
			
			return q.getResultList();
			
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			em.close();
		}
		
		return null;
	}

	@Override
	public List<Mezzo> getAllAutobus() {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
		
			Query q=em.createQuery("SELECT m FROM MEZZO m WHERE m.tipomezzo=m.TipoMezzo.AUTOBUS");
			
			return q.getResultList();
			
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			em.close();
		}

		return null;
	}

	@Override
	public List<Mezzo> getAllTram() {
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
		
			Query q=em.createQuery("SELECT m FROM MEZZO m WHERE m.tipomezzo=m.TipoMezzo.TRAM");
			
			return q.getResultList();
			
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			em.close();
		}
		return null;
	}

	@Override
	public void update(Mezzo m) {
		// TODO Auto-generated method stub
		EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		log.info("mezzo Modificato nel DB: "+m.getId()+" : "+m.getTipoMezzo()+" Stato: "+m.getStato());
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			em.close();
		}
		
	}

}
