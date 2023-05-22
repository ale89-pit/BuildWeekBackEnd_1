package InterfaceDAO;

import java.util.List;

import model.TitoloViaggio;
import model.Utente;

public interface IUtenteDAO {

		public void save(Utente u);
		public Utente getByN_tessera(int n_tessera);
		public void delete(Utente u);
		public void update(Utente u);
		public List<TitoloViaggio>  getTitoliAcquistati();
		
}
