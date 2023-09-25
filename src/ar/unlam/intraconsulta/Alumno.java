package ar.unlam.intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno {

	private Integer dni;
	private LocalDate fechaNacimiento;
	private String apellido;
	private String nombre;
	private ArrayList<Materia> materiasAprobadas = new ArrayList<>();
	private ArrayList<Integer> notasMaterias = new ArrayList<>();

	public Alumno(Integer dni, LocalDate fechaNacimiento, String apellido, String nombre) {
		super();

		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.apellido = apellido;
		this.nombre = nombre;
	}
	
	

	public Alumno(Integer dni, LocalDate fechaNacimiento, String apellido, String nombre,
			ArrayList<Materia> materiasAprobadas, ArrayList<Integer> notasMaterias) {
		super();
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.materiasAprobadas = materiasAprobadas;
		this.notasMaterias = notasMaterias;
	}
	
	public void agregarMateria(Materia mat) {
		materiasAprobadas.add(mat);
	}
	
	public void agregarNotas(Integer nota) {
		notasMaterias.add(nota);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}



	public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}



	public ArrayList<Integer> getNotasMaterias() {
		return notasMaterias;
	}



	public void setNotasMaterias(ArrayList<Integer> notasMaterias) {
		this.notasMaterias = notasMaterias;
	}

}
