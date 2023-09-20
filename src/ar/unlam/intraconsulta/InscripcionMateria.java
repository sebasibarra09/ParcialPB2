package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class InscripcionMateria {

	private Alumno alumno;
	private Materia materia;
	private Boolean correlatividad;
	private Materia correlativa;
	private ArrayList<Materia> materiasAprobadas;
	/*private Nota nota;*/

	public InscripcionMateria(Alumno alumno, Materia materia) {
		this.alumno=alumno;
		this.materia = materia;
	}
	
	public Boolean InscripcionMateriaConCorrelativa (Alumno alumno, Materia materia, Boolean Correlatividad, Materia correlativa, ArrayList<Materia> materiasAprobadas) {
		if (correlatividad == true) {
			materiasAprobadas.equals(correlativa.getCodigo());
		}
		return true;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	
}
