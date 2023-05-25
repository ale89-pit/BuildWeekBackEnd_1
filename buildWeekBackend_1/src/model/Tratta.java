package model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import utils.TipoMezzo;

@Entity
@Table(name="tratte")
public class Tratta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numero_tratta")
	private Integer numeroTratta;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Luogo.class)
	private Luogo partenza;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Luogo.class)
	private Luogo capolinea;
		
	@Column(name = "km_tratta")
	private double kmTratta;
	
	@Column(name = "tempo_stimato")
	private Long tempoStimato;
	
	@OneToMany(mappedBy = "trattaAssegnata", fetch = FetchType.EAGER)
	private List<Mezzo> mezziSuTratta;

	public Tratta() {
		super();
	}

	public Tratta(Luogo partenza, Luogo capolinea, double kmTratta) {
		super();
		this.partenza = partenza;
		this.capolinea = capolinea;
		this.kmTratta = kmTratta;
	}

	public Integer getNumeroTratta() {
		return numeroTratta;
	}

	public Luogo getPartenza() {
		return partenza;
	}

	public void setPartenza(Luogo partenza) {
		this.partenza = partenza;
	}

	public Luogo getCapolinea() {
		return capolinea;
	}

	public void setCapolinea(Luogo capolinea) {
		this.capolinea = capolinea;
	}

	public double getKmTratta() {
		return kmTratta;
	}

	public void setKmTratta(double kmTratta) {
		this.kmTratta = kmTratta;
		
	}
	
	public Long getTempoStimato() {
		return tempoStimato;
	}
	public void setTempoStimato(Mezzo mezzo) {
		double velocita = mezzo.getTipoMezzo().equals(TipoMezzo.AUTOBUS)? 50: 60; 
		this.tempoStimato = Duration.of(((long) ((kmTratta / velocita)*60.0)), ChronoUnit.MINUTES).toHours();
		System.out.println(tempoStimato);
	}

	public List<Mezzo> getMezziSuTratta() {
		return mezziSuTratta;
	}
	
	
	
	
	
	
}
