package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import DAO.BiglietteriaDAO;
import DAO.LuogoDAO;
import DAO.MezzoDAO;
import DAO.TitoloViaggioDAO;
import DAO.UtenteDAO;
import model.Abbonamento;
import model.Biglietteria;
import model.Biglietto;
import model.Distributore;
import model.Luogo;
import model.Mezzo;
import model.Rivenditore;
import model.TitoloViaggio;
import model.Utente;
import utils.DurataAbb;
import utils.JpaUtil;
import utils.TipoMezzo;
import utils.TipoNegozio;

public class MainProject {

	
	public static void main(String[] args) {
		JpaUtil.getEntityManagerFactory().createEntityManager();

		UtenteDAO DAO_utente = new UtenteDAO();
		TitoloViaggioDAO DAO_titolo = new TitoloViaggioDAO();
		BiglietteriaDAO DAO_biglietteria = new BiglietteriaDAO();
		LuogoDAO DAO_luogo = new LuogoDAO();
		MezzoDAO DAO_mezzo=new MezzoDAO();
	
		

		riempiDB(DAO_utente, DAO_titolo, DAO_biglietteria, DAO_luogo,DAO_mezzo);
		
		Map<Integer,Long> ricercaTitoliData = DAO_titolo.getTitoliFromDate(LocalDate.of(2023,5,23),LocalDate.of(2023,5,25));

		
	//	List<Utente> listExparire=DAO_utente.getAllUsersExpaire();
	//	System.out.println(listExparire);
		
		
	}
	
