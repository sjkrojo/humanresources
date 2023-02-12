package co.edu.unbosque.model;

import java.io.Serializable;

public class CandidateDTO implements Serializable {

	private String name;
	private String last_name;
	private int id;
	private int age;
	private String rank;

	public CandidateDTO() {

	}

	public CandidateDTO(String name, String last_name, int id, int age, String rank) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.id = id;
		this.age = age;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String toString() {
		String can = "Nombre: " + this.name + "\nApellido: " + this.last_name + "\nID: " + this.id + "\nEdad: "
				+ this.age + "\nRank: " + this.rank + "\n";
		return can;
	}

}
