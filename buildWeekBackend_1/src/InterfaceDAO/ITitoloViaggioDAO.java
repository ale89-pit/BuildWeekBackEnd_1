package InterfaceDAO;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Abbonamento;
import model.Biglietto;
import model.TitoloViaggio;
import model.Utente;

public interface ITitoloViaggioDAO {
	public void save(TitoloViaggio ti);
	public TitoloViaggio getByCodice(Integer codice);
	public void delete(TitoloViaggio ti);
	public void update(TitoloViaggio ti);
	public List<TitoloViaggio>  getAllTitoli();
	public List<Biglietto>  getAllBiglietti();
	public List<Abbonamento>  getAllAbbonamenti();
	public Map<Integer,Long> getTitoliFromDate(LocalDate data1,LocalDate data2);
	public List<Biglietto> getTitoliFromMezzo(Integer id);
}
