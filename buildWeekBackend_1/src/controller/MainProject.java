package controller;

import java.time.LocalDate;

import DAO.UtenteDAO;
import model.Biglietto;
import model.Utente;
import utils.JpaUtil;

public class MainProject {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JpaUtil.getEntityManagerFactory().createEntityManager();

		UtenteDAO u = new UtenteDAO();
		
		Utente u1 = new Utente("Emanuele", "Syrbe", LocalDate.of(1997, 01, 27));
		
		Utente u2 = new Utente(LocalDate.of(2021, 5,22), "Alessio", "Pitorri", LocalDate.of(1989, 4, 27));
//		u2.setRinnovoTessera(LocalDate.of(2023, 06, 10));
		Utente u2m = u.getByN_tessera(5004);
		u2m.setRinnovoTessera(LocalDate.of(2023, 6, 10));
		System.out.println("modifica data per rinnovo" + u2m.getNome() + u2m.getRinnovoTessera() + u2m.getScadenzaTessera());
		u.update(u2m);
//		u2m.setRinnovoTessera(LocalDate.of(2023, 06, 10));
		Biglietto n1 = new Biglietto();
		//		

//		u.save(u1);
//		u.save(u2);
	}

}
