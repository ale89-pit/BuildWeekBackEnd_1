package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="biglietterie")
@Inheritance(strategy = InheritanceType.JOINED)
public class Biglietteria {

	@Id
	@SequenceGenerator(name = "id_biglietteria", sequenceName = "id_biglietteria", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_biglietteria")
	private Integer id;

	@ManyToOne
	@Column(nullable=false)
	private Luogo luogo;
	
	
	@OneToMany(mappedBy = "luogoEmissione")
	@Column(nullable=false)
	private List<TitoloViaggio> titoliEmessi = new ArrayList<TitoloViaggio>();


	
	public Biglietteria() {
		super();
	}

	public Biglietteria(Luogo luogo, List<TitoloViaggio> titoliEmessi) {
		super();
		this.luogo = luogo;
		this.titoliEmessi = titoliEmessi;
	}

	public Integer getId() {
		return id;
	}


	public Luogo getLuogo() {
		return luogo;
	}

	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

	public List<TitoloViaggio> getTitoliEmessi() {
		return titoliEmessi;
	}

	public void setTitoliEmessi(List<TitoloViaggio> titoliEmessi) {
		this.titoliEmessi = titoliEmessi;
	}

	@Override
	public String toString() {
		return "Biglietteria [id=" + id + ", luogo=" + luogo + ", titoliEmessi=" + titoliEmessi + "]";
	}
	
	
}
