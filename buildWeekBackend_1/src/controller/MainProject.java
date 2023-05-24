package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import DAO.BiglietteriaDAO;
import DAO.LuogoDAO;
import DAO.TitoloViaggioDAO;
import DAO.UtenteDAO;
import model.Abbonamento;
import model.Biglietteria;
import model.Biglietto;
import model.Distributore;
import model.Luogo;
import model.Rivenditore;
import model.TitoloViaggio;
import model.Utente;
import utils.DurataAbb;
import utils.JpaUtil;
import utils.TipoNegozio;

public class MainProject {

	
	public static void main(String[] args) {
		JpaUtil.getEntityManagerFactory().createEntityManager();

		UtenteDAO DAO_utente = new UtenteDAO();
		TitoloViaggioDAO DAO_titolo = new TitoloViaggioDAO();
		BiglietteriaDAO DAO_biglietteria = new BiglietteriaDAO();
		LuogoDAO DAO_luogo = new LuogoDAO();
	
		Utente u1 = new Utente("Emanuele", "Syrbe", LocalDate.of(1997, 1, 27));
		DAO_utente.save(u1);
		
		Utente u2 = new Utente(LocalDate.of(2021, 5,22), "Alessio", "Pitorri", LocalDate.of(1989, 4, 27));		
		DAO_utente.save(u2);
		
//		Utente u2mod = DAO_utente.getByN_tessera(5007).setRinnovoTessera(LocalDate.of(2023, 6, 10));
//		System.out.println("Modifica data per rinnovo " + u2mod.getNome() + u2mod.getRinnovoTessera() + u2mod.getScadenzaTessera());
//		DAO_utente.update(u2mod);

		Luogo l1=new Luogo("Roma","Roma","Termini");
		System.out.println(l1);
		DAO_luogo.save(l1);
		
		Biglietteria r1 = new Rivenditore(TipoNegozio.EDICOLA, l1);
		DAO_biglietteria.save(r1);
		Biglietteria d1 = new Distributore(l1);
		DAO_biglietteria.save(d1);
 		System.out.println(r1);
		
		TitoloViaggio b1 =new Biglietto(LocalDate.of(2023, 3, 15), r1);
		DAO_titolo.save(b1);

		TitoloViaggio a2 = new Abbonamento(DurataAbb.MENSILE, r1, u1);
		DAO_titolo.save(a2);
		
		TitoloViaggio a3 = new Abbonamento(DurataAbb.SETTIMANALE, r1, u1);
		DAO_titolo.save(a3);
		
//		biglietteria.emettiTitolo(DurataAbb.GIORNALIERO, u2mod.getTessera());
//		biglietteria.emettiTitolo(DurataAbb.GIORNALIERO, null);
		
		Utente u5 = DAO_utente.getByN_tessera(5000);
		System.out.println(u5);
		u5.getAbbonamentiAcquistati().forEach(a -> System.out.println(a));
		Biglietteria bigl1 = DAO_biglietteria.getById(1000);
		bigl1.getTitoliEmessi().forEach(a -> System.out.println(a)); 
		
		r1.emettiBiglietto( DAO_titolo,DAO_biglietteria);
		d1.emettiBiglietto(DAO_titolo, DAO_biglietteria);
		r1.emettiAbbonamento(DAO_titolo, DAO_biglietteria, DurataAbb.GIORNALIERO, u5);
		d1.emettiAbbonamento(DAO_titolo, DAO_biglietteria, DurataAbb.SETTIMANALE,u2 );
		
		
		Map<Integer,Long> ciao =DAO_titolo.getTitoliFromDate(LocalDate.of(2023,5,23),LocalDate.of(2023,5,25));
		System.out.println(ciao);
		
		
		List<Utente> listExparire=DAO_utente.getAllUsersExpaire();
		System.out.println(listExparire);
		
		
	}
	
	public static void start(UtenteDAO DAO_utente,TitoloViaggioDAO DAO_titoloViaggio,BiglietteriaDAO DAO_biglietteria,LuogoDAO DAO_luogo) {
		
		List<Utente> utenti = new ArrayList<>();

        utenti.add(new Utente( "Mario", "Rossi", LocalDate.of(1980, 3, 20)));
        utenti.add(new Utente("Laura", "Bianchi", LocalDate.of(1985, 9, 25)));
        utenti.add(new Utente(LocalDate.of(2023, 2, 28), "Luigi", "Verdi", LocalDate.of(1978, 12, 10)));
        utenti.add(new Utente(LocalDate.of(2022, 9, 5), "Giulia", "Russo", LocalDate.of(1982, 6, 15)));
        utenti.add(new Utente(LocalDate.of(2023, 1, 12), "Francesca", "Gialli", LocalDate.of(1983, 8, 1)));
        utenti.add(new Utente(LocalDate.of(2021, 12, 6), "Marco", "Neri", LocalDate.of(1975, 4, 5)));
        utenti.add(new Utente(LocalDate.of(2020, 4, 18), "Alessia", "Marroni", LocalDate.of(1981, 10, 30)));
        utenti.add(new Utente(LocalDate.of(2023, 3, 25), "Simone", "Blu", LocalDate.of(1987, 7, 8)));
        utenti.add(new Utente(LocalDate.of(2022, 8, 30), "Federica", "Arancio", LocalDate.of(1983, 2, 14)));
        utenti.add(new Utente("Giovanni", "Viola", LocalDate.of(1977, 1, 5)));

        for (Utente utente : utenti) {
        	DAO_utente.save(utente);
        }
        
        List<Luogo> luoghi = new ArrayList<>();

        luoghi.add(new Luogo("TO", "Torino", "Stazione Torino Porta Nuova"));
        luoghi.add(new Luogo("MI", "Milano", "Stazione Milano Centrale"));
        luoghi.add(new Luogo("RM", "Roma", "Stazione Roma Termini"));
        luoghi.add(new Luogo("NA", "Napoli", "Stazione Napoli Centrale"));
        luoghi.add(new Luogo("FI", "Firenze", "Stazione Firenze Santa Maria Novella"));
        luoghi.add(new Luogo("VE", "Venezia", "Stazione Venezia Santa Lucia"));
        luoghi.add(new Luogo("BO", "Bologna", "Stazione Bologna Centrale"));
        luoghi.add(new Luogo("PA", "Palermo", "Stazione Palermo Centrale"));
        luoghi.add(new Luogo("CA", "Cagliari", "Stazione Cagliari Centrale"));
        luoghi.add(new Luogo("TO", "Torino", "Stazione Torino Porta Susa"));

        for (Luogo luogo : luoghi) {
        	DAO_luogo.save(luogo);
        }
        
        
	}
}
