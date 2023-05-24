package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import DAO.MezzoDAO;
import DAO.TitoloViaggioDAO;
import utils.Status;
import utils.TipoMezzo;

@Entity
@Table(name="mezzi")
public class Mezzo {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	
	private Integer capienza;
	
	@Enumerated(EnumType.STRING)
	private Status stato;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_mezzo")
	private TipoMezzo tipoMezzo;
	
	@Column(name="inizio_servizio")
	private LocalDate inizioServizio;
	
	@Column(name="fine_servizio")
	private LocalDate fineServizio;
	
	@OneToMany(mappedBy = "utilizzatoSu", fetch = FetchType.EAGER)
	private List<Biglietto> vidimati  = new ArrayList<Biglietto>();
	

	public Mezzo() {
		super();
	}



	public Mezzo(TipoMezzo tipoMezzo, LocalDate inizioServizio, LocalDate fineServizio) {
		super();
		this.stato = (fineServizio.compareTo(LocalDate.now())>0)? Status.IN_SERVIZIO : Status.IN_MANUTENZIONE;
		this.inizioServizio = inizioServizio;
		this.fineServizio = fineServizio;
		this.tipoMezzo=tipoMezzo;
		
		this.capienza= tipoMezzo.equals(TipoMezzo.TRAM) ?  4 : 6; 
	}
	
	public Mezzo(TipoMezzo tipoMezzo, LocalDate inizioServizio) {
		super();
		this.inizioServizio = inizioServizio;
		this.tipoMezzo=tipoMezzo;
		this.stato=Status.IN_SERVIZIO;
		this.capienza= tipoMezzo.equals(TipoMezzo.TRAM) ?  4 : 6; 
	}
	

	public Status getStato() {
	return	(this.fineServizio.compareTo(LocalDate.now())>0)? Status.IN_SERVIZIO : Status.IN_MANUTENZIONE;
		
	}


	public LocalDate getInizioServizio() {
		return inizioServizio;
	}

	public void setInizioServizio(LocalDate inizioServizio) {
		this.inizioServizio = inizioServizio;
	}

	public LocalDate getFineServizio() {
		return fineServizio;
	}

	public void setFineServizio(LocalDate fineServizio) {
		this.fineServizio = fineServizio;
	}

	public Integer getCapienza() {
		return capienza;
	}



	public Integer getId() {
		return id;
	}



	public TipoMezzo getTipoMezzo() {
		return tipoMezzo;
	}
	
	
	public void validaBiglietto(Biglietto b) {
		if(this.id!=null) {
	if(b.getCodice()!=null) {
		if(!b.isVidimato()) {
			MezzoDAO DAO_mezzo=new MezzoDAO();
			Mezzo mezzo=DAO_mezzo.getById(this.id);
			TitoloViaggioDAO DAO_titolo =new TitoloViaggioDAO();
			Biglietto biglietto=(Biglietto)DAO_titolo.getByCodice(b.getCodice());
			
			biglietto.setUtilizzato(mezzo);
			System.out.println("Questo biglietto è stato vidimato");
			DAO_titolo.update(biglietto);
			DAO_mezzo.update(mezzo);
		}else {
			System.out.println("Questo biglietto è stato già utilizzato");
		}
		
		
	}else {
		System.out.println("Biglietto non riconosciuto");
	}
		}
	}


	public void validaAbbonamento(Abbonamento a) {
		
		if(this.id!=null) {
	if(a.getCodice()!=null) {
		if(a.getDataScadenza().compareTo(LocalDate.now())>0) {
			MezzoDAO DAO_mezzo=new MezzoDAO();
			Mezzo mezzo=DAO_mezzo.getById(this.id);
			TitoloViaggioDAO DAO_titolo =new TitoloViaggioDAO();
			Abbonamento abbanamento=(Abbonamento)DAO_titolo.getByCodice(a.getCodice());
			
			
			System.out.println("Questo Abbonamento è ancora valido");

		}else {
			System.out.println("Questo Abbonamento è scaduto");
		}
		
		
	}else {
		System.out.println("Abbonamento non riconosciuto");
	}
		}
	}

		
	



	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", capienza=" + capienza + ", stato=" + stato + ", tipoMezzo=" + tipoMezzo
				+ ", inizioServizio=" + inizioServizio + ", fineServizio=" + fineServizio + ", vidimati=" + vidimati
				+ "]";
	}
	
}
