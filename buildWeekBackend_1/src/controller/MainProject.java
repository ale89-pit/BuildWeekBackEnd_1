package controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import DAO.BiglietteriaDAO;
import DAO.LuogoDAO;
import DAO.TitoloViaggioDAO;
import DAO.UtenteDAO;
import model.Abbonamento;
import model.Biglietteria;
import model.Biglietto;
import model.Luogo;
import model.Rivenditore;
import model.TitoloViaggio;
import model.Utente;
import utils.DurataAbb;
import utils.JpaUtil;
import utils.TipoNegozio;

public class MainProject {

	
	public static void main(String[] args) {
//		JpaUtil.getEntityManagerFactory().createEntityManager();

		UtenteDAO u = new UtenteDAO();
		TitoloViaggioDAO t = new TitoloViaggioDAO();
		BiglietteriaDAO bg = new BiglietteriaDAO();
		LuogoDAO lg = new LuogoDAO();
	
//		Utente u1 = new Utente("Emanuele", "Syrbe", LocalDate.of(1997, 1, 27));
//		u.save(u1);
		
//		Utente u2 = new Utente(LocalDate.of(2021, 5,22), "Alessio", "Pitorri", LocalDate.of(1989, 4, 27));
//		u.save(u2);
		Utente u2m = u.getByN_tessera(5003);
//		u2m.setRinnovoTessera(LocalDate.of(2023, 6, 10));
//		System.out.println("modifica data per rinnovo" + u2m.getNome() + u2m.getRinnovoTessera() + u2m.getScadenzaTessera());
//		u.update(u2m);

		
//		Luogo l1=new Luogo("Roma","Roma","Termini");
//		Luogo luogo=lg.getById(1);
//		lg.save(l1);
		
//		Biglietteria r1=new Rivenditore(TipoNegozio.EDICOLA, luogo);
//		bg.save(r1);
		
		Biglietteria biglietteria= bg.getById(1000);
//		TitoloViaggio t1 =new Biglietto(LocalDate.of(2023, 3, 15), biglietteria);
//		t.save(t1);
//		TitoloViaggio a2 = new Abbonamento(DurataAbb.MENSILI, biglietteria, u2m);
//		t.save(a2);
		
		TitoloViaggio a3 = new Abbonamento(DurataAbb.SETTIMANALI, biglietteria, u2m);
		emettiTitolo(a3);
		
		
	}
	
	
	static Abbonamento getUltimoAbbonamento() {
		List<TitoloViaggio> titoli = new TitoloViaggioDAO().getAllTitoli();
		List<Abbonamento> abbonamenti = titoli.stream().filter(titolo -> titolo instanceof Abbonamento)
										.map(titolo -> (Abbonamento)titolo).collect(Collectors.toList());
		
		Abbonamento ultimoAbb = abbonamenti.get(abbonamenti.size() - 1);
		
		return ultimoAbb;
	}
	
	static Biglietto getUltimoBiglietto() {
		List<TitoloViaggio> titoli = new TitoloViaggioDAO().getAllTitoli();
		List<Biglietto> biglietti = titoli.stream().filter(titolo -> titolo instanceof Biglietto)
										.map(titolo -> (Biglietto)titolo).collect(Collectors.toList());
		
		Biglietto ultimoBigl = biglietti.get(biglietti.size() - 1);
		
		return ultimoBigl;
	}
	
	static void emettiTitolo(TitoloViaggio t) {
		Utente titolare;
		TitoloViaggio lastSaved;
		Biglietteria biglietteriaEmissione;
		new TitoloViaggioDAO().save(t);
		System.out.print("TITOLO SALVATO!!!!!!!!!");
		if(t instanceof Abbonamento) {
			lastSaved = getUltimoAbbonamento();
			titolare = ((Abbonamento) lastSaved).getTitolare();
			List<Abbonamento> abbAcquistati = titolare.getAbbonamentiAcquistati();
			abbAcquistati.add((Abbonamento)lastSaved);
			titolare.setAbbonamentiAcquistati(abbAcquistati);
			new UtenteDAO().update(titolare);
			System.out.print("TITOLARE OK!!!!!!!!!");
		} else {
			lastSaved = getUltimoBiglietto();
		}
		biglietteriaEmissione = lastSaved.getLuogoEmissione();
		List<TitoloViaggio> titoliEmessi = biglietteriaEmissione.getTitoliEmessi();
		titoliEmessi.add(lastSaved);
		biglietteriaEmissione.setTitoliEmessi(titoliEmessi);
		new BiglietteriaDAO().update(biglietteriaEmissione);
		System.out.print("BIGLIETTERIA OK!!!!!!!!!");

	}
	
}
