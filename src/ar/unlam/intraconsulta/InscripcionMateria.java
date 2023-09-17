package ar.unlam.intraconsulta;

public class InscripcionMateria {

	private Alumno alumno;
	private Materia materia;
	/*private Nota nota;*/

	public InscripcionMateria(Alumno alumno, Materia materia) {
		this.alumno=alumno;
		this.materia = materia;
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
