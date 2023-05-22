package controller;

import java.time.LocalDate;

import DAO.UtenteDAO;
import model.Utente;
import utils.JpaUtil;

public class MainProject {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JpaUtil.getEntityManagerFactory().createEntityManager();

		UtenteDAO u = new UtenteDAO();
		
		Utente u1 = new Utente("Emanuele", "Syrbe", LocalDate.of(1997, 01, 27));
		
		Utente u2 = new Utente(LocalDate.of(2021, 05,22), "Emanuele", "Syrbe", LocalDate.of(1997, 01, 27));
		
		Utente u2m = u.getByN_tessera(u2.getTessera());
		u2m.setRinnovoTessera(LocalDate.of(2023, 06, 10));
		u.update(u2m);
		u.save(u1);
	}

}
