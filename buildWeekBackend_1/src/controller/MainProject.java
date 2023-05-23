package controller;

import java.time.LocalDate;

import DAO.BiglietteriaDAO;
import DAO.LuogoDAO;
import DAO.TitoloViaggioDAO;
import DAO.UtenteDAO;
import model.Biglietteria;
import model.Biglietto;
import model.Luogo;
import model.Rivenditore;
import model.TitoloViaggio;
import model.Utente;
import utils.JpaUtil;
import utils.TipoNegozio;

public class MainProject {

	
	public static void main(String[] args) {
		JpaUtil.getEntityManagerFactory().createEntityManager();

		UtenteDAO u = new UtenteDAO();
		TitoloViaggioDAO t = new TitoloViaggioDAO();
		BiglietteriaDAO bg = new BiglietteriaDAO();
		LuogoDAO lg = new LuogoDAO();
	
		Utente u1 = new Utente("Emanuele", "Syrbe", LocalDate.of(1997, 01, 27));
		
		Utente u2 = new Utente(LocalDate.of(2021, 5,22), "Alessio", "Pitorri", LocalDate.of(1989, 4, 27));
//		u2.setRinnovoTessera(LocalDate.of(2023, 06, 10));
//		Utente u2m = u.getByN_tessera(5004);
//		u2m.setRinnovoTessera(LocalDate.of(2023, 6, 10));
//		System.out.println("modifica data per rinnovo" + u2m.getNome() + u2m.getRinnovoTessera() + u2m.getScadenzaTessera());
//		u.update(u2m);
//		u2m.setRinnovoTessera(LocalDate.of(2023, 06, 10));
		
		
		Luogo l1=new Luogo("Roma","Roma","Termini");
		
		Luogo luogo=lg.getById(1);
		Biglietteria r1=new Rivenditore(TipoNegozio.EDICOLA, luogo);
		Biglietteria biglietteria= bg.getById(1003);
		TitoloViaggio t1 =new Biglietto(LocalDate.of(2023, 3, 15), biglietteria);
		
		
		//lg.save(l1);
		//bg.save(r1);
		t.save(t1);
		
	//	u.save(u1);
	//	u.save(u2);
	}

}
