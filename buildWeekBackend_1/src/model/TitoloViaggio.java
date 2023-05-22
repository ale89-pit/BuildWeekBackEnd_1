package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import utils.DurataAbb;

@Entity
@Table(name="titoli_viaggio")
@DiscriminatorColumn(name="tipo_biglietto", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class TitoloViaggio {
	
	@Id
	@SequenceGenerator(name = "codice_biglietto", sequenceName = "codice_biglietto", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codice_biglietto")
	private Integer codice;
	
	@Column(name = "data_emissione", nullable = false)
	private LocalDate dataEmissione;
	
	@Column(name = "data_scadenza", nullable = false)
	private LocalDate dataScadenza;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private DurataAbb durata;
	
	@Column(nullable = false)
	private boolean validita;
	
	@ManyToOne
	@JoinColumn(name = "luogo_emissione", nullable = false)
	private Biglietteria luogoEmissione;

	
	
	public TitoloViaggio() {
		super();
	}

	public TitoloViaggio(LocalDate dataEmissione, LocalDate dataScadenza, DurataAbb durata, boolean validita,
			Biglietteria luogoEmissione) {
		super();
		this.dataEmissione = dataEmissione;
		this.dataScadenza = dataScadenza;
		this.durata = durata;
		this.validita = validita;
		this.luogoEmissione = luogoEmissione;
	}

	public Integer getCodice() {
		return codice;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public DurataAbb getDurata() {
		return durata;
	}

	public void setDurata(DurataAbb durata) {
		this.durata = durata;
	}

	public boolean isValidita() {
		return validita;
	}

	public void setValidita(boolean validita) {
		this.validita = validita;
	}

	public Biglietteria getLuogoEmissione() {
		return luogoEmissione;
	}

	public void setLuogoEmissione(Biglietteria luogoEmissione) {
		this.luogoEmissione = luogoEmissione;
	}

	@Override
	public String toString() {
		return "TitoloViaggio [codice=" + codice + ", dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza
				+ ", durata=" + durata + ", validita=" + validita + ", luogoEmissione=" + luogoEmissione + "]";
	}
	
	
}
