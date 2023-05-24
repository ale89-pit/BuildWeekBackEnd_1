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
	
	
	public void vidimato(TitoloViaggio t) {
		
		
		
	}
}
