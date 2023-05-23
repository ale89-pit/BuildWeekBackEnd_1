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
//		Luogo luogo = DAO_luogo.getById(1);
		System.out.println(l1);
		DAO_luogo.save(l1);
		
		Biglietteria r1 = new Rivenditore(TipoNegozio.EDICOLA, l1);
		DAO_biglietteria.save(r1);
		
//		Biglietteria biglietteria= DAO_biglietteria.getById(1003);
 		System.out.println(r1);
		
//		biglietteria.getTitoliEmessi().forEach(b-> System.out.println(b));;
		TitoloViaggio b1 =new Biglietto(LocalDate.of(2023, 3, 15), r1);
		DAO_titolo.save(b1);

		TitoloViaggio a2 = new Abbonamento(DurataAbb.MENSILI, r1, u1);
		DAO_titolo.save(a2);
		
//		TitoloViaggio a3 = new Abbonamento(DurataAbb.SETTIMANALI, biglietteria, u2m);
//		DAO_titolo.save(a3);
		
//		biglietteria.emettiTitolo(DurataAbb.GIORNALIERO, u2mod.getTessera());
//		biglietteria.emettiTitolo(DurataAbb.GIORNALIERO, null);
		
		
		//u1.getAbbonamentiAcquistati().forEach(a->System.out.println(a));
		Utente u5 = DAO_utente.getByN_tessera(5000);
		System.out.println(u5);
;	}
	
	
}
