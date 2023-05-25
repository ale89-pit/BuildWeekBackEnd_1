package model;

import java.time.Duration;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="viaggi")
public class Viaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Mezzo mezzo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Tratta tratta;
	
	@Column(name="orario_partenza")
	private LocalTime orarioPartenza;
	
	@Column(name="orario_arrivo")
	private LocalTime orarioArrivo;
	
	@Column(name="tempo_effettivo")
	private Long tempoEffettivo;
	
	
	
	public Viaggio() {
		super();
	}
	
	
	

	public Viaggio(Mezzo mezzo, Tratta tratta, LocalTime orarioPartenza,LocalTime orarioArrivo) {
		super();
		this.mezzo = mezzo;
		this.tratta = tratta;
		this.orarioPartenza = orarioPartenza;
		this.orarioArrivo = orarioArrivo;
		this.tempoEffettivo = (long) orarioArrivo.compareTo(orarioPartenza);
	}




	public Viaggio(Mezzo mezzo, Tratta tratta, LocalTime orarioPartenza) {
		super();
		this.mezzo = mezzo;
		this.tratta = tratta;
		this.orarioPartenza = orarioPartenza;
	}




	public LocalTime getOrarioPartenza() {
		return orarioPartenza;
	}

	public void setOrarioPartenza(LocalTime orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}

	public Long getTempoEffettivo() {
		return tempoEffettivo;
	}

	public void setOrarioArrivo(LocalTime orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
		this.tempoEffettivo = (long) orarioArrivo.compareTo(orarioPartenza);
	}




	public void setTempoEffettivo(Long tempoEffettivo) {
		this.tempoEffettivo = tempoEffettivo;
	}

	public LocalTime getOrarioArrivo() {
		return orarioArrivo;
	}

	@Override
	public String toString() {
		return "Viaggio [mezzo=" + mezzo + ", orarioPartenza=" + orarioPartenza + ", orarioArrivo=" + orarioArrivo
				+ ", tempoEffettivo=" + tempoEffettivo + "]";
	}

	
	
}