	public static void riempiDB(UtenteDAO DAO_utente,TitoloViaggioDAO DAO_titoloViaggio,BiglietteriaDAO DAO_biglietteria,LuogoDAO DAO_luogo,MezzoDAO DAO_mezzo) {
	

		
		
		
			List<Luogo> luoghi = new ArrayList<>();

			luoghi.add(new Luogo("TO", "Torino", "Torino Porta Nuova"));
			luoghi.add(new Luogo("MI", "Milano", "Milano Centrale"));
			luoghi.add(new Luogo("RM", "Roma", "Roma Termini"));
			luoghi.add(new Luogo("NA", "Napoli", "Napoli Centrale"));
			luoghi.add(new Luogo("FI", "Firenze", "Firenze Santa Maria Novella"));

			for (Luogo luogo : luoghi) {
				DAO_luogo.save(luogo);
			}
			
		
		
		List<Utente> utenti = new ArrayList<>();
	    utenti.add(new Utente( "Emanuele", "Rossi", LocalDate.of(1997, 1, 27)));
        utenti.add(new Utente("Sara", "Bianchi", LocalDate.of(1997, 9, 23)));
        utenti.add(new Utente("Alessio", "Viola", LocalDate.of(1989, 4, 27)));
        utenti.add(new Utente(LocalDate.of(2023, 2, 28), "Marco", "Verdi", LocalDate.of(1978, 12, 10)));
        utenti.add(new Utente(LocalDate.of(2023, 1, 12), "Luigi", "Gialli", LocalDate.of(1983, 8, 1)));
        utenti.add(new Utente(LocalDate.of(2023, 3, 25), "Flavio", "Blu", LocalDate.of(1987, 7, 8)));
        utenti.add(new Utente(LocalDate.of(2022, 9, 5), "Giulia", "Russo", LocalDate.of(1982, 6, 15)));
        utenti.add(new Utente(LocalDate.of(2022, 4, 30), "Federica", "Arancio", LocalDate.of(1983, 2, 14)));
        utenti.add(new Utente(LocalDate.of(2021, 12, 6), "Giovanni", "Neri", LocalDate.of(1975, 4, 5)));
        utenti.add(new Utente(LocalDate.of(2020, 4, 18), "Alessia", "Marroni", LocalDate.of(1981, 10, 30)));
        for (Utente utente : utenti) {
        	DAO_utente.save(utente);
        }
        
        List<Biglietteria> biglietterie = new ArrayList<>();

        List<Rivenditore> rivenditori = new ArrayList<>();

        rivenditori.add(new Rivenditore(TipoNegozio.BAR, luoghi.get(0)));
        rivenditori.add(new Rivenditore(TipoNegozio.EDICOLA, luoghi.get(0)));
        rivenditori.add(new Rivenditore(TipoNegozio.TABACCHI, luoghi.get(1)));
        rivenditori.add(new Rivenditore(TipoNegozio.BAR, luoghi.get(1)));
        rivenditori.add(new Rivenditore(TipoNegozio.EDICOLA, luoghi.get(2)));
        rivenditori.add(new Rivenditore(TipoNegozio.TABACCHI, luoghi.get(2)));
        rivenditori.add(new Rivenditore(TipoNegozio.BAR, luoghi.get(3)));
        rivenditori.add(new Rivenditore(TipoNegozio.EDICOLA, luoghi.get(3)));
        rivenditori.add(new Rivenditore(TipoNegozio.TABACCHI, luoghi.get(4)));
        rivenditori.add(new Rivenditore(TipoNegozio.BAR, luoghi.get(4)));

        for (Rivenditore rivenditore : rivenditori) {
        	DAO_biglietteria.save(rivenditore);
        	biglietterie.add(rivenditore);
        }
        
        List<Distributore> distributori = new ArrayList<>();

        distributori.add(new Distributore(false, luoghi.get(0)));
        distributori.add(new Distributore(luoghi.get(0)));
        distributori.add(new Distributore(luoghi.get(1)));
        distributori.add(new Distributore(luoghi.get(1)));
        distributori.add(new Distributore(false, luoghi.get(2)));
        distributori.add(new Distributore(luoghi.get(2)));
        distributori.add(new Distributore(luoghi.get(3)));
        distributori.add(new Distributore(luoghi.get(3)));
        distributori.add(new Distributore(luoghi.get(4)));
        distributori.add(new Distributore(false, luoghi.get(4)));

        for (Distributore distributore : distributori) {
        	DAO_biglietteria.save(distributore);
        	biglietterie.add(distributore);
        }
        
        List<Biglietto> biglietti = new ArrayList<>();

        biglietti.add(new Biglietto(LocalDate.of(2023, 5, 1), biglietterie.get(0)));
        biglietti.add(new Biglietto(LocalDate.of(2023, 5, 2), biglietterie.get(1)));
        biglietti.add(new Biglietto(LocalDate.of(2023, 5, 3), biglietterie.get(2)));
        biglietti.add(new Biglietto(LocalDate.of(2023, 5, 4), biglietterie.get(3)));
        biglietti.add(new Biglietto(LocalDate.of(2023, 5, 5), biglietterie.get(4)));
        biglietterie.get(6).emettiBiglietto(DAO_titoloViaggio, DAO_biglietteria);
        biglietterie.get(6).emettiBiglietto(DAO_titoloViaggio, DAO_biglietteria);
        biglietterie.get(7).emettiBiglietto(DAO_titoloViaggio, DAO_biglietteria);
        biglietterie.get(9).emettiBiglietto(DAO_titoloViaggio, DAO_biglietteria);
        biglietterie.get(12).emettiBiglietto(DAO_titoloViaggio, DAO_biglietteria);
        biglietterie.get(16).emettiBiglietto(DAO_titoloViaggio, DAO_biglietteria);


        for (Biglietto biglietto : biglietti) {
        	DAO_titoloViaggio.save(biglietto);
        }
        
        List<Abbonamento> abbonamenti = new ArrayList<>();

        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 5, 1), DurataAbb.SETTIMANALE, biglietterie.get(0), utenti.get(0)));
        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 4, 2), DurataAbb.MENSILE, biglietterie.get(0), utenti.get(1)));
        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 4, 3), DurataAbb.SETTIMANALE, biglietterie.get(4), utenti.get(2)));
        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 5, 8), DurataAbb.MENSILE, biglietterie.get(5), utenti.get(3)));
        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 5, 5), DurataAbb.SETTIMANALE, biglietterie.get(11), utenti.get(4)));
        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 5, 6), DurataAbb.SETTIMANALE, biglietterie.get(13), utenti.get(5)));
        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 5, 7), DurataAbb.MENSILE, biglietterie.get(15), utenti.get(6)));
        abbonamenti.add(new Abbonamento(LocalDate.of(2023, 5, 8), DurataAbb.SETTIMANALE, biglietterie.get(18), utenti.get(7)));
        biglietterie.get(0).emettiAbbonamento(DAO_titoloViaggio, DAO_biglietteria, DurataAbb.SETTIMANALE, utenti.get(0));
        biglietterie.get(15).emettiAbbonamento(DAO_titoloViaggio, DAO_biglietteria, DurataAbb.MENSILE, utenti.get(1));
        biglietterie.get(15).emettiAbbonamento(DAO_titoloViaggio, DAO_biglietteria, DurataAbb.SETTIMANALE, utenti.get(4));
        biglietterie.get(12).emettiAbbonamento(DAO_titoloViaggio, DAO_biglietteria, DurataAbb.MENSILE, utenti.get(5));
        biglietterie.get(11).emettiAbbonamento(DAO_titoloViaggio, DAO_biglietteria, DurataAbb.SETTIMANALE, utenti.get(7));
        biglietterie.get(9).emettiAbbonamento(DAO_titoloViaggio, DAO_biglietteria, DurataAbb.SETTIMANALE, utenti.get(8));

        for (Abbonamento abbonamento : abbonamenti) {
        	DAO_titoloViaggio.save(abbonamento);
        }
        
        
        List<Mezzo> mezzi= new ArrayList<>();
        
        mezzi.add(new Mezzo(TipoMezzo.AUTOBUS,LocalDate.of(2023, 2, 10)));
        mezzi.add(new Mezzo(TipoMezzo.TRAM,LocalDate.of(1996, 12, 26)));
        mezzi.add(new Mezzo(TipoMezzo.AUTOBUS,LocalDate.of(2000,5,16),LocalDate.of(2023, 5, 24)));
        
       
        for (Mezzo mezzo : mezzi) {
        	DAO_mezzo.save(mezzo);
        }
        
        
	}
	
	
}

