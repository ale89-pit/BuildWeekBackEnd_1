package DAO;


import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.*;

import InterfaceDAO.IUtenteDAO;
import model.TitoloViaggio;
import model.Utente;
import utils.JpaUtil;

public class UtenteDAO implements IUtenteDAO {
 private static Logger log=LoggerFactory.getLogger(UtenteDAO.class);
 private static EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void save(Utente u) {
		
		try {
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			log.info("utente: ");
			
		}catch(Exception ex) {
			log.error(ex.getMessage());
		}finally{
			em.close();
		}
		
	}

	@Override
	public Utente getByN_tessera(int n_tessera) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utente u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Utente u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TitoloViaggio> getTitoliAcquistati() {
		// TODO Auto-generated method stub
		return null;
	}

}
