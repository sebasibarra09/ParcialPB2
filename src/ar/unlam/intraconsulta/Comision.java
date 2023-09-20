package ar.unlam.intraconsulta;

public class Comision {

	private Integer id;
	private Alumno alumno;
	private Profesor profesor;
	private Materia materia;
	private CicloElectivo cicloElec;
	private Nota nota;
	private String turno;

	public Comision(Integer id, Alumno alumno, Profesor profesor, Materia materia, CicloElectivo cicloElec, Nota nota, String turno) {
		this.id = id;
		this.alumno = alumno;
		this.profesor = profesor;
		this.materia = materia;
		this.cicloElec = cicloElec;
		this.nota = nota;
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
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
}
