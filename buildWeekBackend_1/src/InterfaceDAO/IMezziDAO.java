package InterfaceDAO;

import java.util.List;

import model.Mezzo;


public interface IMezziDAO {
	public void save(Mezzo m);
	public Mezzo getById(Integer id);
	public void delete(Mezzo m);
	public List<Mezzo>  getAllMezzi();
	public List<Mezzo>  getAllAutobus();
	public List<Mezzo>  getAllTram();
	public void update(Mezzo m);
}
