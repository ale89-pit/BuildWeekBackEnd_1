package InterfaceDAO;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.TitoloViaggio;
import model.Utente;

public interface ITitoloViaggioDAO {
	public void save(TitoloViaggio ti);
	public TitoloViaggio getByCodice(Integer codice);
	public void delete(TitoloViaggio ti);
	public List<TitoloViaggio>  getAllTitoli();
	public Map<Integer,Long> getTitoliFromDate(LocalDate data1,LocalDate data2);
}
