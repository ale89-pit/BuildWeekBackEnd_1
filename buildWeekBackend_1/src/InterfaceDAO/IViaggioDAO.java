package InterfaceDAO;

import java.util.List;

import model.Viaggio;

public interface IViaggioDAO {
		public void save(Viaggio v);
		public Viaggio getById(Integer id);
		public void delete(Viaggio v);
		public void update(Viaggio v);
		public List<Viaggio> getAllViaggi();
}
