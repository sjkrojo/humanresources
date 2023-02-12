package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileController;

public class CandidateDAO implements OperationsDAO {

	private ArrayList<CandidateDTO> list;
	private FileController fc;

	public CandidateDAO() {
		// Carga el serializable si no existe crea una lista nueva para ser usada y
		// guardad
		try {
			fc = new FileController();
			fc.initEntrada("saves");
			list = (ArrayList<CandidateDTO>) fc.leerSerializado();
			fc.cerrarLector();
		} catch (Exception e) {
			list = new ArrayList<CandidateDTO>();
		}
	}

	// Registra la nueva entrada de la lista en el archivo serializable
	public void register(Object o) {
		list.add((CandidateDTO) o);
		fc.initSalida("saves");
		fc.escribirSerializado(list);
		fc.cerrarSerializado();

	}

	// Modifica un registro por su ID y actualiza el archivo serializable
	public Boolean modify(String name, String last_name, int id, int age, String rank, int id_change) {
		boolean est = false;
		for (int x = 0; x < list.size(); x++) {
			if (id_change == list.get(x).getId()) {
				list.get(x).setName(name);
				list.get(x).setLast_name(last_name);
				list.get(x).setId(id);
				list.get(x).setAge(age);
				list.get(x).setRank(rank);
				fc.initSalida("saves");
				fc.escribirSerializado(list);
				fc.cerrarSerializado();
				est = true;
				break;
			}
		}

		return est;

	}

	// Crea un nuevo registro para ser usado
	public CandidateDTO create(String name, String last_name, int id, int age, String rank) {
		return new CandidateDTO(name, last_name, id, age, rank);

	}

	// Busca un registro y lo devuelve para ser usado
	public CandidateDTO showID(int id) {
		CandidateDTO ret = null;
		for (int x = 0; x < list.size(); x++) {
			if (id == list.get(x).getId()) {
				ret = list.get(x);
			}
		}
		return ret;

	}

	// Crea toda una lista de las IDs registradas
	public String idlist() {
		String st = "";
		for (int x = 0; x < list.size(); x++) {
			st += list.get(x).getId() + "\n";
		}
		return st;
	}

	// Elimina un registro de la lista y actualiza el archivo serializable
	public Boolean erase(int id) {
		boolean est = false;
		for (int x = 0; x < list.size(); x++) {
			if (id == list.get(x).getId()) {
				list.remove(x);
				fc.initSalida("save");
				fc.escribirSerializado(list);
				fc.cerrarSerializado();
				est = true;
			}
		}

		return est;

	}

}
