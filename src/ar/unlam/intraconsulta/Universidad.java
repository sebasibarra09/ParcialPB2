package ar.unlam.intraconsulta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<InscripcionMateria> inscripcionesMateria;
	private ArrayList<CicloElectivo> cicloElect;
	private ArrayList<Profesor> profesores;
	private ArrayList<Comision> comisiones;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.cicloElect = new ArrayList<CicloElectivo>();
		this.materias = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.inscripcionesMateria = new ArrayList<>();
	}

	public Boolean agregarMateria(Materia materia) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(materia.getCodigo()))
				return false;
		}
		return this.materias.add(materia);

	}

	public Boolean agregarAlumno(Alumno alumno) {
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(alumno.getDni()))
				return false;
		}
		return this.alumnos.add(alumno);

	}

	public Boolean agregarCicloLectivo(CicloElectivo cicloElectiv) {
		for (int i = 0; i < this.cicloElect.size(); i++) {
			if ((this.cicloElect.get(i).getId().equals(cicloElectiv.getId())) || (this.cicloElect.get(i)
					.getFechaFinalizacionCicloLectivo().isBefore(cicloElectiv.getFechaInicioCicloLectivo())))

				return false;
		}
		return this.cicloElect.add(cicloElectiv);
	}

	public Boolean agregarComision(Comision comi) {
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (((this.comisiones.get(i).getId().equals(comi.getId()))
					|| (this.comisiones.get(i).getMateria().getCodigo().equals(comi.getMateria().getCodigo()))
							&& (this.comisiones.get(i).getCicloElec().getId().equals(comi.getCicloElec().getId()))
							&& (this.comisiones.get(i).getTurno().equals(comi.getTurno()))))
				return false;
		}
		return this.comisiones.add(comi);

	}
	
	public Boolean agregarDocentes(Profesor profe) {
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(profe.getDni()))
				return false;
		}
		return this.profesores.add(profe);
		
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {

		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return this.alumnos.get(i);
		}

		return null;
	}

	public Boolean existeAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	public boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {

		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarMateriaPorCodigo(codigo);

		if (alumno != null && materia != null) {

			InscripcionMateria inscripcionMateria = new InscripcionMateria(alumno, materia);
			return this.inscripcionesMateria.add(inscripcionMateria);

		}

		return false;
	}

	private Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo))
				return this.materias.get(i);
		}
		return null;
	}

}
