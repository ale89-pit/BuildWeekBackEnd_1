package InterfaceDAO;

import java.util.List;


import model.Tratta;

public interface ITrattaDAO {
	public void save(Tratta m);
	public Tratta getById(Integer id);
	public void delete(Tratta m);
	public void update(Tratta m);
	public List<Tratta>  getAllTratte();

}
