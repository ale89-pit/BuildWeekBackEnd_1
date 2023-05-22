package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="titoli_viaggio")
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
	
	@Column(name = "luogo_emissione", nullable = false)
	private Biglietteria luogoEmissione;
	
	
}
