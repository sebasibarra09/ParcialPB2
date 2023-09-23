package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Comision {

	private Integer id;
	private ArrayList<Alumno> alumnos;
	private Profesor profesor;
	private Materia materia;
	private CicloElectivo cicloElec;
	private Nota nota;
	private String turno;

	public Comision(Integer id, Alumno alumno, Profesor profesor, Materia materia, CicloElectivo cicloElec, Nota nota,
			String turno) {
		super();
		this.id = id;
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = profesor;
		this.materia = materia;
		this.cicloElec = cicloElec;
		this.nota = nota;
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloElectivo getCicloElec() {
		return cicloElec;
	}

	public void setCicloElec(CicloElectivo cicloElec) {
		this.cicloElec = cicloElec;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	
}
