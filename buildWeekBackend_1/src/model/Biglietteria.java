package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import DAO.BiglietteriaDAO;
import DAO.TitoloViaggioDAO;
import DAO.UtenteDAO;
import utils.DurataAbb;

@Entity
@Table(name="biglietterie")
@DiscriminatorColumn(name="tipo_biglietteria", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Biglietteria {

	@Id
	@SequenceGenerator(name = "id_biglietteria", sequenceName = "id_biglietteria", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_biglietteria")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Luogo luogo;
	
	@OneToMany(mappedBy = "biglietteriaEmissione", fetch = FetchType.EAGER)
	private List<TitoloViaggio> titoliEmessi = new ArrayList<TitoloViaggio>();


	public Biglietteria() {
		super();
	}

	public Biglietteria(Luogo luogo) {
		super();
		this.luogo = luogo;
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
		return "Biglietteria [id=" + id + ", luogo=" + luogo + ", titoliEmessi=" + titoliEmessi.size() + "]";
	}
	
	public TitoloViaggio getUltimoTitolo() {
		
		TitoloViaggio ultimoTitolo = new TitoloViaggioDAO().getAllTitoli().get(new TitoloViaggioDAO().getAllTitoli().size() - 1);
		
		return ultimoTitolo;
	}
	
	public void emettiTitolo(DurataAbb durata, Integer numeroTessera ) {
		
		if (this.id != null) {
			
			Biglietteria biglietteriaEmissione = new BiglietteriaDAO().getById(this.id);
			TitoloViaggio t;
			
			if (durata!= DurataAbb.GIORNALIERO) {
				if (numeroTessera != null) {
				Utente titolare = new UtenteDAO().getByN_tessera(numeroTessera);
				t= new Abbonamento(durata, biglietteriaEmissione, titolare);
				} else {
					System.out.println("Per acquistare un abbonamento, inserisci il tuo numero tessera!");
				}
			}
			
			else {
				t= new Biglietto(biglietteriaEmissione);
			}
			
			new TitoloViaggioDAO().save(t);
		}
		else {
			System.out.println("Id non presente!");
		}
	}
	
	
}
